package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DummyTest {

    @Test
    fun `dummy test`() {
        assert(true)
        2 shouldBe 2
        assertThat(2).isEqualTo(2)
    }
}