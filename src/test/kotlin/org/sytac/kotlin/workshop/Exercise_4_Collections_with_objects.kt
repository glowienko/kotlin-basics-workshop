package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import java.time.LocalDate
import java.time.Month
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_3_CollectionsWithObjects {


    private val runners = generateRunners()
//todo remove solutions !!!

    @Test
    fun `filter all adult runners with active career`() {
        val result = runners
            .filter { it.isAdult() }
            .filter { it.activeCareer }
        assertThat(result.all { it.age >= 18 && it.activeCareer }).isEqualTo(true)
    }

    @Test
    fun `none of the runners should have more than 5 medals`() {
        val result = runners.none { it.medals.size > 5 }
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `map to nicknames of runners with coach`() {
        val nicknames = runners.mapNotNull { if (it.coach != null) it.nickName else null }
        assertThat(nicknames).isNotNull()
    }

    @Test
    fun `sum total medals won by all runners`() {
        val total = runners.sumOf { it.medals.size }
        assertThat(total).isNotNull()
    }

    @Test
    fun `find the runner with the highest BMI`() {
        val maxBmiRunner = runners.maxByOrNull { it.bmi() }
        assertThat(maxBmiRunner).isNotNull()
    }

    @Test
    fun `group runners by country, skipping null countries`() {
        val grouped = runners.filterNot { it.country == null }.groupBy { it.country }
        assertThat(grouped).isNotNull()
    }

    @Test
    fun `fold to build a string summary of all coaches`() {
        val summary = runners.fold("Coaches:") { acc, runner ->
            if (runner.coach != null) "$acc ${runner.coach.name}," else acc
        }.trimEnd(',')

        assertThat(summary.startsWith("Coaches:")).isEqualTo(true)
    }

    @Test
    fun `all runners with coach should have coach experienceYears not null`() {
        val result = runners.filter { it.coach != null }.all { it.coach?.experienceYears != null }
        assertThat(result).isEqualTo(true)
    }

    companion object {
        fun generateRunners(): List<Runner> =
            (1..10).map {
                Runner(
                    name = "Runner$it",
                    birtDate = LocalDate.of(1990 + it, Month.entries.random(), (1..31).random()),
                    height = 1.6 + it * 0.01,
                    weight = 50.0 + it * 2,
                    activeCareer = it % 2 == 0,
                    medals = List(it % 4) { index -> Medal(MedalType.entries[index % 3], 2020 + index) },
                    country = if (it % 3 == 0) null else "Country$it",
                    coach = if (it % 4 == 0) null else Coach("Coach$it", if (it % 5 == 0) null else 5 + it)
                )
            }

        fun generateRunners2(): List<Runner> =
            List(10) {
                Runner(
                    name = "Runner$it",
                    birtDate = LocalDate.of(1990 + it, Month.entries.random(), (1..31).random()),
                    height = 1.6 + it * 0.01,
                    weight = 50.0 + it * 2,
                    activeCareer = it % 2 == 0,
                    medals = List(it % 4) { index -> Medal(MedalType.entries[index % 3], 2020 + index) },
                    country = if (it % 3 == 0) null else "Country$it",
                    coach = if (it % 4 == 0) null else Coach("Coach$it", if (it % 5 == 0) null else 5 + it)
                )
            }
    }
}


