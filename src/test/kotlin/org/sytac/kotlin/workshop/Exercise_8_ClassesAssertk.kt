package org.sytac.kotlin.workshop

import assertk.Assert
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.prop
import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_8_ClassesAssertk {

    @Test
    fun `create a custom assertion using assertk library for Runner class`() {
        val runner = Runner(
            "John",
            LocalDate.parse("1990-05-01"),
            1.75,
            70.0,
            medals = listOf(Medal(MedalType.SILVER, 1995)),
            coach = Coach("John", 5)
        )

//        UNCOMMENT ME AND IMPLEMENT :)
//        assertThat(runner).hasCoachName("John")
//        assertThat(runner).wonMedalIn(1995)
    }
}

