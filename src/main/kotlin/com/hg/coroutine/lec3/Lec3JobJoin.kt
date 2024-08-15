package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(1_000)
        printWithTread("Job 1")
    }
    job1.join()

    val job2 = launch {
        delay(1_000)
        printWithTread("Job 2")
    }

}
