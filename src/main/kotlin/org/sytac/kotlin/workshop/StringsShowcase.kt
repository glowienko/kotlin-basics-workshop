package org.sytac.kotlin.workshop

import java.util.Locale.getDefault

object StringsShowcase {

    @JvmStatic
    fun presentStrings() {
            println()
            println()
            println("STRINGS SHOWCASE")
            println("1. String Templates (Interpolation)")
            val age = 22
            val name = "Bob"
            val fullName = "      Bob" + " Smith  "
            println("Hello, $name! you are $age years old.")
            println("Name length: ${name.length}")
            println("full lowercase, trimed: ${fullName.lowercase().trim()}")

            println()
            println("2. buildString for Efficient String Construction")
            val result = buildString {
                append("Hello, ")
                append("world!")
                append(listOf("A", "B", "C").joinToString(separator = ", "))
            }
            println(result)

            println()
            println("3. String Defaulting with ifBlank() and ifEmpty() and null handling")

            val s: String? = ""
            println("  ".ifBlank { "default" })
            println(null.orEmpty())
            println(s.isNullOrBlank())
            println("".isBlank())

            println()
            println("4. Multiline Strings with Triple Quotes")
            val multilineText = """
            First line
            Second line
        """.trimIndent()
            println(multilineText)
            println()

            println("5. Functional String Processing")
            val filteredDigits: List<Int> = "abc123"
                .filter { it.isDigit() }
                .map { it.digitToInt() }
            println(filteredDigits) // Output: 123

            println()
            println("Standard lib")
            // 6. Useful Standard Library String Extensions
            val text = "Welcome to Kotlin"
            println(text.replace(oldValue = "o", newValue = "oo", ignoreCase = true)) // Output: Welcoome too Kootlin
            println("/text/".removeSurrounding("/")) // Output: text
            println("c 123123  ".removePrefix("c").trim()) // Output:  123123
            println(text.substringBefore(" ")) // Output: Welcome
            println(text.substringAfter(" "))  // Output: to Kotlin
            println(text.replaceBefore(" ", "Say"))  // Output: Say to Kotlin
            println(text.startsWith("Wel"))    // Output: true
            println(text.endsWith("bbbb"))      // Output: false
            println(text.contains("to"))       // Output: true
            println(text.replaceFirstChar { it.uppercase() })         // Output: Welcome to kotlin (Note: deprecated in Kotlin 1.5+)
            println(text.replaceFirstChar { it.lowercase(getDefault()) })       // Output: welcome to Kotlin


            val names = listOf("Alice", "Bob", "Charlie")
            val jobs = listOf("Engineer", "Designer", "Manager")
            println("zip:")
            println(names.zip(jobs))


            val nameToJobPairs = mutableMapOf(Pair("Alice", "Engineer"), Pair("Bob", "Designer"))
            val nameToJob = mapOf(
                "Alice" to "Engineer",
                "Bob" to "Designer",
                "Charlie" to "Manager"
            )
            val associate = listOf(1, 2, 3).associate { it to "user$it" }
            val associate2 = listOf(1, 2, 3).associateWith { "user$it" }
            val associate3 = listOf(1, 2, 2, 3, 4,4 ).groupBy { it }

            println(associate2)
            println(associate3)
            println("keys, values, entries of associate2:")
            println(associate2.keys)
            println(associate2.values)
            println(associate2.entries.first().let { (key, value) -> "key: $key, value: $value" })

            println("Bob's job is ${nameToJob.get("Alice")}") // Output: Alice's job is Engineer
            println("Unknown key =  ${nameToJob["abc"]}") // Output: null
            println("Alice's job is ${nameToJob["Alice"] ?: "unknown"}") // Output: Alice's job is Engineer
    }
}
