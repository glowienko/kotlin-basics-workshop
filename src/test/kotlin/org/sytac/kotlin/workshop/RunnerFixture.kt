package org.sytac.kotlin.workshop

import java.time.LocalDate
import java.time.Month
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

object RunnerFixture {

    val SIMPLE_RUNNER = Runner(
        name = "John Doe",
        birtDate = LocalDate.now().minusYears(25),
        activeCareer = true,
        height = 1.80,
        weight = 75.0
    )

    val RUNNERS_LIST = listOf(SIMPLE_RUNNER, SIMPLE_RUNNER)


    fun generateRandomRunners(): List<Runner> =
        List(10) {
            Runner(
                name = "Runner$it",
                birtDate = LocalDate.of(1990 + it, Month.entries.random(), (1..31).random()),
                height = 1.6 + it * 0.01,
                weight = 50.0 + it * 2,
                activeCareer = it % 2 == 0,
                medals = List(it % 4) { index -> Medal(MedalType.entries[index % 3], 2020 + index) },
                country = if (it % 3 == 0) null else "Country${it % 3}",
                coach = if (it % 4 == 0) null else Coach("Coach$it", if (it % 5 == 0) null else 5 + it)
            )
        }
}