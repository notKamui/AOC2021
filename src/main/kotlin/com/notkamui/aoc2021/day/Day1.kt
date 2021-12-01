package com.notkamui.aoc2021.day

import com.notkamui.aoc2021.util.readInput
import com.notkamui.aoc2021.util.zipTriple

fun main() {
    val input = readInput("day1.txt").mapNotNull(String::toIntOrNull)
    part1(input)
    part2(input)
}

fun part1(input: List<Int>) {
    println(countIncrease(input))
}

fun part2(input: List<Int>) {
    val windowsSums = input.zipTriple().map { (a, b, c) -> a + b + c }
    println(countIncrease(windowsSums))
}

fun countIncrease(list: List<Int>): Int =
    list.zipWithNext().count { (a, b) -> a < b }