package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        println("Hello launch")
    }

    delay(1_000L)
    job.start()
}
fun example1() {
    runBlocking {
        printWithTread("START")
        launch {
            delay(2_000L)
            printWithTread("LAUNCH END")
        }
    }

    printWithTread("END")
}
