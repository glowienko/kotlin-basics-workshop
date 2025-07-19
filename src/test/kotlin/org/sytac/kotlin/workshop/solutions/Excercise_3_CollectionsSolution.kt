package org.sytac.kotlin.workshop.solutions

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Locale
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import org.junit.jupiter.api.Test

object Excercise_3_CollectionsSolution {

    @Test
    fun `generate range from 0 until 11 skipping every 2 element (0,2,4,6,8,10), then zip it with animals sorted list, then filter keys taking only those below 6, and then map each key to string `() {
        val animals = listOf("Fish", "Cat", "Dog", "Bird", "Rabbit", "Hamster")
        val mapping = (0 until 11 step 2)
            .zip(animals.sorted())
            .toMap()
            .filterKeys { it < 6 }
            .mapKeys { it.key.toString() }
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


        val weekdays = durations.filterKeys { it != DayOfWeek.SATURDAY && it != DayOfWeek.SUNDAY }
        val totalDurationForAllDays: Duration = weekdays.values.reduce { acc, d -> acc.plus(d) }
        val longestDayDuration = weekdays.maxByOrNull { it.value }?.key
        val shortestMillisDuration = durations.minByOrNull { it.value }?.value?.inWholeMilliseconds
    }

    @Test
    fun `map LocalDateTime to weekday name and filter weekends`() {
        val base = LocalDateTime.of(2024, 4, 1, 12, 0) // Monday
        val expectedStartDate = base.toLocalDate()
        val days = (0..6).map { base.plusDays(it.toLong()) } + null

        val weekdays: Map<LocalDate, String> = days
            .filterNotNull()
            .map { it.toLocalDate() }
            .associateWith { it.dayOfWeek.name }
            .filterNot { it.value == "SATURDAY" || it.value == "SUNDAY" }
    }
}