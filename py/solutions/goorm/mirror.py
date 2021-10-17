import sys

rl = sys.stdin.readline

mirror_map = {
    'b': 'd',
    'd': 'b',
    'i': 'i',
    'l': 'l',
    'm': 'm',
    'n': 'n',
    'o': 'o',
    'p': 'q',
    'q': 'p',
    's': 'z',
    'z': 's',
    'u': 'u',
    'v': 'v',
    'w': 'w',
    'x': 'x',
}


def check_mirror_word(s: str) -> bool:
    left, right = 0, len(s) - 1
    while left <= right:
        if s[left] in mirror_map.keys():
            if mirror_map[s[left]] != s[right]:
                return False
        else:
            return False
        left += 1
        right -= 1
    return True


def solution(w: list[str]) -> list[bool]:
    result = []
    for a in w:
        result.append(check_mirror_word(a))
    return result


if __name__ == '__main__':
    t = int(rl().rstrip())
    words = []
    for _ in range(t):
        words.append(rl().rstrip())
    answer = solution(words)
    print('\n'.join(['Mirror' if x else 'Normal' for x in answer]))
