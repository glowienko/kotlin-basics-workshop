package org.sytac.kotlin.workshop


data class Runner(
    override val name: String,
    override val age: Int,
    override val height: Double,
    override val weight: Double,
    var activeCareer: Boolean = true,
) : Human {
    val nickName: String
        get() = "Runner $name  nr. $age"
}

interface Human {
    val name: String
    val age: Int
    val height: Double
    val weight: Double

    fun isAdult(): Boolean = age >= 18
    fun bmi(): Double = weight / (height * height)
}


fun interface EvenValidator {
    fun isEven(value: Int): Boolean
}

