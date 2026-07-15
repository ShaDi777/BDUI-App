package com.shadi777.bdui.activity

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shadi777.bdui.dispatcher.BduiActionDispatcherImpl
import com.shadi777.bdui.mappers.BduiMapper
import com.shadi777.bdui.mappers.BduiMapperImpl
import com.shadi777.bdui.models.BduiConfig
import com.shadi777.bdui.models.BduiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class BduiScreenViewModel(
    private val config: BduiConfig,
    private val mapper: BduiMapper,
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
            val jsonModel = getBduiModelByKey(config.key)
            val view = mapper.map(jsonModel, context)
            _uiState.value = view
        }
    }

    private fun getBduiModelByKey(key: String): BduiModel {
        val jsonString = when (key.lowercase()) {
            "main-menu" -> com.shadi777.bdui.Constants.mainMenu
            "button-showcase" -> com.shadi777.bdui.Constants.buttonShowcase
            "input-showcase" -> com.shadi777.bdui.Constants.inputShowcase
            "label-showcase" -> com.shadi777.bdui.Constants.labelShowcase
            "icon-showcase" -> com.shadi777.bdui.Constants.iconShowcase
            "slider-showcase" -> com.shadi777.bdui.Constants.sliderShowcase
            "infinite-loaders" -> com.shadi777.bdui.Constants.infiniteLoaders
            "test-sample" -> com.shadi777.bdui.Constants.testSample
            else -> com.shadi777.bdui.Constants.mainMenu
        }
        return Json.decodeFromString<BduiModel>(jsonString)
    }

    class Factory(
        private val config: BduiConfig
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BduiScreenViewModel(
                config,
                mapper = BduiMapperImpl(BduiActionDispatcherImpl()),
            ) as T
        }
    }
}
