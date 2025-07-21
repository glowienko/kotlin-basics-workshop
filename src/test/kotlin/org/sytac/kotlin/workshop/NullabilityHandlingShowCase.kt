package org.sytac.kotlin.workshop

import org.junit.jupiter.api.Test

class NullabilityTest {

    @Test
    fun `should check nullability`() {
        val javaDev = Developer(
            firstName = "John",
            lastName = "Doe",
            workPlace = WorkplaceDetails(
                name = "Tech Company",
                address = "123 Tech Street",
                title = "Software Engineer",
                goals = listOf("Improve code quality", "Increase test coverage")
            )
        )

        val nullValue: String? = null
        val elvisValue: String = nullValue ?: "fallback value taken"
        val elvisFallbackLength: Int = nullValue?.length ?: 0
        val nullableLength: Int? = nullValue?.length // ok - return just null

        println(elvisValue) // prints "fallback value taken"
        println(elvisFallbackLength) // prints 0

        val nonNullString: String = nullValue!! //NPE exception!
        val lengthOfNull: Int = nullValue!!.length //NPE exception!
        val lengthOfNull2: Int? = nullValue?.length// safe call, returns null



        val secondDevName2: String? = javaDev.secondName
        val secondDevName: String = javaDev.secondName ?: "No second name provided"
        val secondNameNotNull: String = requireNotNull(secondDevName2)
        val secondDevName3: String = javaDev.secondName.takeOrEmpty()
        val secondNameNotNullDontDoIt: String = javaDev.secondName!! // if null - throws NPE

        val secondDevNameLen: Int = javaDev.copy(secondName = null).secondName?.length ?: 0

        val devWorkPlaceAddress2: String? = javaDev.workPlace?.let { it: WorkplaceDetails -> it.address ?: "No address" }
        val devWorkPlaceAddress3: String? = javaDev.workPlace?.let { it.address ?: "No address" }
        val upparCaseAddressDescription: String? = javaDev.workPlace?.address?.uppercase()?.let { "address of employee: $it" }
        val addressDescription2: String = javaDev.workPlace
            ?.let { it.address to it.title }
            .takeIf { it?.first != null }
            ?.let { (address, title) ->
                "address: ${requireNotNull(address)} ${title?.let { "of a job title $it" } ?: ""}"
            } ?: throw IllegalStateException(" cannot be null")
    }


    fun String?.takeOrEmpty(): String = this ?: ""

    data class Developer(
        val firstName: String,
        val secondName: String? = null,
        val lastName: String,
        val workPlace: WorkplaceDetails?,

        )

    data class WorkplaceDetails(
        val name: String,
        val address: String? = null,
        val title: String?,
        val goals: List<String> = emptyList(),
    )
}


