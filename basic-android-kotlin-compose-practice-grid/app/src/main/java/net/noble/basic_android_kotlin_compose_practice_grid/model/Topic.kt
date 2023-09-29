package net.noble.basic_android_kotlin_compose_practice_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val name: Int,
    val availableCourses: Int,
    @DrawableRes val imageRes: Int
)