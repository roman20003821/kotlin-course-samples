@file:Suppress("MayBeConstant")

package edu.ukma.lecture1

fun main() {
//    val a = 4
//    a = 5

//    var b = 4
//    b = 5

    val int = 1
    val int2: Int = 1

    val long = 1L
    val long2: Long = 1
}

const val C = 54
const val C2 = C.toByte()
// lowercase не може виконатися на етапі компіляції, тому так робити не можна
// const val C3 = C.toString().lowercase()

val a: Boolean = true
val b: Char = 'a'
