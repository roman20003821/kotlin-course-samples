package edu.ukma.lecture2

fun mapCreation() {
    mapOf(
        "dog" to listOf("Golden Retriever", "Beagle"),
        "cat" to listOf("British Shorthair", "Maine Coon")
    )
}

infix fun String.times(value: Int): String {
    val result = StringBuilder()
    repeat(value) {
        result.append(this)
    }
    return result.toString()
}

fun main() {
    "Lorem ipsum" times 10
    // Infix function це розширена Extension function, тому її можна також застосувувати наступним чином
    "Lorem ipsum".times(10)
}