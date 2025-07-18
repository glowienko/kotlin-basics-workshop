package org.sytac.kotlin.workshop

@JvmRecord
internal data class Dog(val name: String?, val breed: String) {
    init {
        requireNotNull(name)

        require(!name.isBlank()) { "Name cannot be blank" }
        require(breed.isBlank().not()) { "Breed cannot be or blank" }

        if (breed.lowercase().contains("pit bull")) error { "Cannot create Pit bull, it is too dangerous!!!" }

        check(name == "Rocky Balboa" && breed != "Chihuahua") { "Rocky Balboa cannot be a Chihuahua, he is a Rottweiler!" }
    }
}

fun startRun() {
    println("Starting a run with the dog!")
    val john = Athlete("John Doe",  "Running", 25)
    val (name, discipline, age) = john

}

abstract class Human(name: String)
interface Runnable {
    fun run() {
        println("Running...")
    }

    abstract fun train()
}

data class Athlete(
    val name: String,
    val discipline: String?,
    val age: Int,
    var activeCareer: Boolean = true,
) {

    init {
        require(age < MAX_AGE)
    }

    companion object {
        const val MAX_AGE = 100
        fun create(name: String, age: Int, discipline: String? = null): Athlete {
            return Athlete(name, discipline, age, activeCareer = true)
        }
    }
}

object Singleton {
    val instance: Athlete = Athlete("Singleton", "running", 25)
}

