package com.shadi777.bdui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shadi777.bdui.models.BduiConfig
import com.shadi777.design.components.LoaderView
import com.shadi777.design.components.ToolbarView
import com.shadi777.design.models.LoaderViewModel
import com.shadi777.design.models.ToolbarViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class BduiScreenActivity : AppCompatActivity() {
    private val viewModel: BduiScreenViewModel by viewModels {
        BduiScreenViewModel.Factory(
            intent.getStringExtra(BDUI_CONFIG_EXTRA)?.let {
                Json.decodeFromString(BduiConfig.serializer(), it)
            } ?: error("Missing config in Intent")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("UiState", "onCreate:${viewModel.bduiKey}")

        val root = FrameLayout(this).apply { id = View.generateViewId() }

        root.addView(
            LoaderView(this).apply {
                configure(LoaderViewModel())
            }
        )
        setContentView(root)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { view ->
                    view?.let {
                        (view.parent as? ViewGroup)?.removeAllViews()

                        val toolbar = ToolbarView(this@BduiScreenActivity).apply {
                            val toolbarViewModel = ToolbarViewModel(
                                backEnabled = !isTaskRoot,
                                text = viewModel.bduiKey,
                            )
                            configure(toolbarViewModel)
                        }
                        root.addView(toolbar)

                        val contentParams = FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.MATCH_PARENT
                        ).apply {
                            topMargin = toolbar.layoutParams.height.takeIf { it > 0 }
                                ?: 56.dp(this@BduiScreenActivity)
                        }
                        root.addView(it, contentParams)
                    }
                }
            }
        }

        setContentView(root)

        viewModel.loadIfNeeded(this)
    }

    private fun Int.dp(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }

    override fun onStart() {
        super.onStart()
        Log.d("UiState", "onStart:${viewModel.bduiKey}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("UiState", "onResume:${viewModel.bduiKey}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("UiState", "onPause:${viewModel.bduiKey}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("UiState", "onStop:${viewModel.bduiKey}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("UiState", "onDestroy:${viewModel.bduiKey}")
    }

    companion object {
        private const val BDUI_CONFIG_EXTRA = "bdui_config"

        fun newIntent(context: Context, config: BduiConfig): Intent {
            return Intent(context, BduiScreenActivity::class.java).apply {
                val configJson = Json.encodeToString(BduiConfig.serializer(), config)
                putExtra(BDUI_CONFIG_EXTRA, configJson)
            }
        }
    }
}
