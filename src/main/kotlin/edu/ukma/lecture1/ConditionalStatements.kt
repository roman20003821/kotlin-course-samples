package edu.ukma.lecture1

//#region If Statement
fun printlnMaxWrong(a: Int, b: Int) {
    // Так писати не треба, оскільки можна зразу значення вираз if присвої змінній max
    var max: Int
    if (a > b)
        max = a
    else
        max = b
    println("Max: $max")
}

fun printlnMaxCorrect1(a: Int, b: Int) {
    // Вираз if може повертати значення
    val max = if (a > b)
        a
    else
        b
    println("Max: $max")
}

fun printlnMaxCorrect2(a: Int, b: Int) {
    // Значення повертати не обовʼяково
    if (a > b)
        println("$a")
    else
        println("$b")
}


fun oneLineIf(a: Int) {
    val b = if (a > 10) 10 else a
//    Тринарного оператора не існує, тому так писати не можна
//    val b = a > 10 ? 10 : a
}

//#endregion

//#region When Statement
fun printlnWhen(a: Int) {
    when (a) {
        1 -> println("a == 1")
        2 -> println("a == 2")
        else -> println("a is neither 1 nor 2")
    }
}

fun printlnWhen2(a: Int) {
    // Те ж саме, що switch(true) в Java
    when {
        a == 1 -> println("a == 1")
        a == 2 -> println("a == 2")
        else -> println("a is neither 1 nor 2")
    }
    // Такий підхід може бути корисним, коли перевірка відбуваєть на основі декількох параметрів, наприклад:
    /* when {
        a == 1 && b < 10 -> ...
        a == 1 -> ...
        a == 5 -> ...
        else -> ...
    }
    Також може підійти, якщо для перевірки використовуєть інший від equals метод, наприклад, compareTo
    */
}

fun getMenuOption(a: Int): String {
    // Вираз when також може повертати значення
    return when (a) {
        0 -> "Ввести слово"
        1 -> "Наступна сторінка"
        else -> "Повернутися назад"
    }
}

enum class Car {
    Volkswagen, Audi, Lanos
}

fun getCarLevel(car: Car): String {
    // Компілятор не вимагає додавання else, оскільки всі опції перераховані
    return when (car) {
        Car.Volkswagen -> "Low"
        Car.Audi -> "Medium"
        Car.Lanos -> "High"
    }
}

//#endregion

//#logical operators
fun main() {
    doConditionally1()
    doConditionally2()
}

fun doConditionally1() {
    if (condition1() && condition2())
        println("End")
}

fun doConditionally2() {
    if (condition1() and condition2())
        println("End")
}

fun condition1(): Boolean {
    println("condition1")
    return false
}

fun condition2(): Boolean {
    println("condition2")
    return true
}

//#endregion

