package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.RunnerFixture.RUNNERS_LIST
import org.sytac.kotlin.workshop.sport.Runner

class Exercise_6_Classes {

    @Test
    fun `take first or null runner form the list and retire it, safely catching error without try catch, returning activeCareer field or throwing IllegalStateException on failure - print activeCareer on success, assert that career not active anymore`() {
        // todo implement retiring a runner using runCatching ")
        val resultIsActiveCareer: Boolean? = RUNNERS_LIST.firstOrNull()?.activeCareer ?: true
        assertThat(resultIsActiveCareer).isEqualTo(false)
    }

    @Test
    fun `add new runId to the Runner class as a String value class an init block and generateId method`() {
        val input = "kotlin is awesome"
        //uncomment below
//        assertThat(runner.runId.value).isEqualTo("abc12345")
//        assertThat(runner.copy(runId = RunId.generateId()).isNotNull()
    }


    @Test
    fun `add static factory method  createNew() to Runner class - all param should have a default`() {
        //uncomment below

        //val newRunner = Runner.createNew()
        //assertThat(newRunner).isNotNull()
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
    fun `add coach to a runner with apply {} and generate a runner description using kotlin run { } function`() {
        val runner = RunnerFixture.SIMPLE_RUNNER
        val resultDescription = TODO("implement with apply and run run { } function to generate a description")

        //uncomment below
//        assertThat(resultDescription).isEqualTo("Runner John, age: 25, coach: John Doe's Coach")
    }

}

