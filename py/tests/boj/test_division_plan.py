import unittest

from solutions.boj.division_plan import solution


class Test(unittest.TestCase):
    def test_solution(self):
        g = [[1, 2, 3],
             [1, 3, 2],
             [3, 2, 1],
             [2, 5, 2],
             [3, 4, 4],
             [7, 3, 6],
             [5, 1, 5],
             [1, 6, 2],
             [6, 4, 1],
             [6, 5, 3],
             [4, 5, 3],
             [6, 7, 4]]
        n = solution(7, 12, g)
        self.assertEqual(8, n)


if __name__ == '__main__':
    unittest.main()
