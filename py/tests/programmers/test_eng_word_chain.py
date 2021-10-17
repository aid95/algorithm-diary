import unittest

from solutions.programmers.eng_word_chain import solution


class Test(unittest.TestCase):
    def test_solution(self):
        got = solution(n=3, words=["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"])
        self.assertEqual([3, 3], got)

    def test_solution_2(self):
        got = solution(n=5, words=["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                                   "establish", "hang", "gather", "refer", "reference", "estimate", "executive"])
        self.assertEqual([0, 0], got)

    def test_solution_3(self):
        got = solution(n=2, words=["hello", "one", "even", "never", "now", "world", "draw"])
        self.assertEqual([1, 3], got)


if __name__ == '__main__':
    unittest.main()
