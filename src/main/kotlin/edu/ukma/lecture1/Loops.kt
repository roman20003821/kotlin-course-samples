package edu.ukma.lecture1

val items = listOf(1, 2, 3)

// #region for
fun forLoop() {
    for (i in items)
        println(i)

    // Якщо потрібно дуступатися по індексу
    for (i in items.indices)
        println(items[i])

    // Якщо потрібно мати змінну, яка посилається на елемент та індекс одночасно
    for ((i, index) in items.withIndex())
        println("Item: $i, index: $index")

    // Проте на практиці для ітеруванні по спису зазвичай використовується функція forEach, наприклад
    // items.forEach { i -> }
    // items.forEachIndexed { index, i -> }
}

// #endregion

// #region while, do while
fun whileLoop() {
    val iterator = items.iterator()
    while (iterator.hasNext())
        println(iterator.next())
}

fun doWhileLoop() {
    val iterator = items.iterator()
    do {
        println(iterator.next())
    } while (iterator.hasNext())
}

// #endregion

// #region labels
// fun main() {
//    label()
// }

fun label() {
    loop@ for (i in listOf(1, 2, 3)) {
        for (j in listOf(1, 2, 3)) {
            println("i: $i, j: $j")
            if (i == 1) {
                continue@loop
            } else {
                break@loop
            }
        }
    }
    println("End")
}

// #endregion
