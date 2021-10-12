#!/usr/bin/python3
# -*- coding: cp949 -*-

import unittest

from solutions.programmers import network


class Test(unittest.TestCase):
    def test_network_1(self):
        n = network.solution(n=3, computers=[[1, 1, 0], [1, 1, 0], [0, 0, 1]])
        self.assertEqual(2, n)

    def test_network_2(self):
        n = network.solution(n=4, computers=[[1, 1, 1, 0], [1, 1, 0, 1], [1, 0, 1, 0], [0, 1, 0, 1]])
        self.assertEqual(1, n)

    def test_network_3(self):
        n = network.solution(n=3, computers=[[1, 1, 0], [1, 1, 1], [0, 1, 1]])
        self.assertEqual(1, n)


if __name__ == '__main__':
    unittest.main()
