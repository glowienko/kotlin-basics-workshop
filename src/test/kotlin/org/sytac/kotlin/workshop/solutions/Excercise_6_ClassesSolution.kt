package org.sytac.kotlin.workshop.solutions

import org.sytac.kotlin.workshop.RunnerFixture.RUNNERS_LIST
import org.sytac.kotlin.workshop.RunnerFixture.SIMPLE_RUNNER
import org.sytac.kotlin.workshop.sport.Coach
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_6_ClassesSolution {

    private val result = RUNNERS_LIST.runCatching { firstOrNull()?.retire() }
        .onSuccess { it: Runner? -> println("runner retired: ${it?.activeCareer ?: false}!") }
        .onFailure { throw IllegalStateException("error") }
        .map { it?.activeCareer }
        .getOrThrow()

    private infix fun Runner.sameAgeAs(other: Runner): Boolean = this.age == other.age

    private val resultDescription = SIMPLE_RUNNER
        .apply { coach = Coach("John's Coach", 5) }
        .run { "Runner $name, age: ${age}, coach: ${coach?.name}" }
}