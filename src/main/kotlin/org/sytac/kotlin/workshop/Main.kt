package org.sytac.kotlin.workshop

import java.util.Arrays.asList
import org.sytac.kotlin.workshop.StringsShowcase.presentStrings
import org.sytac.workshop.JavaVararg

fun main() {

    println("validators:")
    println("is adult? : " + AdultValidator().isValid(20))
    println("is adult? : " + AdultValidatorSingleton.isValid(20)) // you can do a static import
    println("is adult? : " + adultValidator.isValid(20))
    println("is adult? : " + validateAdult().isValid(20))
    println("is adult? : " + Validator { it >= 18 }.isValid(18))
    println("is adult? : " + ::Validator)

    println()
    println("vararg example:")

//    JavaVararg.printAll(arrayOf("kotlin", "printing", "vararg"))// without *
//    --> Argument type mismatch: actual type is 'Array<String>', but 'String!' was expected.
    JavaVararg.printAll(*arrayOf("kotlin", "printing", "vararg"))
    println()
//    JavaVararg.printAll(*listOf("kotlin", "printing", "vararg")) // without toTypedArray()
//    --> Argument type mismatch: actual type is 'List<String>', but 'Array<(out) String!>!' was expected.
    printAll(*listOf("kotlin", "printing", "vararg").toTypedArray())
    println()

    //without * and typedArray on a listOf - we pass it as a whole list not elements from it
    //Argument type mismatch: actual type is 'Array<Any>', but 'Array<out String>' was expected.
    val strings = listOf("abc", *listOf("cde", "efg").toTypedArray(), "hij")
    printAll(*strings.toTypedArray())

    println()
    println()


    val number: Int
    number = 10
    val age = 25.25 //auto resolve type as Double
    val gauge: Long = 100005
//    number= 11 //error! 'val' cannot be reassigned.

    val name = "Mike"
    val name2: String = "Mike"

    var counter = 0
    counter += 1
    counter = 10
    counter -= 1

    println("Hello, $name! gauge is $gauge Counter is $counter. Number is $number.")

    val a = listOf(1, 2, 3)
//    a[5] .//index out of bounds

    println()
    println("fun examples:")
    println()

    FunctionsExamples.sendMessage(
        message = "Hello!",
        recipient = "John",
        sender = "Admin",
        urgent = true
    )

    FunctionsExamples.sendMessage(
        "Goodbye!",
        "John",
        urgent = true
    )
    //sender and urgent are taken from default
    FunctionsExamples.sendMessage("Goodbye!", "John")
    println()
    println()

    val result = "Mike".isLongerThan("Michael")
    val fancyResult = "Christopher" isLongerThan "Chris"
    print("is longer? $result, $fancyResult")
    println()
    println()
    println("higher order functions examples:")

    println(sumValues)
    println(multiplyValues)
    println(operateOn(2,3, multiply))
    handleValues(5,6, { x, y -> println("$x,$y") })

    presentStrings()

    Athlete(
        name = "John Doe",
        discipline = "Running",
        age = 25
    ).also { athlete ->
        println("Athlete: $athlete")
        val (name, discipline, age) = athlete
        println("destructured: name=$name, discipline=$discipline, age=$age")
    }
}


fun handleValues(a: Int, b: Int, handler: (Int, Int) -> Unit): Unit = handler(a, b)
fun operateOn(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)
val multiply: (Int, Int) -> Int = { x, y -> x * y }

val multiplyValues = operateOn(3, 7, multiply) // pass function reference
val sumValues = operateOn(3, 7, { x, y -> x + y }) //pass lambda expression


infix fun String.isLongerThan(other: String): Boolean = this.length > other.length

fun printAll(vararg args: String) = args.forEach { print("$it  ") }

val adultValidator = Validator { it >= 0 }

fun validateAdult() = object : Validator {
    override fun isValid(value: Int): Boolean = value >= 18
}

object AdultValidatorSingleton : Validator {
    override fun isValid(value: Int): Boolean = value >= 18
}

class AdultValidator : Validator {
    override fun isValid(value: Int): Boolean = value >= 18
}

fun interface Validator {
    fun isValid(value: Int): Boolean
}
