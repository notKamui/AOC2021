package com.notkamui.aoc2021.day

import com.notkamui.aoc2021.util.readInput


// this is obviously overkill, but I just wanted to do an adapter pattern
fun main() {
    val input = readInput("day2.txt").map {
        val (move, d) = it.split(" ")
        Movement(move, d.toInt())
    }
    processMovements(input, object : MovementProcessor {
        override fun forward(position: Position, x: Int) {
            position.horizontal += x
        }

        override fun down(position: Position, x: Int) {
            position.depth += x
        }

        override fun up(position: Position, x: Int) {
            position.depth -= x
        }

    })
    processMovements(input, object : MovementProcessor {
        override fun forward(position: Position, x: Int) {
            position.horizontal += x
            position.depth += position.aim * x
        }

        override fun down(position: Position, x: Int) {
            position.aim += x
        }

        override fun up(position: Position, x: Int) {
            position.aim -= x
        }

    })
}

data class Movement(val move: String, val distance: Int)

data class Position(var horizontal: Int = 0, var depth: Int = 0, var aim: Int = 0)

interface MovementProcessor {
    fun forward(position: Position, x: Int)
    fun down(position: Position, x: Int)
    fun up(position: Position, x: Int)
}

fun processMovements(input: List<Movement>, processor: MovementProcessor) {
    val pos = Position()
    input.forEach {
        when (it.move) {
            "forward" -> processor.forward(pos, it.distance)
            "down" -> processor.down(pos, it.distance)
            "up" -> processor.up(pos, it.distance)
        }
    }
    println(pos.horizontal * pos.depth)
}