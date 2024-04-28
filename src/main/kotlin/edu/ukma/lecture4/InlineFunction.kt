package edu.ukma.lecture4

import java.util.concurrent.locks.Lock

inline fun <T> lock(
    lock: Lock,
    body: () -> T,
): T {
    lock.lock()
    return try {
        body()
    } finally {
        lock.unlock()
    }
}

fun lockSample(l: Lock) {
    // Вираз, написаний програмістом
    lock(l) { foo() }

    // Вираз після перетворення компілятором
    l.lock()
    try {
        foo()
    } finally {
        l.unlock()
    }
}

private fun foo() {
}
