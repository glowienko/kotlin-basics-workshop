package org.sytac.kotlin.workshop.solutions

import assertk.Assert
import assertk.assertions.isEqualTo
import assertk.assertions.prop
import java.util.Locale
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_8ClassesAssertkSolutions {

    private fun Assert<Runner>.wonMedalIn(expectedMedalYear: Int) {
        prop(Runner::medals)
            .transform { medals -> medals.any { it.year == expectedMedalYear } }
            .isEqualTo(true)
    }

    fun Assert<Runner>.hasCoachName(expectedName: String) {
        prop(Runner::coach)
            .transform { it?.name }
            .isEqualTo(expectedName)
    }

}