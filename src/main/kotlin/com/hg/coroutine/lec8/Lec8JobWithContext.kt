package com.hg.coroutine.lec8

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*

/** coroutineScope와 기본적으로 유사하다.
 * context에 변화를 주는 기능이 추가적으로 있다. */
fun main(): Unit = runBlocking {
    printWithTread("START")
    printWithTread(calculateResult())
    printWithTread("END")
}

suspend fun calculateResult(): Int = withContext(Dispatchers.Default) {
    val num1 = async {
        delay(1_000L)
        10
    }

    val num2 = async {
        delay(1_000L)
        20
    }

    num1.await() + num2.await()
}
