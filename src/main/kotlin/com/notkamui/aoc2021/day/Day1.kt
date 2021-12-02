package com.notkamui.aoc2021.day

import com.notkamui.aoc2021.util.readInput

fun main() {
    val input = readInput("day1.txt").mapNotNull(String::toIntOrNull)
    part1(input)
    part2(input)
}

fun part1(input: List<Int>) {
    println(countIncrease(input))
}

fun part2(input: List<Int>) {
    val windowsSums = input.windowed(3).map(List<Int>::sum)
    println(countIncrease(windowsSums))
}

fun countIncrease(list: List<Int>): Int =
    list.zipWithNext().count { (a, b) -> a < b }