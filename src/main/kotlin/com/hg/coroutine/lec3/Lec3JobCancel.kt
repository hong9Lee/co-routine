package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch {
        (1..5).forEach {
            printWithTread(it)
            delay(500)
        }

    }

    delay(1_000L)
    job.cancel()
}

fun example2() {
    runBlocking {
        printWithTread("START")
        launch {
            delay(2_000L)
            printWithTread("LAUNCH END")
        }
    }

    printWithTread("END")
}
