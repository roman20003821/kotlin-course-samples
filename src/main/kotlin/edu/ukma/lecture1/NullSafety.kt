package edu.ukma.lecture1

class Person(
    val name: String,
    val parent: Person?,
    val age: Int,
)

// #region declaration
val t: String? = null

fun lengthOrNull1(value: String?): Int? {
    // Так робити не треба
    return if (value != null) {
        value.length
    } else {
        null
    }
}

// #endregion

fun lengthOrNull2(value: String?): Int? {
    return value?.length
}

// #region chain of operations
fun chainOfOperations() {
    val person = findPersonByNameOrNull("Oleksandr")
    println(person?.parent?.name)
    /*
    Немає потреби писати
    if (person != null) {
        if (person.parent != null)
            println(person.parent.name)
    }
     */
}

// Функція використовується лише для прикладу
fun findPersonByNameOrNull(name: String): Person? = null

// #endregion

// #region elvis operator
fun elvis() {
    // Для присвоєння значення змінній
    val personNameOrDefault = findPersonByNameOrNull("Oleksandr")?.age ?: 18

    // Для переривання функції
    val person1 = findPersonByNameOrNull("Oleksandr") ?: return

    // Для викидування помилок
    val person2 = findPersonByNameOrNull("Oleksandr") ?: throw Exception("Person with name Oleksandr not found")
}

// #endregion

// #region force unwrap
fun forceUnwrap() {
    val person = findPersonByNameOrNull("Oleksandr")
    // Якщо person == null або person.parent == null, тоді виникне NullPointerException. Так робити не треба
    println(person!!.parent!!.name)
}

// #endregion
