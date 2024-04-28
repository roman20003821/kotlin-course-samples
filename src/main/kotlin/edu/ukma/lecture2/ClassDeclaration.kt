package edu.ukma.lecture2

class Car(
    private val name: String = "Unknown",
    private val yearOfManufacturing: Int = 1970,
)

// Інший варіант вказування значень змінних за замовчуванням
class CarMultipleConstructors(
    private val name: String,
    private val yearOfManufacturing: Int,
) {
    constructor(name: String) : this(name, 1970) {
        println("Default year of manufacturing used")
    }
}

// Так робити не треба
class CarDoNotDo(
    name: String,
    yearOfManufacturing: Int,
) {
    private val name: String
    private val yearOfManufacturing: Int

    init {
        this.name = name
        this.yearOfManufacturing = yearOfManufacturing
    }
}

// Не обовʼязково оголошувати параметр конструктора як змінну класу, якщо для наступних обрахунків цю змінну не потрібно
class Car2(name: String) {
    private val carLevel: String =
        when (name) {
            "Nissan" -> "High"
            else -> "Low"
        }

    fun ride() {
//        println(name)
    }
}

// Якщо потрібно виконати код при ініціалізації обʼєкту, його потрібно прописати в init блоці
class CarWithInit(
    private val name: String,
    private val yearOfManufacturing: Int,
) {
    init {
        startTheEngine()
    }

    private fun startTheEngine() {
        println("Engine started")
    }
}

fun main() {
    val car = Car("McQueen", 1995)
}
