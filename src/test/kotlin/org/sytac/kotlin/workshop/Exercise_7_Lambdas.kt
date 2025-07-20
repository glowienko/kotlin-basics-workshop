package org.sytac.kotlin.workshop

import org.junit.jupiter.api.Test

class Exercise_7_Lambdas {
    val runners = RunnerFixture.generateRandomRunners()

    @Test
    fun `pass function to an extension fun reference to check adult runners`() {
//uncomment and implement the countMatching function that accepts a predicate function and returns count of runners matching the predicate
//                val result = runners.countMatching { it.isAdult() }
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
}

