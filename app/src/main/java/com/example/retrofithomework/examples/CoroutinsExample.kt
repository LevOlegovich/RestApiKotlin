package com.example.retrofithomework

import kotlinx.coroutines.*


suspend fun main() = coroutineScope {
    var z = voice { println("hello") }
    var z1 = voice(::f1)
    var z2 = voice(fun() { println("hello") })
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }

    val job = launch(Dispatchers.IO + coroutineExceptionHandler) {
        for (i in 0..5) {
            delay(400L)
            throw Exception()
            println(i)
        }
    }
    job.join()
    println("Hello Coroutines")
//    launch(newSingleThreadContext("Custom Thread")) {   // явным образом определяем диспетчер Dispatcher.Default
//        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
//    }
    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
}

fun voice(s: () -> Unit) {

}

fun f1() {

}
