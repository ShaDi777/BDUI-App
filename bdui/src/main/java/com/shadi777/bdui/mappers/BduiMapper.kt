package com.shadi777.bdui.mappers

import android.content.Context
import android.view.View
import com.shadi777.bdui.dispatcher.BduiActionDispatcher
import com.shadi777.bdui.models.BduiModel
import com.shadi777.design.components.ButtonView
import com.shadi777.design.components.HorizontalScrollView
import com.shadi777.design.components.IconView
import com.shadi777.design.components.LabelView
import com.shadi777.design.components.LoaderView
import com.shadi777.design.components.SliderView
import com.shadi777.design.components.StackView
import com.shadi777.design.components.TextInputView
import com.shadi777.design.components.VerticalScrollView
import com.shadi777.design.models.ButtonViewModel
import com.shadi777.design.models.IconViewModel
import com.shadi777.design.models.LabelViewModel
import com.shadi777.design.models.LoaderViewModel
import com.shadi777.design.models.ScrollViewModel
import com.shadi777.design.models.SliderViewModel
import com.shadi777.design.models.StackViewModel
import com.shadi777.design.models.TextInputViewModel

interface BduiMapper {
    fun map(model: BduiModel, context: Context): View
}

class BduiMapperImpl(
    private val dispatcher: BduiActionDispatcher
) : BduiMapper {

    override fun map(model: BduiModel, context: Context): View {
        return when (model) {

            is BduiModel.Button -> ButtonView(context).apply {
                val viewModel = ButtonViewModel(
                    text = model.text,
                    style = model.style,
                    colorScheme = model.colorScheme,
                    typography = model.typography,
                    layout = model.layout,
                    onClickAction = { dispatcher.dispatch(model.action, context) }
                )
                configure(viewModel)
            }

            is BduiModel.Icon -> IconView(context).apply {
                val viewModel = IconViewModel(
                    name = model.name,
                    size = model.size,
                    layout = model.layout,
                )
                configure(viewModel)
            }

            is BduiModel.Label -> LabelView(context).apply {
                val viewModel = LabelViewModel(
                    text = model.text,
                    typography = model.typography,
                    style = model.style,
                    layout = model.layout
                )
                configure(viewModel)
            }

            is BduiModel.Loader -> LoaderView(context).apply {
                val viewModel = LoaderViewModel(
                    strokeWidth = model.strokeWidth,
                    layout = model.layout,
                )
                configure(viewModel)
            }

            is BduiModel.Slider -> SliderView(context).apply {
                val viewModel = SliderViewModel(
                    min = model.min,
                    max = model.max,
                    value = model.value,
                    step = model.step,
                    style = model.style,
                    layout = model.layout,
                )
                configure(viewModel)
            }

            is BduiModel.TextInput -> TextInputView(context).apply {
                val viewModel = TextInputViewModel(
                    hint = model.hint,
                    typography = model.typography,
                    style = model.style,
                    layout = model.layout,
                    initialValue = model.initialValue,
                    validationRegex = model.validationRegex,
                )
                configure(viewModel)
            }

            is BduiModel.Column -> StackView(context).apply {
                val viewModel = StackViewModel(
                    orientation = StackViewModel.Orientation.VERTICAL,
                    layout = model.layout,
                )
                configure(viewModel)
                model.children.map { map(it, context) }.forEach(::addView)
            }

            is BduiModel.Row -> StackView(context).apply {
                val viewModel = StackViewModel(
                    orientation = StackViewModel.Orientation.HORIZONTAL,
                    layout = model.layout,
                )
                configure(viewModel)
                model.children.map { map(it, context) }.forEach(::addView)
            }

            is BduiModel.Scroll -> {
                val viewModel = ScrollViewModel(
                    model.orientation,
                    model.layout
                )
                when (model.orientation) {
                    ScrollViewModel.Orientation.HORIZONTAL -> HorizontalScrollView(context).apply {
                        configure(viewModel)
                        model.children.map { map(it, context) }.forEach(::addView)
                    }

                    ScrollViewModel.Orientation.VERTICAL -> VerticalScrollView(context).apply {
                        configure(viewModel)
                        model.children.map { map(it, context) }.forEach(::addView)
                    }
                }
            }
        }
    }
}
