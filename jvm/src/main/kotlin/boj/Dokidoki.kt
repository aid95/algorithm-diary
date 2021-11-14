package boj

import java.util.*

class Dokidoki {

    fun solution(line: Array<Int>): Boolean {
        val stack = Stack<Int>()
        var enterNum = 1
        for (num in line) {
            if (num == enterNum) {
                enterNum++
            } else if (!stack.isEmpty() && stack.peek() == enterNum) {
                enterNum++
                stack.pop()
            } else {
                stack.push(num)
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != enterNum) {
                break
            }
            enterNum++
            stack.pop()
        }

        return stack.size == 0
    }
}
