package com.shadi777.design.types

private const val LIGHT_WEIGHT = 300
private const val NORMAL_WEIGHT = 400
private const val MEDIUM_WEIGHT = 500

enum class Typography(
    val fontSizeSp: Int,
    val fontWeight: Int,
) {
    H1(60, LIGHT_WEIGHT),
    H2(48, LIGHT_WEIGHT),
    H3(32, NORMAL_WEIGHT),
    H4(24, NORMAL_WEIGHT),
    H5(20, NORMAL_WEIGHT),
    H6(18, MEDIUM_WEIGHT),
    BODY1(16, MEDIUM_WEIGHT),
    BODY2(14, MEDIUM_WEIGHT),
    SUBTITLE1(16, NORMAL_WEIGHT),
    SUBTITLE2(14, NORMAL_WEIGHT),
    CAPTION(12, LIGHT_WEIGHT),
    ;
}
