package edu.ukma.lecture1

fun sum(
    a: Int,
    b: Int,
): Int {
    return a + b
}

fun sum2(
    a: Int,
    b: Int,
) = a + b // Якщо тіло функції містить лише один вираз, то існує можливість короткого запису функції

fun sum21(
    a: Int,
    b: Int,
): Int = a + b // В скороченому записі функції можна явно вказати тип, який функція повертає

fun printlnSum(
    a: Int,
    b: Int,
) {
    println(sum(a, b))
}

// За замовчуванням функція повертає обʼєкт класу Unit, тому його вказувати не обовʼязково
fun printlnSum2(
    a: Int,
    b: Int,
) {
    println(sum(a, b))
}

// Приклад вказування значення параметру за замовчуванням
fun printlnSum3(
    a: Int,
    b: Int,
    pretty: Boolean = false,
) {
    if (pretty) {
        println("[${sum(a, b)}]")
    } else {
        printlnSum2(a, b)
    }
}

// Якщо не використовувати вказування параметрів за замовчуванням, цієї самої цілі можна досягнути через function overloading
fun printlnSumOverloading(
    a: Int,
    b: Int,
) {
    printlnSumOverloading(a, b, true)
}

fun printlnSumOverloading(
    a: Int,
    b: Int,
    pretty: Boolean,
) {
    if (pretty) {
        println("[${sum(a, b)}]")
    } else {
        printlnSum2(a, b)
    }
}
