import unittest

from solutions.boj.connect_network import solution


class Test(unittest.TestCase):
    def test_solution(self):
        ans = solution(6, g=[
            [1, 2, 5],
            [1, 3, 4],
            [2, 3, 2],
            [2, 4, 7],
            [3, 4, 6],
            [3, 5, 11],
            [4, 5, 3],
            [4, 6, 8],
            [5, 6, 8],
        ])
        self.assertEqual(23, ans)


if __name__ == '__main__':
    unittest.main()
