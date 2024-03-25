package edu.ukma.lecture2

// Так робити не треба
class DogWithoutSugar {
    private var name: String = "Default"

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }
}

class Dog {
    var name: String = "Default"
}

class DogEncapsulated(private val sex: String) {
    private var nameUpdatedAt: Long? = null

    // Додаткова логіка на отримання та зміну значення властивості
    var name: String = "Ralph"
        get() = "${if (sex == "Male") "Mr" else "Ms"} $field" // Не пишіть "${if (sex == "Male") "Mr" else "Ms"} $name", бо зайдете в безкінечний цикл
        set(value) {
            field = value
            nameUpdatedAt = System.currentTimeMillis()
        }

    // Змінну значення властивості можна робити лише всередині в класі
    var age: Int = 5
        private set

    fun nextYear() {
        age += 1
    }
}

fun main() {
    val dogWithNoSugar = DogWithoutSugar()
    dogWithNoSugar.setName("New name")
    dogWithNoSugar.getName()

    val dog = Dog()
    dog.name
    dog.name = "New name"
}
