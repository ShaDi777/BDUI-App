package com.shadi777.bdui.models

import com.shadi777.design.models.ButtonViewModel
import com.shadi777.design.models.IconViewModel
import com.shadi777.design.models.LabelViewModel
import com.shadi777.design.models.ScrollViewModel
import com.shadi777.design.models.SliderViewModel
import com.shadi777.design.models.TextInputViewModel
import com.shadi777.design.types.LayoutModifiers
import com.shadi777.design.types.Typography
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("type")
sealed class BduiModel {

    /**
     * Views
     */
    @Serializable
    @SerialName("Button")
    data class Button(
        val text: String,
        val style: ButtonViewModel.ButtonStyle = ButtonViewModel.ButtonStyle.FILLED,
        val colorScheme: ButtonViewModel.ButtonColorScheme = ButtonViewModel.ButtonColorScheme.PRIMARY,
        val typography: Typography = Typography.BODY2,
        val layout: LayoutModifiers = LayoutModifiers(),
        val action: BduiAction = BduiAction.None
    ) : BduiModel()

    @Serializable
    @SerialName("Icon")
    data class Icon(
        val name: String,
        val size: IconViewModel.Size = IconViewModel.Size.M,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()

    @Serializable
    @SerialName("Label")
    data class Label(
        val text: String,
        val typography: Typography = Typography.BODY1,
        val style: LabelViewModel.LabelStyle = LabelViewModel.LabelStyle.PRIMARY,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()

    @Serializable
    @SerialName("Loader")
    data class Loader(
        val layout: LayoutModifiers = LayoutModifiers(),
        val strokeWidth: Int = 8,
    ) : BduiModel()

    @Serializable
    @SerialName("Slider")
    data class Slider(
        val min: Float = 0f,
        val max: Float = 100f,
        val value: Float = 50f,
        val step: Float = 1f,
        val style: SliderViewModel.SliderStyle = SliderViewModel.SliderStyle.FILLED,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()

    @Serializable
    @SerialName("TextInput")
    data class TextInput(
        val hint: String,
        val typography: Typography = Typography.BODY2,
        val style: TextInputViewModel.TextInputStyle = TextInputViewModel.TextInputStyle.NORMAL,
        val layout: LayoutModifiers = LayoutModifiers(),
        val initialValue: String? = null,
        val validationRegex: String? = null
    ) : BduiModel()


    /**
     * ViewGroups
     */
    @Serializable
    @SerialName("Column")
    data class Column(
        val children: List<BduiModel>,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()

    @Serializable
    @SerialName("Row")
    data class Row(
        val children: List<BduiModel>,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()

    @Serializable
    @SerialName("Scroll")
    data class Scroll(
        val orientation: ScrollViewModel.Orientation,
        val children: List<BduiModel>,
        val layout: LayoutModifiers = LayoutModifiers()
    ) : BduiModel()
}
