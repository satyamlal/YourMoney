package com.devsphere.yourmoney.utils

import java.text.DecimalFormat

fun simplifyNumber(value: Float): String {
    return when {
        value >= 1e9 -> "${"%.2f".format(value/1e9)} B"
        value >= 1e7 -> "${"%.2f".format(value/1e7)} Cr"
        value >= 1e6 -> "${"%.2f".format(value/1e6)} M"
        value >= 1e5 -> "${"%.2f".format(value/1e5)} L"
        value >= 1e3 -> "${"%.2f".format(value/1e3)} K"
        else -> "%.0f".format(value)
    }
}