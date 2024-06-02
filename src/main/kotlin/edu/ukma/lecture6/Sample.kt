package edu.ukma.lecture6

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

fun main() {
//    basicExample()
//    launchExample()
//    coroutineChildSample()
//    cancelAllChildren()
//    supervisorJobSample1()
//    supervisorJobSample2()
//    coroutinesCancellation()
    callbackToCoroutine()
}

private fun basicExample() {
    val userId = 1
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    // Запуск асинхронної корутини
    coroutineScope.launch {
        val userName = getUserNameFromServer(userId)
        saveUserName(userId, userName)
        // Зміна контектсу виконання корутини, оскільки інтрфейс можна оновлювати лише з єдиного потоку
        withContext(Dispatchers.Main) {
            showUserName(userName)
        }
    }
}

private suspend fun getUserNameFromServer(userId: Int): String {
    delay(1.seconds)
    return "Oleg"
}

private suspend fun saveUserName(
    userId: Int,
    userName: String,
) {
    delay(1.seconds)
}

private fun showUserName(userName: String) {
}

fun launchExample() {
    val coroutineScope = CoroutineScope(Dispatchers.Main)
    coroutineScope.launch(
        // Можна передати контекст нової корутини
        CoroutineName("Test") +
            CoroutineExceptionHandler { _, _ -> },
    ) {
        // Блок виконання корутини
    }
    coroutineScope.cancel()
}

fun coroutineChildSample() {
    runBlocking {
        launch {
            println("Child 1")
        }
        launch {
            println("Child 2")
        }
    }
}

fun cancelAllChildren() {
    runBlocking {
        launch {
            while (isActive) {
                println("Let's party!!!")
                delay(0.5.seconds)
            }
        }
        launch {
            throw Exception("No more party today!")
        }
    }
}

fun supervisorJobSample1() {
    val coroutineScope = CoroutineScope(SupervisorJob())
    coroutineScope.launch {
        while (isActive) {
            println("Party has started!!!")
            delay(0.5.seconds)
        }
    }
    coroutineScope.launch {
        throw Exception("No more parties today!")
    }
}

fun supervisorJobSample2() {
    runBlocking {
        // Додавння SupervisorJob до поточного контексту
        supervisorScope {
            launch {
                while (isActive) {
                    println("Party has started!!!")
                    delay(0.5.seconds)
                }
            }
            launch {
                throw Exception("No more parties today!")
            }
        }
    }
}

fun coroutinesCancellation() {
    runBlocking {
        val job =
            launch {
                while (isActive) {
                    println("I'm a cooperative coroutine...")
                    delay(1.seconds)
                }
            }
        job.cancel()
    }
}

fun callbackToCoroutine() {
    runBlocking {
        val resultCode =
            suspendCoroutine { continuation ->
                functionWithCallback(
                    onSuccess = { continuation.resume(it) },
                    onFailure = { continuation.resume(null) },
                )
            }
        println(resultCode)
    }
}

private fun functionWithCallback(
    onSuccess: (Int) -> Unit,
    onFailure: () -> Unit,
) {
    if (Random.nextBoolean()) {
        onSuccess(1)
    } else {
        onFailure()
    }
}
