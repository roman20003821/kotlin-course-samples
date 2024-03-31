package edu.ukma.lecture3

import java.io.Closeable

//#region Basic sample
class Container<T> {
    fun add(value: T) {}
}

fun addToContainerSample() {
    val container = Container<Int>()
    container.add(1)
}

class Wrapper<T>(val value: T)

fun autoTypeDetectionSample() {
    val wrapper = Wrapper(1)
}

//#endregion


//#region covariance, contravariance, invariance
class Cat : Animal()

open class Animal

// covariant: List<Cat> is List<Animal>
// contravariant: List<Animal> is List<Cat>
// invariant: List<Cat> is not List<Animal> and List<Animal> is not List<Cat>

fun invarianceProblem() {
    // Такої проблеми не виникає, якщо використовувати незмінні контейнери
    val cats = mutableListOf(Cat(), Cat())
//    val animals: MutableList<Animal> = cats // Помилка компіляції
}

class CovariantContainer<out T> {
    fun getOrNull(index: Int): T? {
        return null
    }
}

fun covarianceSample() {
    val cats = CovariantContainer<Cat>()
    val animals: CovariantContainer<Animal> = cats
}

// contravariance
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun contravarianceSample(x: Comparable<Number>) {
    x.compareTo(1.0) // Можна порівнювати з числом будь-якого типу
    val y: Comparable<Double> = x // Можна порівнювати лише з числом типу Double
}

//#endregion

//#region Constraints
class ContainerWithTypeConstraints<T : Comparable<T>>

fun <T : Comparable<T>> genericFunctionWithConstraint(): T? {
    return null
}

class ContainerWithManyTypeConstraints<T>
        where T : Comparable<T>,
              T : Closeable

//#endregion

//#region Nullability

class ContainerWithProhibitedNullability<T : Any>

class ContainerWithProhibitedNullabilityForAddMethod<T> {
    fun add(value: T & Any) {}
}

fun nullabilitySample() {
    val container = Container<Int?>()
//    val container = ContainerWithProhibitedNullability<Int?>() // Помилка компіляції
//    val container = ContainerWithProhibitedNullabilityForAddMethod<Int?>()
//    container.add(null) // Помилка компіляції
}

//#endregion


abstract class SomeClass<T> {
    abstract fun execute() : T
}

class SomeImplementation : SomeClass<String>() {
    override fun execute(): String = "Test"
}

class OtherImplementation : SomeClass<Int>() {
    override fun execute(): Int = 42
}

object Runner {
    inline fun <reified S: SomeClass<T>, T> run() : T {
        return S::class.java.getDeclaredConstructor().newInstance().execute()
    }
}

fun main() {
    // T is inferred as String because SomeImplementation derives from SomeClass<String>
    val s = Runner.run<SomeImplementation, _>()
    assert(s == "Test")

    // T is inferred as Int because OtherImplementation derives from SomeClass<Int>
    val n = Runner.run<OtherImplementation, _>()
    assert(n == 42)
}
