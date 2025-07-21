package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import java.time.LocalDate
import org.junit.jupiter.api.Test
import org.sytac.kotlin.workshop.sport.Runner

class CheckIfThisRunsFirstIfYesYouAreGoodToGo {

    @Test
    fun `runner object test`() {
        val runner = Runner("John", LocalDate.now().minusYears(25), 1.75, 70.0)
        assertThat(runner.name).isEqualTo("John")
        assertThat(runner.age).isEqualTo(25)
        assertThat(runner.nickName).isEqualTo("Runner John  nr. 25")
        assertThat(runner.activeCareer).isTrue()

        runner.activeCareer = false
        assertThat(runner.activeCareer).isFalse()
    }
}