import collections
import operator


def solution(n: int, stages: [int]) -> [int]:
    answer = collections.defaultdict(float)
    stages.sort()
    sc = len(stages)

    s = 0
    challenge = sc
    for i in range(1, n + 1):
        e = s
        while e < sc and stages[e] == i:
            e += 1
        cleared = len(stages[s:e])
        answer[i] = (cleared / challenge) if challenge > 0 else 0
        challenge -= cleared
        s = e

    r_answer = sorted(answer.items(), key=operator.itemgetter(1), reverse=True)
    return list(dict(r_answer).keys())


if __name__ == '__main__':
    print(solution(n=10, stages=[8, 8, 8, 8, 8, 8]))
