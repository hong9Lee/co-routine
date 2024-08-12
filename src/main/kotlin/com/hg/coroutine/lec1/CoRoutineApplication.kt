package com.hg.coroutine.lec1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(): Unit = runBlocking {
	printWithTread("START")
	launch {
		newRoutine()
	}
	yield()
	printWithTread("END")
}

suspend fun newRoutine() {
	val num1 = 1
	val num2 = 2
	yield()
	printWithTread("${num1 + num2}")
}

fun printWithTread(str: Any) {
	println("[${Thread.currentThread().name}] $str")
}
