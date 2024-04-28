package edu.ukma.lecture2

fun String.removeWhitespaces(): String {
    return replace(" ", "")
}

fun removeWhitespacesUnderTheHood(value: String): String {
    return value.replace(" ", "")
}

fun main() {
    "UNPRO CESSED -SAMPLE"
        .removeWhitespaces()
        .lowercase()
}
