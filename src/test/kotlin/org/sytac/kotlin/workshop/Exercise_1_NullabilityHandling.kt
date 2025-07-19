package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Exercise_1_NullabilityHandling {

    @Test
    fun `should return square or zero when input is nullable`() {
        val input1: Int? = 5
        val input2: Int? = null

        assertThat(squareOrZero(input1)).isEqualTo(25)
        assertThat(squareOrZero(input2)).isEqualTo(0)
    }

    fun squareOrZero(x: Int?): Int {
        TODO("use safe call + let  +  elvis operator")
    }

    @Test
    fun `should throw if null and return length otherwise`() {
        var input: String? = null

        assertThrows<IllegalArgumentException> {
            requireNotNull(input)
        }

        // reassign input to a non-null value and use requireNotNull and get string length
        //uncomment below
        // assertThat( .... ).isEqualTo(8)

        //assign null again
        // use ?. to get length or 0 if null with elvis operator
        //uncomment below
        // assertThat(.... ).isEqualTo(0)
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
    fun `should throw NPE when accessing property of null`() {
        val string: String? = null
        assertThrows<NullPointerException> { string!!.length } // we give up control
    }

    @Test
    fun `should return null if number negative or sqrt if positive`() {
        assertThat(sqrtOrNull(-1)).isNull()
        assertThat(sqrtOrNull(16)).isEqualTo(4.0)
    }

    fun sqrtOrNull(n: Int): Double? {
        TODO("return null if n < 0, else sqrt(n) --> use when expression")
    }

    @Test
    fun `should return true if value represents an odd number`() {
        assertThat(isOdd(3)).isEqualTo(true)
        assertThat(isOdd("9")).isEqualTo(true)
        assertThat(isOdd("6")).isEqualTo(false)
        assertThat(isOdd(10.7)).isEqualTo(false)
        assertThat(isOdd(10.0)).isEqualTo(false)
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
     * - String → if all digits, convert to Int and check
     * - Double → round to Int and check
     * - Else → throw IllegalArgumentException
     */
    fun isOdd(input: Any?): Boolean {
        TODO("Check type using when(input) + is. Handle string digit check, double rounding, else throw")
    }

}

