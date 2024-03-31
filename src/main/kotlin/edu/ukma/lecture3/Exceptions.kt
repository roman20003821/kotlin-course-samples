package edu.ukma.lecture3

import java.io.Closeable
import java.text.DateFormat
import java.text.ParseException
import java.util.*

//#region Basic sample
class Info(val data: String) {
    companion object {
        fun default() = Info("No data")
    }
}

fun tryCatchSample() {
    try {
        fetchInfo()
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        println("End of the sample")
    }
}

fun tryCatchReturnsDataSample() {
    // Блок try catch повертає значення
    val info = try {
        fetchInfo()
    } catch (e: Exception) {
        Info.default()
    }
}

private fun fetchInfo(): Info {
    throw Exception("Unable to fetch info")
}

//#endregion

//#region Exception propagation
fun exceptionPropagationSample() {
    try {
        updateUserPassword(1, "incorrect")
    } catch (e: Exception) {
        // Тут може бути додадкова логіка обробки помилок
    }
}

private fun updateUserPassword(userId: Int, password: String) {
    saveUserPassword(userId, password)
    sendNotificationAboutUserPasswordUpdate(userId)
}

private fun saveUserPassword(userId: Int, password: String) {
    throw Exception("Unable to save user password")
}

private fun sendNotificationAboutUserPasswordUpdate(userId: Int) {
    println("Sending notification to user with id $userId")
}

//#endregion

//#region Kotlin exception handling style
@JvmInline
value class OrderId(val value: Int)

data class Order(
    val id: OrderId,
    var quantity: Int
)

fun highLevelFunction() {
    // можна зробити переповтор або іншу логіку
    for (i in 0 until 3) {
        try {
            updateOrderQuantity(OrderId(1), 1)
            println("Attempt #${i + 1} succeed")
            break
        } catch (e: Exception) {
            println("Attempt #${i + 1} failed")
        }
    }
}

fun updateOrderQuantity(orderId: OrderId, quantity: Int) {
    require(quantity > 0) { "Quantity must be positive" }
    val order = loadOrder(orderId)
    order.quantity = quantity
    storeOrder(order)
}

private fun loadOrder(orderId: OrderId): Order {
    return Order(orderId, 0)
}

private fun storeOrder(order: Order) {
    throw Exception("IO exception")
}

fun orNullSample() {
    val list = listOf(1, 2, 3)
    val item = list.getOrNull(3) ?: 0
}

fun sealedClassSample() {
    when (val dateParseResult = DateFormat.getDateInstance().tryParse("31.03.2024")) {
        is ParsedDate.Success -> {}
        is ParsedDate.Failure -> {}
    }
}

sealed class ParsedDate {
    data class Success(val date: Date) : ParsedDate()
    data class Failure(val errorOffset: Int) : ParsedDate()
}

fun DateFormat.tryParse(text: String): ParsedDate =
    try {
        ParsedDate.Success(parse(text))
    } catch (e: ParseException) {
        ParsedDate.Failure(e.errorOffset)
    }

fun runCatchingSample() {
    runCatching { getItem(0) }.getOrNull()
}

private fun getItem(index: Int): Int {
    throw Exception("Item does not exist")
}

//#endregion

//#region Use
class TcpConnection private constructor() : Closeable {
    fun send(message: String) {

    }

    override fun close() {

    }

    companion object {
        fun open() = TcpConnection()
    }
}

fun useSample() {
    TcpConnection.open().use { connection ->
        connection.send("Message1")
        connection.send("Message2")
    }
}

//#endregion
