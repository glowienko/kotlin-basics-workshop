package org.sytac.kotlin.workshop

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Exercise_2_StringExercises {


    // -------------------------------
    // Exercise 0: Removing brackets from string
    // -------------------------------
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

    // 1. Reverse words in a sentence, preserve punctuation
    @Test
    fun `should reverse words but not punctuation`() {
        assertThat(reverseWords("Hello, world!")).isEqualTo("world, Hello!")
        assertThat(reverseWords("Kotlin is awesome.")).isEqualTo("awesome is Kotlin.")
    }

    fun reverseWords(input: String): String {
        TODO("Split sentence into words while keeping punctuation, then reverse order")
    }

    @Test
    fun `should collapse multiple spaces and trim ends`() {
        assertThat(removeWhitespace("   Kotlin     is  fun  ")).isEqualTo("Kotlinisfun")
    }

    fun removeWhitespace(input: String): String {
        TODO("Use replace and trim to normalize spaces and tabs")
    }

    // 4. Extract all capitalized words
    @Test
    fun `should return all capitalized words`() {
        assertThat(findCapitalizedWords("The quick brown Fox jumps over the lazy Dog"))
            .isEqualTo(listOf("The", "Fox", "Dog"))
    }

    fun findCapitalizedWords(input: String): List<String> {
        TODO("Use split and filter to find capitalized words")
    }

    // 5. Kotlin has a lot of built-in string functions, one of them is commonPrefixWith.
    @Test
    fun `should return longest common prefix`() {
        assertThat("Java".commonPrefixWith("JavaScript")).isEqualTo("Java")
        assertThat(("Spring".commonPrefixWith("Hibernate"))).isEqualTo("")
    }

    // 6. Mask all but last 4 digits of a credit card
    @Test
    fun `should mask all but last 4 digits`() {
        assertThat(maskCardNumber("1234567812345678")).isEqualTo("************5678")
        assertThat(maskCardNumber("987654321")).isEqualTo("*****4321")
    }

    fun maskCardNumber(number: String): String {
        TODO("Mask all but last 4 digits with *")
    }

//    // 7. Remove duplicate letters, keep first occurrence
//    @Test
//    fun `should remove duplicate letters ignoring case`() {
//        assertThat(removeDuplicateLetters("aabbcccc")).isEqualTo("abc")
//    }
//
//    fun removeDuplicateLetters(input: String): String {
//        TODO("Use filter and a mutable set to track lowercase letters")
//    }
}


