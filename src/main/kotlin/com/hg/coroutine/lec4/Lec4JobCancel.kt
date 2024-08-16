package com.hg.coroutine.lec4

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job = launch(Dispatchers.Default) {
        var i = 1
        var nexPrintTime = System.currentTimeMillis()

        while (isActive && i <= 5) {
            if(nexPrintTime <= System.currentTimeMillis()) {
                printWithTread("${i++}번째 출력 !!")
                nexPrintTime += 1_000L
            }
        }
    }

    delay(100L)
    job.cancel()
}

fun main2(): Unit = runBlocking {
    val job = launch {
        try {
            delay(1_000L)
        } catch (e: CancellationException) {

        }
    }

    printWithTread("delay에 의해 취소되지 않았다!")
}

fun lec4Example1(): Unit = runBlocking {
    val job1 = launch {
        delay(1_000L)
        printWithTread("Job 1")
    }
}
