package edu.ukma.lecture2

class Collector {
    class Cache

    private val cache = Cache()
}

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

val demo = Outer().Inner().foo()
