package edu.ukma.lecture2

open class Animal(val name: String) {
    open fun walk() {
        println("Animal is walking")
    }
}

class Elephant : Animal("George") {
    override fun walk() {
        println("Elephant is walking")
    }
}
