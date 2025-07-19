package org.sytac.kotlin.workshop

import org.junit.jupiter.api.Test

class NullabilityTest {

    @Test
    fun `should check nullability`() {
        val dev = Contractor(
            firstName = "John",
            lastName = "Doe",
            workPlace = WorkplaceDetails(
                name = "Tech Company",
                address = "123 Tech Street",
                title = "Software Engineer",
                goals = listOf("Improve code quality", "Increase test coverage")
            )
        )

        val contructionWorker = Contractor(
            firstName = "Mike",
            secondName = "Carlo",
            lastName = "Foo",
            workPlace = WorkplaceDetails(
                name = "Chinese Construction Corp",
                address = null,
                title = null,
            )
        )

        val secondDevName2: String? = dev.secondName
        val secondNameNotNullDontDoIt: String = dev.secondName!! // if null - throws NPE
        val secondDevName: String = dev.secondName ?: "No second name provided"
        val secondNameNotNull: String = requireNotNull(secondDevName2)
        val secondDevName3: String = dev.secondName.takeOrEmpty()

        val secondDevNameLen: Int = dev.copy(secondName = null).secondName?.length ?: 0


        val devWorkPlaceAddress: String = dev.workPlace?.address ?: "No address provided"
        val devWorkPlaceAddress2 = dev.workPlace?.let { it.address ?: "No address" }
        val upparCaseAddressDescription: String? = dev.workPlace?.address?.uppercase()?.let { "address of employee: $it" }
        val addressDescription2: String = dev.workPlace
            ?.let { it.address to it.title }
            .takeIf { it?.first != null }
            ?.let { (address, title) ->
                "address: ${requireNotNull(address)} ${title?.let { "of a job title $it" } ?: ""}"
            } ?: throw IllegalStateException(" cannot be null")
    }


    fun String?.takeOrEmpty(): String = this ?: ""

    data class Contractor(
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


