package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class AC constructor(private val numbers: ArrayDeque<Int>) {

    private var strategyConsumer = forwardConsumer

    companion object {
        val forwardConsumer = fun(q: ArrayDeque<Int>) = q.removeFirst()
        val ReverseConsumer = fun(q: ArrayDeque<Int>) = q.removeLast()
    }

    fun execute(commands: Array<Command>) {
        commands.asSequence().forEach(::machine)
    }

    private fun machine(command: Command) {
        when (command) {
            Command.D -> consumer()
            Command.R -> changeStrategy()
        }
    }

    private fun consumer() {
        strategyConsumer(numbers)
    }

    fun show() {
        println("[$this]")
    }

    override fun toString(): String {
        if (numbers.isEmpty()) return ""

        val sb = StringBuilder()
        while (!numbers.isEmpty()) {
            sb.append(strategyConsumer(numbers)).append(',')
        }

        val result = sb.toString();
        return result.substring(0, result.length - 1)
    }

    private fun procedure() = strategyConsumer(numbers)

    private fun changeStrategy() {
        strategyConsumer = if (strategyConsumer == forwardConsumer) {
            ReverseConsumer;
        } else {
            forwardConsumer;
        }
    }
}

sealed class Command {
    object R : Command()
    object D : Command()
}

fun ac(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().trim().toInt()
    repeat(tc) {
        val commands = br.readLine().trim().toCharArray().map(Char::toCommand).toTypedArray()
        br.readLine()
        val aq = ArrayDeque<Int>()
        br.readLine().trim().replace("[", "").replace("]", "").split(",").filter { it.isNotEmpty() }
            .mapTo(aq, String::toInt)
        val ac = AC(aq)
        try {
            ac.execute(commands)
            ac.show()
        } catch (e: NoSuchElementException) {
            println("error")
        }
    }
}

fun Char.toCommand(): Command =
    when (this) {
        'R' -> Command.R
        'D' -> Command.D
        else -> throw IllegalArgumentException()
    }
