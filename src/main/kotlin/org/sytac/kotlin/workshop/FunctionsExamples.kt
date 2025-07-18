package org.sytac.kotlin.workshop

object FunctionsExamples {


    fun double(x: Int): Int {
        return 2 * x
    }

    fun doubleOneLiner(x: Int): Int = 2 * x
    fun doubleOneLiner(x: Int?) = x?.let { 2 * it }

    fun printLocation(longitude: Int, latitude: Int) { // we can omit Unit type
        println("$longitude, $latitude")
    }

    fun printLocatinon2(longitude: Int, latitude: Int) = println("$longitude, $latitude")

    fun sendMessage(
        message: String,
        recipient: String,
        sender: String = "Admin",
        urgent: Boolean = false,
        footer: String? = null,
    ) {
        val urgencyTag = if (urgent) "[URGENT]" else ""
        println(
            """
            To: $recipient
            From: $sender
             $urgencyTag $message
             ${footer ?: "Regards"}
        """.trimIndent()
        )
    }
}

fun test() {

//    val twenty = FunctionsExamples.double(10)
//    FunctionsExamples.doubleOneLiner(1)
//    FunctionsExamples.doubleOneLiner(null)
//    FunctionsExamples.printLocation(1, 2)
//    FunctionsExamples.printLocatinon2(1, 2)
//    FunctionsExamples.sendMessage("hi", "John")
}