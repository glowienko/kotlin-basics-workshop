package org.sytac.kotlin.workshop.solutions

import java.util.Locale
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_7_LambdasSolutions {

    fun List<Runner>.countMatching(predicate: (Runner) -> Boolean): Int = this.count(predicate)
    fun List<Runner>.averageBy(extractor: (Runner) -> Double): Double = map(extractor).average()
    fun <A, B, C> zipAndMap(a: List<A>, b: List<B>, transformation: (A, B) -> C): List<C> {
        return a.zip(b).map { (first, second) -> transformation(first, second) }
    }
}