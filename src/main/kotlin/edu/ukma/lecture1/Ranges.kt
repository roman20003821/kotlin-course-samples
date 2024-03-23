package edu.ukma.lecture1

fun range() {
    for (i in 1..10)
        println(i)
    // Можна вказати крок; until використовується для побудови діапазону <=; < (останній елемент не вхожить в діапазон)
    for (i in 1 until 10 step 2)
        println(i)
    // Спадаючий діапазон
    for (i in 10 downTo 1)
        println(i)
}
