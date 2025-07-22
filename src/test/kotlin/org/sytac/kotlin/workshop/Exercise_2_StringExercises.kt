package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Exercise_2_StringExercises {



    @Test
    fun `should remove brackets from string`() {
        assertThat(removeBrackets("Hello [World]")).isEqualTo("Hello World")
        assertThat(removeBrackets("[World]")).isEqualTo("World")
        assertThat(removeBrackets("[]")).isEqualTo("")
        assertThat(removeBrackets("No brackets")).isEqualTo("No brackets")
        assertThat(removeBrackets(null)).isEqualTo("")
    }

    fun removeBrackets(input: String?): String {
        TODO("remove square brackets, use safe call and elvis operator")
    }

    @Test
    fun `should reverse words but not punctuation`() {
        assertThat(reverseWords("Hello, world!")).isEqualTo("world, Hello!")
        assertThat(reverseWords("Kotlin is awesome.")).isEqualTo("awesome is Kotlin.")
    }

    fun reverseWords(input: String): String {
        TODO("Split sentence into words while keeping punctuation, then reverse order")
    }

    @Test
    fun `should return all capitalized words`() {
        assertThat(findCapitalizedWords("The quick brown Fox jumps over the lazy Dog"))
            .isEqualTo(listOf("The", "Fox", "Dog"))
    }

    fun findCapitalizedWords(input: String): List<String> {
        TODO("Use split and filter to find capitalized words")
    }

    @Test
    fun `should return longest common prefix`() {
        assertThat("Java".commonPrefixWith("JavaScript")).isEqualTo("Java")
        assertThat(("Spring".commonPrefixWith("Hibernate"))).isEqualTo("")
    }

    @Test
    fun `should mask all but last 4 digits`() {
        assertThat(maskCardNumber("1234567812345678")).isEqualTo("************5678")
        assertThat(maskCardNumber("987654321")).isEqualTo("*****4321")
    }

    fun maskCardNumber(number: String): String {
        TODO("Mask all but last 4 digits with *")
    }


    @Test
    fun `remove duplicated chars from a string`() {
        assertThat(removeDuplicates("kooootliiiinn")).isEqualTo("kotlin")
        assertThat(removeDuplicates("Aaaabbbc")).isEqualTo("Abc")
    }


    fun removeDuplicates(input: String): String {
    TODO("implement me")
    }
}


