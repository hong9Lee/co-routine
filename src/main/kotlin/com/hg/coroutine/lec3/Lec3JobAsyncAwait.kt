package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job = async {
        3 + 5
    }

    val await = job.await()
    printWithTread(await)
}



fun example4() {
    runBlocking {
        printWithTread("START")
        launch {
            delay(2_000L)
            printWithTread("LAUNCH END")
        }
    }

    printWithTread("END")
}
