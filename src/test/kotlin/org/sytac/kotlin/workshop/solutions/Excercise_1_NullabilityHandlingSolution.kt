package org.sytac.kotlin.workshop.solutions

import kotlin.math.roundToInt
import kotlin.math.sqrt

object Excercise_1_NullabilityHandlingSolution {
    fun squareOrZero(x: Int?): Int = x?.let { it * it } ?: 0

    fun doubleIfNotNull(n: Long?): Long = n?.let { it * 2 } ?: 0L
//        if (n != null) {
//            val nonNullN: Long = n
//            return nonNullN * 2
//        }
//        return 0

    fun uppercaseOrDefault(name: String?): String {
        return name?.uppercase() ?: "UNKNOWN"
    }

    fun sqrtOrNull(n: Int): Double? {
        return when {
            n < 0 -> null
            else -> sqrt(n.toDouble())
        }
    }

    fun isOdd(input: Any?): Boolean {
        return when (input) {
            is Int -> input % 2 != 0
            is String -> {
                if (input.all { it.isDigit() }) {
                    input.toInt() % 2 != 0
                } else {
                    throw IllegalArgumentException("Input string is not a valid number")
                }
            }

            is Double -> {
                val number = input.roundToInt()
                number % 2 != 0
            }

            else -> throw IllegalArgumentException("Unsupported input type: ${input?.javaClass?.name}")
        }
    }
}