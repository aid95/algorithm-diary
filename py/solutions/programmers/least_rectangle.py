def solution(sizes: list[list[int]]) -> int:
    print(sum(sizes, []))

    max_width = 0
    max_height = 0
    for size in sizes:
        if size[0] < size[1]:
            size[0], size[1] = size[1], size[0]
        max_width = max(max_width, size[0])
        max_height = max(max_height, size[1])
    return max_width * max_height


if __name__ == '__main__':
    test_cases = [
        [[60, 50], [30, 70], [60, 30], [80, 40]],
        [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]],
        [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
    ]
    for tc in test_cases:
        print(solution(sizes=tc))
