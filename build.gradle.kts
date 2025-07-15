plugins {
    kotlin("jvm") version "2.2.0"
    idea
    java
}

group = "org.sytac.workshop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotestVersion = "5.9.1"
val assertkVersion = "0.28.1"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("com.willowtreeapps.assertk:assertk:$assertkVersion")
}

tasks.test {
    useJUnitPlatform()
}