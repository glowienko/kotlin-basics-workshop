package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import kotlin.math.roundToInt
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Exercise_1_NullabilityHandling {

    @Test
    fun `should return square or zero when input is nullable`() {
        val input1: Int? = 5
        val input2: Int? = null

        assertThat(squareOrNull(null)).isEqualTo(null)
        assertThat(squareOrZero(input1)).isEqualTo(25)
        assertThat(squareOrZero(input2)).isEqualTo(0)

    }

    fun squareOrNull(x: Int?): Int? {
        TODO("use safe call :) ")
    }

    fun squareOrZero(x: Int?): Int {
        TODO("use safe call +  let + elvis operator :) ")
    }

    @Test
    fun `should format string only when not null`() {
        val input1: String? = "john"
        val input2: String? = null

        assertThat(upperCaseOrDefault(input1)).isEqualTo("JOHN")
        assertThat(upperCaseOrDefault(input2)).isEqualTo("UNKNOWN")
    }

    fun upperCaseOrDefault(name: String?): String {
        TODO("use let and ?:  ")
    }

    @Test
    fun `should return true if value represents an odd number`() {
        assertThat(isOdd(3)).isEqualTo(true)
        assertThat(isOdd(4)).isEqualTo(false)
        assertThat(isOdd(10.7)).isEqualTo(true)
        assertThat(isOdd(12.3)).isEqualTo(false)
    }

    @Test
    fun `should throw on unsupported types`() {
        assertThrows<IllegalArgumentException> {
            isOdd("abc")
        }

        assertThrows<IllegalArgumentException> {
            isOdd(true)
        }

        assertThrows<IllegalArgumentException> {
            isOdd(null)
        }
    }

    /**
     * Returns true if the input is an odd number.
     *
     * Accepts:
     * - Int → check if odd
     * - Double → round to Int and check
     * - Else → throw IllegalArgumentException
     */
    fun isOdd(input: Any?): Boolean {
        TODO("Implement this function using when and safe calls")
    }

    @Test
    fun `you can run this too see how requireNotNull works`() {
        val input: String? = null

        assertThrows<IllegalArgumentException> {
            requireNotNull(input)
        }
    }

    @Test
    fun `you can run this to see that is will throw NPE when accessing property of null`() {
        val string: String? = null
        assertThrows<NullPointerException> { string!!.length } // we give up control :/
    }

}

