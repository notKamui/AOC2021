package com.notkamui.aoc2021.util

import java.io.File
import java.security.MessageDigest

fun readInput(fname: String): List<String> = File("inputs", fname).readLines()

fun String.md5(): String = MessageDigest
    .getInstance("MD5")
    .digest(toByteArray())
    .joinToString { "%02x".format(it) }

infix fun <A, B, C> Pair<A, B>.to(third: C): Triple<A, B, C> = Triple(first, second, third)

fun <T> List<T>.zipTriple(): List<Triple<T, T, T>> {
    val res = mutableListOf<Triple<T, T, T>>()
    for (i in indices) {
        if (i + 2 < size) {
            res += this[i] to this[i + 1] to this[i + 2]
        }
    }
    return res
}