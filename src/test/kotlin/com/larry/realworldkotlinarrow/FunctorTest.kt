package com.larry.realworldkotlinarrow

import org.junit.Test


/**
 *
 * interface Functor<C<_>> {
 *   fun <A, B> map(ca:C<A>, transform:(A) -> B): C<B>
 * }
 *
 * interface Applicative<C<_>> {
 *   fun <A> pure(a: A): C<A>
 *   fun <A, B> ap(ca: C<A>, fab: C<(A) -> B>): C<B>
 * }
 *
 * interface Monad<C<_>> {
 *   fun <A, B> flatMap(ca: C<A>, fm: (A) -> C<B>): C<B>
 * }
 *
 */

class Test {

    @Test
    fun functor1() {
        listOf(1, 2, 3)
                .map { it * 2 }
                .map(Int::toString)
                .forEach(::println)
    }

    @Test
    fun functor2() {
        println(
                Option.Some("Kotlin")
                        .map1 { value -> "hello $value" }
        )
    }

    @Test
    fun functor3() {
        val add3AndMultiplyBy2: (Int) -> Int = { i: Int -> i + 3 }.map { j -> j * 2 }
    }

    @Test
    fun monad1() {
        val result = listOf(1, 2, 3)
                .flatMap { i -> listOf(i * 2, i * 3) }
                .joinToString()
        println(result)
    }

    @Test
    fun monad2() {
        Option.Some(80.0)
                .flatMap { p ->
                    if (p > 50.0) Option.Some(5.0)
                    else Option.None
                }
    }

    @Test
    fun monad3() {
        val numbers = listOf(1, 2, 3)
        val functions =listOf<(Int) -> Int>({i -> i * 2}, {i -> i * 3})
        val result = numbers.flatMap {n ->
            functions.map { f -> f(n) }
        }.joinToString()
        println(result)
    }
}

sealed class Option<out T> {
    object None : Option<Nothing>() {
        override fun toString() = "None"
    }

    data class Some<out T>(val value: T) : Option<T>()
//    companion object
}

fun <T, R> Option<T>.map1(transform: (T) -> R): Option<R> = when (this) {
    Option.None -> Option.None
    is Option.Some -> Option.Some(transform(value)) // is 를 써야만 value field 를 가져올 수 있음
}

fun <T, R> Option<T>.map2(transform: (T) -> R): Option<R> = flatMap { t -> Option.Some(transform(t)) }

fun <T, R> Option<T>.flatMap(fm: (T) -> Option<R>): Option<R> = when (this) {
    Option.None -> Option.None
    is Option.Some -> fm(value)
}

fun <A, B, C> ((A) -> B).map(transform: (B) -> C): (A) -> C = { t -> transform(this(t)) }



