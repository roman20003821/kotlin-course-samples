package edu.ukma.lecture2

class Node<T>(
    val previous: Node<T>?,
    val next: Node<T>?,
    val value: T,
) {
    operator fun component1(): Node<T>? = previous

    operator fun component2(): Node<T>? = next

    operator fun component3(): T = value
}

fun main() {
    val (previous, next, value) = Node(previous = null, next = null, 1)
    println("$previous, $next, $value")
}
