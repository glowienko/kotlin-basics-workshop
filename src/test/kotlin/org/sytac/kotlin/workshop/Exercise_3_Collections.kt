package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.containsAll
import assertk.assertions.containsAtLeast
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import org.junit.jupiter.api.Test

class Exercise_3_Collections {


    @Test
    fun `generate squares of even numbers between 1 and 10 then take if not empty also println all results`() {
        val result = (1..20)
            .filter { it % 2 == 0 }
            .map { it * it }
            .takeIf { it.isNotEmpty() }
            .also { resultList -> resultList?.forEach { println(it) } }
        assertThat(result).isEqualTo(listOf(144, 196, 256, 324, 400))
    }

    @Test
    fun `filter non-null, non-blank strings and zip with length`() {
        val input = listOf("kotlin", null, " ", "Go", "Abc", "", null)
        val noNullInout = input
            .mapNotNull { it }
            .filterNot { it.isBlank() }
        val zipped = noNullInout.zip(noNullInout.map { it.length })
        assertThat(zipped).isEqualTo(listOf("kotlin" to 6, "Go" to 2, "Abc" to 3))
    }

    @Test
    fun `generate range from 0 until 11 skipping every 2 element (0,2,4,6,8,10), then zip it with animals sorted list, then filter keys taking only those below 6, and then map each key to string `() {
        val animals = listOf("Fish", "Cat", "Dog", "Bird", "Rabbit", "Hamster")
        val mapping = TODO(" Implement me ")
        //uncomment below to check your solution!
//        assertThat(mapping).isEqualTo(mapOf("0" to "Bird", "2" to "Cat", "4" to "Dog"))
    }

    @Test
    fun `analyze weekday durations`() {
        val durations = mapOf(
            DayOfWeek.MONDAY to 2.hours,
            DayOfWeek.TUESDAY to 4.hours,
            DayOfWeek.WEDNESDAY to 3.hours,
            DayOfWeek.THURSDAY to 5.hours,
            DayOfWeek.FRIDAY to 6.hours,
            DayOfWeek.SATURDAY to 1.hours,
            DayOfWeek.SUNDAY to 2.hours,
        )

        val weekdays = TODO(" Implement me ")
        val totalDurationForAllDays: Duration = TODO(" Implement me ")
        val longestDayDuration = TODO(" Implement me ")
        val shortestMillisDuration = TODO(" Implement me ")

        //uncoment below to check your solution!
//        assertThat(totalDurationForAllDays).isEqualTo(20.hours)
//        assertThat(longestDayDuration).isEqualTo(DayOfWeek.FRIDAY)
//        assertThat(shortestMillisDuration).isEqualTo(1.hours.inWholeMilliseconds)
    }

    @Test
    fun `map LocalDateTime to weekday name and filter weekends`() {
        val base = LocalDateTime.of(2024, 4, 1, 12, 0) // Monday
        val expectedStartDate = base.toLocalDate()
        val days = (0..6).map { base.plusDays(it.toLong()) } + null

        val weekdays: Map<LocalDate, String> = TODO(" Implement me ")

        assertThat(weekdays.size).isEqualTo(5)
        assertThat(weekdays).isEqualTo(
            mapOf(
                expectedStartDate to "MONDAY",
                expectedStartDate.plusDays(1) to "TUESDAY",
                expectedStartDate.plusDays(2) to "WEDNESDAY",
                expectedStartDate.plusDays(3) to "THURSDAY",
                expectedStartDate.plusDays(4) to "FRIDAY"
            )
        )
    }

    companion object {
        fun generateInts(): List<Int> = (1..20).map { Random.nextInt(0, 100) }
    }
}
