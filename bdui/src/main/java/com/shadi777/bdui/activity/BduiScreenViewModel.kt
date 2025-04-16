package com.shadi777.bdui.activity

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shadi777.bdui.BuildConfig
import com.shadi777.bdui.dispatcher.BduiActionDispatcherImpl
import com.shadi777.bdui.mappers.BduiMapper
import com.shadi777.bdui.mappers.BduiMapperImpl
import com.shadi777.bdui.models.BduiConfig
import com.shadi777.bdui.network.BduiApiService
import com.shadi777.bdui.network.RetrofitBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BduiScreenViewModel(
    private val config: BduiConfig,
    private val mapper: BduiMapper,
    private val api: BduiApiService,
) : ViewModel() {

    val bduiKey: String
        get() = config.key

    private val _uiState = MutableStateFlow<View?>(null)
    val uiState: StateFlow<View?> = _uiState

    private var isLoaded = false

    fun loadIfNeeded(context: Context) {
        if (isLoaded) return

        isLoaded = true

        viewModelScope.launch {
            val jsonModel = api.loadBDUI(config.key)
            val view = mapper.map(jsonModel, context)
            _uiState.value = view
        }
    }

    class Factory(
        private val config: BduiConfig
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BduiScreenViewModel(
                config,
                mapper = BduiMapperImpl(BduiActionDispatcherImpl()),
                api = RetrofitBuilder.provideApiService(
                    BuildConfig.ALFA_USERNAME,
                    BuildConfig.ALFA_PASSWORD,
                )
            ) as T
        }
    }
}
