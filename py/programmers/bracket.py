import sys


def correct_balance(s: str) -> bool:
    c = 0
    for ch in s:
        if ch == ')':
            c -= 1
        else:
            c += 1
    return c == 0


def correct_bracket(s: str) -> bool:
    brackets = []
    for ch in s:
        if ch == ')':
            if len(brackets) == 0 or brackets.pop() != '(':
                return False
        else:
            brackets.append(ch)
    return True


def solution(s: str) -> str:
    answer = ''

    # 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if len(s) == 0 or correct_bracket(s):
        return s

    # 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    u = ''
    v = ''
    for e in range(2, len(s) + 1, 2):
        if correct_balance(s[0:e]):
            u = s[0:e]
            v = s[e:len(s)]
            break

    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    if correct_bracket(u):
        # 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        answer += u + solution(v)
    else:
        '''
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
            4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
            4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
            4-3. ')'를 다시 붙입니다. 
        '''
        answer += '(' + solution(v) + ')'

        '''
        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
        4-5. 생성된 문자열을 반환합니다.
        '''
        for ch in u[1:-1]:
            if ch == '(':
                answer += ')'
            else:
                answer += '('

    return answer


if __name__ == '__main__':
    sys.setrecursionlimit(100005)
    result = solution(s='()))((()')
    print(result)
