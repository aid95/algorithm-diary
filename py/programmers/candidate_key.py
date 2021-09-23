from itertools import combinations


def solution(relation: [[str]]) -> int:
    row_to_col = list(zip(*relation))
    index_map = [i for i in range(len(row_to_col))]
    key_combinations = []
    for n in range(1, len(row_to_col) + 1):
        for t in combinations(index_map, n):
            col_merge = list(zip(*(row_to_col[i] for i in t)))
            if len(col_merge) == len(set(col_merge)):
                for key in key_combinations:
                    if set(key).issubset(t):
                        break
                else:
                    key_combinations.append(t)
    return len(key_combinations)


if __name__ == '__main__':
    result = solution(relation=[["100", "ryan", "music", "2"],
                                ["200", "apeach", "math", "2"],
                                ["300", "tube", "computer", "3"],
                                ["400", "con", "computer", "4"],
                                ["500", "muzi", "music", "3"],
                                ["600", "apeach", "music", "2"]])
    print(result)
