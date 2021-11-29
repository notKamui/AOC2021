package com.notkamui.aoc2021.util

import java.io.File
import java.security.MessageDigest

fun readInput(fname: String): List<String> = File(fname).readLines()

fun String.md5(): String = MessageDigest
    .getInstance("MD5")
    .digest(toByteArray())
    .joinToString { "%02x".format(it) }
