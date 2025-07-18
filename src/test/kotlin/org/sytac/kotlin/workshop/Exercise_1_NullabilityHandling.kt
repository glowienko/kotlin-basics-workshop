package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Exercise_1_NullabilityHandling {

    @Test
    fun `dummy test`() {
        assert(true)
        2 shouldBe 2
        assertThat(2).isEqualTo(2)
    }
}