def button_distance(x1: int, y1: int, x2: int, y2: int) -> int:
    return abs(x1 - x2) + abs(y1 - y2)


def solution(numbers: [int], hand: str) -> str:
    answer = ''

    button_map = {
        '*': [0, 3],
        0: [1, 3],
        '#': [2, 3]
    }
    button_num = 1
    for y in range(3):
        for x in range(3):
            button_map[button_num] = [x, y]
            button_num += 1

    l_pos = button_map['*']
    r_pos = button_map['#']
    for number in numbers:
        if number in [1, 4, 7]:
            l_pos = button_map[number]
            answer += 'L'
        elif number in [3, 6, 9]:
            r_pos = button_map[number]
            answer += 'R'
        else:
            current_button = button_map[number]
            l_mann = button_distance(l_pos[0], l_pos[1], current_button[0], current_button[1])
            r_mann = button_distance(r_pos[0], r_pos[1], current_button[0], current_button[1])
            if l_mann < r_mann:
                l_pos = current_button
                answer += 'L'
            elif l_mann > r_mann:
                r_pos = current_button
                answer += 'R'
            else:
                if hand == 'right':
                    r_pos = current_button
                    answer += 'R'
                else:
                    l_pos = current_button
                    answer += 'L'

    return answer


if __name__ == '__main__':
    result = solution(numbers=[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], hand="right")
    print(result)
