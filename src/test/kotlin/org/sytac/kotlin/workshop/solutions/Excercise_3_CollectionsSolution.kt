package org.sytac.kotlin.workshop.solutions

import assertk.assertThat
import assertk.assertions.isEqualTo
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Locale
import java.util.UUID
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import org.junit.jupiter.api.Test

object Excercise_3_CollectionsSolution {

    //implement this function to generate a list of 5 random integers from 100 to 500, sort them map them to Pairs(Int, random UUID) and return the list
    fun generatePairs(): List<Pair<Int, UUID>> = (0..5).map { Random.nextInt(100, 500) }.sorted().map { it to UUID.randomUUID() }

    //for each element of a zipped map destructure it to word and length and print
//    zipped.forEach { (word, length) -> println("Word: $word, Length: $length") }


    @Test
    fun `generate squares of even numbers between 1 and 10 then take if not empty also println all results`() {
        val result: List<Int>? = (1..10)
            .filter { it % 2 == 0 }
            .map { it * it }
            .takeIf { it.isNotEmpty() }
            .also { resultList -> resultList?.forEach { println(it) } }
        assertThat(result).isEqualTo(listOf(4, 16, 36, 64, 100))

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

        @Test
        fun `filter non-null, non-blank strings and pair with length`() {
            val input = listOf("kotlin", null, " ", "Go", "Abc", "", null)
            val noNullInout = input
                .mapNotNull { it }
                .filterNot { it.isBlank() }
            val result: List<Pair<String, Int>> = input
                .mapNotNull { it }
                .filterNot { it.isBlank() }
                .map { it to it.length }

            assertThat(result).isEqualTo(listOf("kotlin" to 6, "Go" to 2, "Abc" to 3))

            //see destructure of an above map first element to word and len params
            val (word: String, length: Int) = result.first()

            //for each element of a zipped map destructure it to word and length and print
            result.forEach {
                    (word, length) -> println("Word: $word, Length: $length")
            }
        }

    }
}