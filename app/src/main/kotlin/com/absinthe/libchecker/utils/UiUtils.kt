package com.absinthe.libchecker.utils

import android.graphics.Color
import androidx.annotation.ColorInt
import com.absinthe.libchecker.constant.Constants
import com.absinthe.libchecker.constant.GlobalValues
import com.absinthe.libraries.utils.utils.UiUtils.isDarkMode
import rikka.material.app.DayNightDelegate

object UiUtils {
  fun getRandomColor(): Int {
    val range = if (isDarkMode()) {
      (68..136)
    } else {
      (132..200)
    }
    val r = range.random()
    val g = range.random()
    val b = range.random()

    return Color.parseColor(String.format("#%02x%02x%02x", r, g, b))
  }

  fun isDarkColor(@ColorInt color: Int): Boolean {
    val r = Color.red(color)
    val g = Color.green(color)
    val b = Color.blue(color)
    val brightness = (r * 299 + g * 587 + b * 114) / 1000
    return brightness >= 192
  }

  fun getNightMode(): Int {
    return when (GlobalValues.darkMode) {
      Constants.DARK_MODE_OFF -> DayNightDelegate.MODE_NIGHT_NO
      Constants.DARK_MODE_ON -> DayNightDelegate.MODE_NIGHT_YES
      Constants.DARK_MODE_FOLLOW_SYSTEM -> DayNightDelegate.MODE_NIGHT_FOLLOW_SYSTEM
      else -> DayNightDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }
  }
}
