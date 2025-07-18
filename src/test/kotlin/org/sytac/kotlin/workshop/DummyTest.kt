package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DummyTest {

    @Test
    fun `dummy test`() {
        assert(true)
        2 shouldBe 2
        assertThat(2).isEqualTo(2)
    }

    @Test
    fun `runner object test`() {
        val runner = Runner("John", 25, 1.75, 70.0)
        assertThat(runner.name).isEqualTo("John")
        assertThat(runner.age).isEqualTo(25)
        assertThat(runner.nickName).isEqualTo("Runner John  nr. 25")
        assertThat(runner.activeCareer).isTrue()

        runner.activeCareer = false
        assertThat(runner.activeCareer).isFalse()
    }
}