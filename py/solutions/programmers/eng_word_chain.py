#!/usr/bin/python3
# -*- coding: cp949 -*-


def solution(n: int, words: [str]) -> [int]:
    ans = [0, 0]
    prev = words[0]
    history = [words[0]]

    pid = 0
    turn = 0

    for word in words[1:]:
        pid = (pid + 1) % n
        turn += 1
        if prev[-1] != word[0] or word in history:
            ans = [pid + 1, int((turn / n) + 1)]
            break
        prev = word
        history.append(word)
    return ans
