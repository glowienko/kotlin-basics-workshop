package org.sytac.kotlin.workshop.sport

import java.time.LocalDate
import java.time.Year
import kotlin.random.Random
import kotlin.random.nextInt

interface Human {
    val name: String
    val birtDate: LocalDate
    val height: Double
    val weight: Double
    val age: Int
        get() = LocalDate.now().year - birtDate.year

    fun isAdult(): Boolean = age  >= 18
    fun bmi(): Double = weight / (height * height)

    fun isHealthy(): Boolean = bmi() in 18.5..24.9
}

data class Runner(
    override val name: String,
    override val birtDate: LocalDate,
    override val height: Double,
    override val weight: Double,
    var activeCareer: Boolean = true,
    val medals: List<Medal> = listOf(),
    val gear: MutableList<String> = mutableListOf(),
    val country: String? = null,
    var coach: Coach? = null,
) : Human {
    val nickName: String
        get() = "Runner $name  nr. $age"

    fun assignCoach(coach: Coach): Runner = copy(coach = coach)
    fun addGear(vararg item: String) {
        gear.apply { this.addAll(item) }
    }
    fun retire(): Runner = copy(activeCareer = false)
}

data class Medal(
    val type: MedalType,
    val year: Int,
)

enum class MedalType {
    GOLD, SILVER, BRONZE
}

data class Coach(
    val name: String,
    val experienceYears: Int?,
)