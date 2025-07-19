package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_6_Classes {


    @Test
    fun `implement isWeekend function as extension function on DayOfWeek`() {
        //uncomment below
//        assertThat(LocalDateTime.now().dayOfWeek.isWeekend()).isEqualTo(false)
    }

    @Test
    fun `convert  functions from StringExercises to extensionFun`() {
        val input = "kotlin is awesome"
        //uncomment below
//        assertThat(input.reverseWords()).isEqualTo("awesome is kotlin")
    }

    @Test
    fun `add new runId to the Runner class as a String value class an init block and generateId method`() {
        val input = "kotlin is awesome"
        //uncomment below
//        assertThat(runner.runId.value).isEqualTo("abc12345")
//        assertThat(runner.copy(runId = RunId.generateId()).isNotNull()
    }

    @Test
    fun `add extension fun implementations to the Runner class and make this test pass`() {
        val runner = Runner("John", LocalDate.parse("1990-05-01"), 1.75, 70.0)

//        val runnerWithGoldMedal = runner.winGoldMedal()

        //uncomment below
//        runner sameAgeAs runner shouldBe true
//        runner sameAgeAs runner.copy(birtDate = LocalDate.now()) shouldBe false
//        runner.hasGoldMedal() shouldBe false
    }

    @Test
    fun `it should generate a runner description using kotlin run { } function`() {
        val runner = Runner("John", LocalDate.parse("2000-05-01"), 1.75, 70.0)

        val resultDescription = TODO("implement with run { } function to generate a description")

        //uncomment below
//        assertThat(resultDescription).isEqualTo("Runner John, age: 25, active: true")
    }

}

