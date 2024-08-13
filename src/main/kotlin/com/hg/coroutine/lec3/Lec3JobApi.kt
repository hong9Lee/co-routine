package com.hg.coroutine.lec3

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val job1 = async(start = CoroutineStart.LAZY) { apiCall1() }
        val job2 = async(start = CoroutineStart.LAZY) { apiCall2() }

        job1.start()
        job2.start()
        println(job1.await() + job2.await())
    }

    printWithTread("소요시간 : $time ms")
}

suspend fun apiCall1(): Int {
    delay(1_000L)
    return 1
}

suspend fun apiCall2(): Int {
    delay(1_000L)
    return 2
}
