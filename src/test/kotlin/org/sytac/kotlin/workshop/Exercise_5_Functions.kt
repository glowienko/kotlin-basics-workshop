package org.sytac.kotlin.workshop

import org.junit.jupiter.api.Test

class Exercise_5_Functions {



    @Test
    fun `implement isWeekend function as extension function on DayOfWeek`() {
        //uncomment below and implement the extension  function as 1 liner expression
//        assertThat(LocalDateTime.now().dayOfWeek.isWeekend()).isEqualTo(false)
    }

    @Test
    fun `convert  functions from StringExercises to extensionFun`() {
        val input = "kotlin is awesome"
        //uncomment below and implement the extension function
//        assertThat(input.reverseWords()).isEqualTo("awesome is kotlin")
    }

    //todo add test for creating a fun that generates a random string of given length or sth - with default value of 10 or sth


}
