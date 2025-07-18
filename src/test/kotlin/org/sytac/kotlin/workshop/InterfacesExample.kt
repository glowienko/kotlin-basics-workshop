package org.sytac.kotlin.workshop

interface Nameable {
    val name: String
}

interface Person : Nameable {
    val firstName: String
    val lastName: String
    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    override val firstName: String,
    override val lastName: String,
    // no need to override 'name' - but we can
    //eg. override val name: String = "Employee $firstName",
    val position: Position
) : Person {
    //we can also override getter here
    //override val name: String get() = "Employee $firstName, $lastName"
}

data class Position(val x: Int, val y: Int)