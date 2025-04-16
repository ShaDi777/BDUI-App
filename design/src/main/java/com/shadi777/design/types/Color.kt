package com.shadi777.design.types

enum class Color(
    private val hexValue: String,
) {
    BACKGROUND_DEFAULT("#F7F6F2"),
    TEXT_PRIMARY("#1E1E1E"),
    TEXT_SECONDARY("#757575"),
    TEXT_TERTIARY("#9A9A9A"),

    BACKGROUND_BRAND_PRIMARY("#2C2C2C"),
    TEXT_ON_BACKGROUND_PRIMARY("#F5F5F5"),

    BACKGROUND_BRAND_SECONDARY("#E6E6E6"),
    TEXT_ON_BACKGROUND_SECONDARY("#1E1E1E"),

    BACKGROUND_BRAND_TERTIARY("#F5F5F5"),
    TEXT_ON_BACKGROUND_TERTIARY("#2C2C2C"),

    BACKGROUND_POSITIVE("#14AE5C"),
    TEXT_ON_BACKGROUND_POSITIVE("#EBFFEE"),

    BACKGROUND_WARNING("#E8B931"),
    TEXT_ON_BACKGROUND_WARNING("#401B01"),

    BACKGROUND_DANGER("#EC221F"),
    TEXT_ON_BACKGROUND_DANGER("#FEE9E7"),
    ;

    val value: Int
        get() = parseColor(this.hexValue)

    companion object {
        fun parseColor(enumOrHexValue: String): Int {
            return runCatching {
                if (enumOrHexValue.startsWith("#")) {
                    android.graphics.Color.parseColor(enumOrHexValue)
                } else {
                    Color.valueOf(enumOrHexValue).value
                }
            }.getOrDefault(0)
        }
    }
}
