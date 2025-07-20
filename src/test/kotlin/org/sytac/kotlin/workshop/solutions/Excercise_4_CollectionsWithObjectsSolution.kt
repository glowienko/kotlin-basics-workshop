package org.sytac.kotlin.workshop.solutions

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isTrue
import java.time.LocalDate
import java.time.Month
import java.util.Locale
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.RunnerFixture
import org.sytac.kotlin.workshop.RunnerFixture.SIMPLE_RUNNER
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_4_CollectionsWithObjectsSolution {

    val runners =  RunnerFixture.RUNNERS_LIST

    @Test
    fun `map to nicknames of runners with coach`() {
        val nicknames = runners.mapNotNull { if (it.coach != null) it.nickName else null }
        assertThat(nicknames).isNotNull()
    }

    @Test
    fun `sum total medals won by all runners`() {
        val total = runners.sumOf { it.medals.size }
        assertThat(total).isNotNull()
        assertThat(total > 0 ).isTrue()
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
    fun `fold to build a list of all medals, starting from empty list, group medals as a map of MedalType to medalTypeCount, use groupingBy, compare to groupBy`() {
        val given = listOf(
            SIMPLE_RUNNER.copy(medals = List(2) { Medal(MedalType.GOLD, 2020) }),
            SIMPLE_RUNNER.copy(medals = List(3) { Medal(MedalType.SILVER, 2018) })
        )

        val medals = given.fold(initial = emptyList<Medal>()) { accumulatedMedals, runner -> accumulatedMedals + runner.medals }
        val medalTypeToCount = medals.groupingBy { it }.eachCount()

        assertThat(medalTypeToCount.size).isEqualTo(2)
        assertThat(medalTypeToCount).isEqualTo(mapOf(MedalType.GOLD to 2, MedalType.SILVER to 3))
    }

    @Test
    fun `all runners with coach should have coach experienceYears not null`() {
        val result = runners.filter { it.coach != null }.all { it.coach?.experienceYears != null }
        assertThat(result).isEqualTo(true)
    }


}