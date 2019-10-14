package com.larry.realworldkotlinarrow

import org.junit.Test

class MonadTest {

    @Test
    fun test1() {
        val result = listOf(1, 2, 3)
                .flatMap { i -> listOf(i * 2, i * 3) }
                .joinToString()
        println(result)
    }


}