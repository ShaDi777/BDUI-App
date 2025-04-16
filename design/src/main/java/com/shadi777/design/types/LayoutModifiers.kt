package com.shadi777.design.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LayoutModifiers(
    val width: Size = Size.Wrap,
    val height: Size = Size.Wrap,
    val margin: SpacingSet = SpacingSet(),
    val padding: SpacingSet = SpacingSet(),
    val weight: Float? = null,
) {
    @Serializable
    sealed class Size {
        @Serializable
        @SerialName("Fixed")
        data class Fixed(val dp: Int) : Size()

        @Serializable
        @SerialName("Wrap")
        data object Wrap : Size()

        @Serializable
        @SerialName("Match")
        data object Match : Size()

        companion object {
            fun dp(value: Int): Size = Fixed(value)
        }
    }

    @Serializable
    data class SpacingSet(
        val left: Spacing = Spacing.NONE,
        val top: Spacing = Spacing.NONE,
        val right: Spacing = Spacing.NONE,
        val bottom: Spacing = Spacing.NONE,
    )
}
