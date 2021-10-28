package javaps.leetcode

class HammingDistance {

    fun hammingDistance(x: Int, y: Int): Int = x.xor(y).countOneBits()
}
