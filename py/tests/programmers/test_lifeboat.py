#!/usr/bin/python3
# -*- coding: cp949 -*-

import unittest

import solutions.programmers.lifeboat


class Test(unittest.TestCase):
    def test_solution_1(self):
        n = solutions.programmers.lifeboat.solution(people=[70, 50, 80, 50], limit=100)
        self.assertEqual(3, n)

    def test_solution_2(self):
        n = solutions.programmers.lifeboat.solution(people=[70, 80, 50], limit=100)
        self.assertEqual(3, n)

    def test_solution_3(self):
        n = solutions.programmers.lifeboat.solution(people=[20, 30, 50], limit=100)
        self.assertEqual(2, n)


if __name__ == '__main__':
    unittest.main()
