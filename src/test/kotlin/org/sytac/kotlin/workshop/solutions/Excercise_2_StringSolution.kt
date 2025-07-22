package org.sytac.kotlin.workshop.solutions

import java.util.Locale

object Excercise_2_StringSolution {

    fun removeBrackets(input: String?): String =
        input?.replace("[", "")?.replace("]", "") ?: ""

    fun reverseWords(input: String): String {
        val words = input.split(" ")
        val reversed = words.reversed()
        return reversed.joinToString(" ")
    }

//    fun normalizeWhitespace(input: String): String {
//        return input.replace(" ", "").trim()
//    }

    fun findCapitalizedWords(input: String): List<String> {
        return input.split(" ")
            .filter({ word -> word.isNotEmpty() })
            .filter { it.first().isUpperCase() }
    }

    fun maskCardNumber(number: String): String {
        val visible = number.takeLast(4)
        val masked = "*".repeat(number.length - 4)
//        val maskedCardNumber = number.mapIndexed { index, ch -> if (index < number.length - 4) "*" else ch }
        return masked + visible
    }

    fun removeDuplicateLetters(input: String): String {
        return mutableSetOf<Char>().run {
            buildString {
                input.forEach { c ->
                    val lower = c.lowercaseChar()
                    if (lower !in this@run) {
                        this@run.add(lower)
                        append(c)
                    }
                }
            }
        }
    }

    fun duplicate2(input: String): String {
        val seen = mutableSetOf<Char>()
        var result = ""
        for (char in input) {
            val lower = char.lowercaseChar()
            if (lower !in seen) {
                seen.add(lower)
                result += char
            }
        }
        return result
    }

}