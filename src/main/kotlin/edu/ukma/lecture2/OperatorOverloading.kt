package edu.ukma.lecture2

class Container<T> {
    private val internalList = ArrayList<T>()

    fun add(value: T) {
        internalList.add(value)
    }

    operator fun get(index: Int): T {
        return internalList[index]
    }
}

class Money(private val amount: Int) {
    operator fun plus(value: Money): Money {
        return Money(amount + value.amount)
    }
}

fun main() {
    val numberContainer = Container<Int>()
    numberContainer.add(4)
    numberContainer.add(5)

    println("Item at index 0 is ${numberContainer[0]}")

    val sum = Money(5) + Money(6)
}
