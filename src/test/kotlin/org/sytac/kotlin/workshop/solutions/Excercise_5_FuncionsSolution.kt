package org.sytac.kotlin.workshop.solutions

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.Locale

object Excercise_5_FuncionsSolution {

    fun DayOfWeek.isWeekend(): Boolean = this == DayOfWeek.SATURDAY || this == DayOfWeek.SUNDAY

    fun String?.removeBrackets(): String =
        this?.replace("[", "")?.replace("]", "") ?: ""


    fun String.reverseWords(): String =
        this.split(" ") // we can skip this
            .map { it.reversed() }
            .joinToString { "" }

}