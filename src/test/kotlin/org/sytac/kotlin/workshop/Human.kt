package org.sytac.kotlin.workshop

data class Human(
    val name: String,
    val age: Int,
    val height: Double,
    val weight: Double,
) {
    val nickName: String
        get() = "$name $age"

    fun isAdult(): Boolean = age >= 18
    fun bmi(): Double = weight / (height * height)
}