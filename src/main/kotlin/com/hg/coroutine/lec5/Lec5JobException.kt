package com.hg.coroutine.lec5

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler{_, throwable ->
        printWithTread("예외 발생")
        throw throwable
    }

    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}



