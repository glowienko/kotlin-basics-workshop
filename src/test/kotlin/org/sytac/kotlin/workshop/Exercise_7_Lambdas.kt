package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Medal
import org.sytac.kotlin.workshop.sport.MedalType
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_7_Lambdas {
    val runners = generateRunners()

    @Test
    fun `pass function to an extension fun reference to check adult runners`() {
//uncomment and implement the isAdult function
        //        val result = runners.countMatching { it.isAdult() }
//        assertThat(result).isEqualTo(runners.count { it.age >= 18 })
    }

    @Test
    fun `use lambda to calculate average BMI of runners`() {
        // Uncomment and implement the averageBy function
        //   val avg = runners.averageBy { it.bmi() }
//        assertThat(avg).isNotNull()
    }

    @Test
    fun `create new function that accepts 2 list of ints and strings and let the user apply custom transform fun on them`() {
        val nums = listOf(1, 2, 3)
        val words = listOf("one", "two", "three", "four")
        val joinIntString: (Int, String) -> String = { num, word -> "$num: $word" }

        //uncomment and implement this function
        //        val result = zipAndMap(nums, words, joinIntString)
//        assertThat(result).isEqualTo(listOf("1: one", "2: two", "3: three"))
    }


    companion object {
        fun generateRunners(): List<Runner> {
            return (1..3).map {
                Runner(
                    name = "Runner$it",
                    birtDate = LocalDate.now().minusYears(it.toLong() + 18),
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
}

