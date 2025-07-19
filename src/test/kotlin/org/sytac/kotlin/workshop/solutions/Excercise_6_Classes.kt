package org.sytac.kotlin.workshop.solutions

import java.util.Locale
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_6_Classes {

    private infix fun Runner.sameAgeAs(other: Runner): Boolean = this.age == other.age

//    val resultDescription = runner.run { "Runner $name, age: ${age}, active: $activeCareer" }
}