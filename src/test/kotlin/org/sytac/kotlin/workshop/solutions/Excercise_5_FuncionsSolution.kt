package org.sytac.kotlin.workshop.solutions

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isNotEmpty
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.Locale
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.RunnerFixture

object Excercise_5_FuncionsSolution {


    fun generateRandomString(length: Int = 10): String =
        (('a'..'z') + ('A'..'Z')).run { (1..length)
            .map { this.random() }.joinToString("") }



    @Test
    fun `add 2 random string gear to the runner - use apply {} to apply addGear(), use spread operator - pass gear as as an array and then list, see difference`() {
        val gear: List<String> = listOf(generateRandomString(5), generateRandomString(5))
        val gear2 = arrayOf(generateRandomString(10), generateRandomString(5))

        val runnerWithGear = RunnerFixture.SIMPLE_RUNNER.apply {
            addGear(*gear.toTypedArray())
            addGear(*gear2)
        }
        //uncomment below to check your solution
        assertThat(runnerWithGear.gear).isNotEmpty()
        assertThat(runnerWithGear.gear).hasSize(4)
    }

    fun DayOfWeek.isWeekend(): Boolean = this == DayOfWeek.SATURDAY || this == DayOfWeek.SUNDAY

    fun String?.removeBrackets(): String =
        this?.replace("[", "")?.replace("]", "") ?: ""


    fun String.reverseWords(): String =
        this.split(" ") // we can skip this
            .map { it.reversed() }
            .joinToString { "" }

}