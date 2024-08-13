package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val job1 = async { apiCallBack1() }
        val job2 = async { apiCallBack2(job1.await()) }

        println(job2.await())
    }

    printWithTread("소요시간 : $time ms")
}

suspend fun apiCallBack1(): Int {
    delay(1_000L)
    return 1
}

suspend fun apiCallBack2(num: Int): Int {
    delay(1_000L)
    return num + 2
}
