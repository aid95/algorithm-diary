# -*- coding: utf-8 -*-
import sys

rl = sys.stdin.readline


def binary_search(arr: list[int], target: int) -> bool:
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] > target:
            high = mid - 1
        if arr[mid] == target:
            return True
        if arr[mid] < target:
            low = mid + 1
    return False


def solution(seq: list[int], qz: list[int]):
    for n in qz:
        if binary_search(seq, n):
            print(1)
        else:
            print(0)


if __name__ == '__main__':
    rl()
    s = sorted([int(x) for x in rl().split()])
    rl()
    q = [int(x) for x in rl().split()]
    solution(seq=s, qz=q)
