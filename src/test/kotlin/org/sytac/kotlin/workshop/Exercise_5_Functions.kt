package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test

class Exercise_5_Functions {


    @Test
    fun `create a fun that generates random string of a given length with default len = 10`() {
        val charset = ('a'..'z') + ('A'..'Z')
        val resultRandomString: String = generateRandomString(22)

        assertThat(resultRandomString).isNotEmpty()
        assertThat(generateRandomString(10).length).isEqualTo(10)
        assertThat(generateRandomString(15).length).isEqualTo(15)
        assertThat(generateRandomString(15).isNotEmpty()).isTrue()
        assertThat(generateRandomString(15).none { it.isDigit() }).isTrue()
    }

    //todo add default to this function :)
    fun generateRandomString(length: Int): String {
        val charset = ('a'..'z') + ('A'..'Z')
        TODO("implement random string generation logic here, make this function 1 linter expression :) ")
//        you can use run { } on charset and then create a range and map it somehow to generate a random string :)
    }

    @Test
    fun `add 2 random string gear to the runner - use apply {} to apply addGear(), use spread operator - pass gear as as an array and then list, see difference`() {
        val gear: List<String> = listOf(generateRandomString(5), generateRandomString(5))
        val gear2 = arrayOf(generateRandomString(10), generateRandomString(5))

        val runnerWithGear = RunnerFixture.SIMPLE_RUNNER.apply {

        }
        //uncomment below to check your solution
        assertThat(runnerWithGear.gear).isNotEmpty()
        assertThat(runnerWithGear.gear).hasSize(4)
    }

    @Test
    fun `implement isWeekend function as extension function on DayOfWeek`() {
        //uncomment below and implement the extension  function as 1 liner expression
//        assertThat(LocalDateTime.now().dayOfWeek.isWeekend()).isEqualTo(false)
    }

    @Test
    fun `convert  function reverseWords from StringExercises to extensionFun on String`() {
        val input = "kotlin is awesome"
        //uncomment below and implement the extension function
//        assertThat(input.reverseWords()).isEqualTo("awesome is kotlin")
    }


}
