package com.hg.coroutine.lec8

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*

/** coroutineScope와 기본적으로 유사하다.
 * 주어진 시간 안에 새로 생긴 코루틴이 완료되어야 한다.
 * 주어진 시간 안에 코루틴이 완료되지 못하면 예외를 던지게 null을 반환한다.*/
fun main(): Unit = runBlocking {
    val result: Int = withTimeout(1_000L) {
        delay(1_500L)
        10 + 20
    }
    printWithTread(result)
}

