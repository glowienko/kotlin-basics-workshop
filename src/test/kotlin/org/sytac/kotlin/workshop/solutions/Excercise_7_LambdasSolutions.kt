package org.sytac.kotlin.workshop.solutions

import java.util.Locale
import org.sytac.kotlin.workshop.sport.Runner

object Excercise_7_LambdasSolutions {

    private fun List<Runner>.countMatchingPredicate(predicate: (Runner) -> Boolean): Int = this.count(predicate)
    private fun List<Runner>.averageByExtractor(extractor: (Runner) -> Double): Double = map(extractor).average()
    private fun <A, B, C> zipAndMapGenericMagic(a: List<A>, b: List<B>, transformation: (A, B) -> C): List<C> {
        return a.zip(b).map { (first, second) -> transformation(first, second) }
    }
}