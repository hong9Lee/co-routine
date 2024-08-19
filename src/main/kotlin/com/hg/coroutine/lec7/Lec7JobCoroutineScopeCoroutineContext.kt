package com.hg.coroutine.lec7

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.*
import java.util.concurrent.Executors

suspend fun main() {
    val threadPool = Executors.newSingleThreadExecutor()
    CoroutineScope(threadPool.asCoroutineDispatcher()).launch {
        printWithTread("새로운 코루틴")
    }

    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithTread("Job 1")
        coroutineContext + CoroutineName("123")
        printWithTread(coroutineContext.minusKey(CoroutineName.Key))
    }

//    Thread.sleep(1_500L)
    job.join()
}

class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {

        }
    }

    fun destroy() {
        scope.cancel()
    }
}




