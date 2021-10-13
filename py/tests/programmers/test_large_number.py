#!/usr/bin/python3
# -*- coding: cp949 -*-

import unittest

from solutions.programmers import large_number


class Test(unittest.TestCase):
    def test_solution_1(self):
        a = large_number.solution(number="1924", k=2)
        self.assertEqual('94', a)

    def test_solution_2(self):
        a = large_number.solution(number="1231234", k=3)
        self.assertEqual('3234', a)

    def test_solution_3(self):
        a = large_number.solution(number="4177252841", k=4)
        self.assertEqual('775841', a)

    def test_solution_4(self):
        a = large_number.solution(number="99999", k=3)
        self.assertEqual('99', a)


if __name__ == '__main__':
    unittest.main()
