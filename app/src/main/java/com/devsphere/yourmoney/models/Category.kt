package com.devsphere.yourmoney.models

import androidx.compose.ui.graphics.Color
import io.realm.kotlin.types.RealmObject

class Category(): RealmObject {
    private var _colorValue: ULong = ULong.MIN_VALUE
    lateinit var name: String

    val color: Color
        get() = Color(_colorValue)

    constructor(
        name: String,
        color: Color
    ): this() {
        this.name = name
        this._colorValue = color.value
    }
}