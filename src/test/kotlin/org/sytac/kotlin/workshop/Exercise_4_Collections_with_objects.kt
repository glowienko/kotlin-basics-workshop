package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import assertk.assertions.isTrue
import java.time.LocalDate
import java.time.Month
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.RunnerFixture.SIMPLE_RUNNER
import org.sytac.kotlin.workshop.RunnerFixture.generateRandomRunners
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_3_CollectionsWithObjects {


    private val runners = generateRandomRunners()

    @Test
    fun `filter all adult runners with active career`() {
        val result = runners //TODO implement me and ADD filtering
        assertThat(result.all { it.age >= 18 && it.activeCareer }).isEqualTo(true)
    }

    @Test
    fun `evaluate if none of the given runners should have more than 5 medals and if all have empty medals`() {
        val given = listOf(SIMPLE_RUNNER, SIMPLE_RUNNER.copy(medals = List(8) { Medal(MedalType.GOLD, 2020) }))

        val resultFalse =
            given.map { true }.first() //tODO change me and filter given list correctly -> check if none have more than 5 medals
        val resultTrue =
            listOf(SIMPLE_RUNNER).map { false }.first() //TODO change me and filter given list correctly -> check if all have empty medals

        assertThat(resultFalse).isFalse()
        assertThat(resultTrue).isTrue()
    }

    @Test
    fun `map runners to their  nicknames only for runners with coach`() {
        val nicknames = emptyList<String>() //todo runners. ... - implement me and map runners to their nicknames only for runners with coach
        assertThat(nicknames).isNotNull()
    }

    @Test
    fun `sum total medals won by all runners`() {
        val total = 0
        assertThat(total).isNotNull()
        assertThat(total > 0).isTrue()
    }

    @Test
    fun `find the runner with the highest BMI`() {
        val maxBmiRunner = null
        assertThat(maxBmiRunner).isNotNull()
    }

    @Test
    fun `group runners by country, skipping null countries`() {
        val grouped = mapOf<String, Runner>() //todo implement me and group runners by country, skipping null countries
        assertThat(grouped).isNotEmpty()
    }

    @Test
    fun `fold to build a list of all medals, starting from empty list, group medals as a map of MedalType to medalTypeCount, use groupingBy, compare to groupBy`() {
        val given = listOf(
            SIMPLE_RUNNER.copy(medals = List(2) { Medal(MedalType.GOLD, 2020) }),
            SIMPLE_RUNNER.copy(medals = List(3) { Medal(MedalType.SILVER, 2018) })
        )

        val medalTypeToCount = emptyMap<MedalType, Int>() // TODO implement me

        assertThat(medalTypeToCount.size).isEqualTo(2)
        assertThat(medalTypeToCount).isEqualTo(mapOf(MedalType.GOLD to 2, MedalType.SILVER to 3))
    }

    @Test
    fun `all runners with coach should have coach experienceYears not null`() {
        val result = false //TODO change me and filter runners with coach correctly
        assertThat(result).isEqualTo(true)
    }
}


