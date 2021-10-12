from bisect import bisect_left


def solution(info: [str], query: [str]) -> [int]:
    answer = []

    key_index = {
        '-': 0,
        'cpp': 1, 'java': 2, 'python': 3,
        'backend': 1, 'frontend': 2,
        'junior': 1, 'senior': 2,
        'chicken': 1, 'pizza': 2,
    }

    pre_map = [[] for _ in range(4 * 3 * 3 * 3)]
    for f in info:
        lang, position, career, food, score = f.split()
        offset = (
            key_index[lang] * 3 * 3 * 3,
            key_index[position] * 3 * 3,
            key_index[career] * 3,
            key_index[food],
        )
        for i in range(1 << 4):
            idx = 0
            for j in range(4):
                if i & (1 << j):
                    idx += offset[j]
            pre_map[idx].append(int(score))

    for i in range(4 * 3 * 3 * 3):
        pre_map[i] = sorted(pre_map[i])

    for q in query:
        lang, _, position, _, career, _, food, score = q.split()
        idx = key_index[lang] * 3 * 3 * 3
        idx += key_index[position] * 3 * 3
        idx += key_index[career] * 3
        idx += key_index[food]
        answer.append(len(pre_map[idx]) - bisect_left(pre_map[idx], int(score)))

    return answer


if __name__ == '__main__':
    result = solution(info=["java backend junior pizza 150",
                            "python frontend senior chicken 210",
                            "python frontend senior chicken 150",
                            "cpp backend senior pizza 260",
                            "java backend junior chicken 80",
                            "python backend senior chicken 50"],

                      query=["java and backend and junior and pizza 100",
                             "python and frontend and senior and chicken 200",
                             "cpp and - and senior and pizza 250",
                             "- and backend and senior and - 150",
                             "- and - and - and chicken 100",
                             "- and - and - and - 150"])
    print(result)
