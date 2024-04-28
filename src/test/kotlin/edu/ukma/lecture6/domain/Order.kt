package edu.ukma.lecture6.domain

class Order(
    private val product: String,
    private val amount: Int,
) {
    fun fill(warehouse: Warehouse) {
        if (warehouse.hasInventory(product, amount)) {
            warehouse.remove(product, amount)
        }
    }
}
