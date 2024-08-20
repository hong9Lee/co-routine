package com.hg.coroutine.lec8

import com.hg.coroutine.lec1.printWithTread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

fun main(): Unit = runBlocking {
    val result1 = call1()
    val result2 = call2(result1)

    printWithTread(result2)
}

suspend fun call1(): Int {
    return CoroutineScope(Dispatchers.Default).async {
        Thread.sleep(1_000L)
        200
    }.await()
}

suspend fun call2(num: Int): Int {
    return CompletableFuture.supplyAsync {
        Thread.sleep(1_000L)
        100
    }.await()
}

interface AsyncCaller {
    suspend fun call()
}

class AsyncCallerImpl: AsyncCaller {
    override suspend fun call() {
        TODO("Not yet implemented")
    }
}
