package javaps.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

class DistributedComputing {

    fun init() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().trim().toInt()
        repeat(t) {
            val (a, b) = br.readLine().trim().split(" ").map { it.toBigInteger() }
            println(solution(a, b))
        }
    }

    fun solution(a: BigInteger, b: BigInteger): BigInteger = a.modPow(b, BigInteger.TEN).let {
        if (it.equals(BigInteger.ZERO)) BigInteger.TEN else it
    }
}
