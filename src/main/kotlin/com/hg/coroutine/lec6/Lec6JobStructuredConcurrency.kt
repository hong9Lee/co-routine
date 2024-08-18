package com.hg.coroutine.lec6

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    launch {
        delay(600L)
        printWithTread("A")
    }

    launch {
        delay(500L)
        throw IllegalArgumentException("코루틴 실패!")
    }
}



