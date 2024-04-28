package edu.ukma.lecture6.domain

class Warehouse {
    private val inventory = HashMap<String, Int>()

    fun hasInventory(
        product: String,
        amount: Int,
    ): Boolean {
        return true
    }

    fun add(
        product: String,
        amount: Int,
    ) {
        inventory[product] = inventory.getOrDefault(product, 0) + amount
    }

    fun remove(
        product: String,
        amount: Int,
    ) {
        val newAmount = inventory.getOrDefault(product, 0) - amount
        check(newAmount >= 0)
        inventory[product] = newAmount
    }
}
