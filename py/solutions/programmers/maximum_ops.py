from collections import deque
from itertools import permutations


def calc(lhs: str, rhs: str) -> str:
    current_op = lhs[-1]
    tail_op = rhs[-1]

    lhs = lhs[:-1]
    rhs = rhs[:-1]

    ret = 0
    if current_op == '*':
        ret = int(lhs) * int(rhs)
    elif current_op == '-':
        ret = int(lhs) - int(rhs)
    elif current_op == '+':
        ret = int(lhs) + int(rhs)
    return '{}{}'.format(ret, tail_op)


def solution(expression: str) -> int:
    answer = 0

    exp_args = []
    s = 0
    for idx, ch in enumerate(expression):
        if '0' <= ch <= '9':
            continue
        else:
            exp_args.append(expression[s:idx + 1])
            s = idx + 1
    else:
        exp_args.append('{}.'.format(expression[s:]))

    ops = ['-', '+', '*']
    for op in ops:
        if op not in expression:
            ops.remove(op)
    pri = permutations(ops)

    for op_orders in pri:
        exp_dq = deque(exp_args)
        for op in op_orders:
            is_new_arg = True
            while is_new_arg:
                is_new_arg = False
                args_num = len(exp_dq)
                cnt = 0
                while cnt < args_num:
                    lhs = exp_dq.popleft()
                    cnt += 1
                    if op == lhs[-1]:
                        rhs = exp_dq.popleft()
                        cnt += 1
                        exp_dq.appendleft(calc(lhs, rhs))
                        is_new_arg = True
                    else:
                        exp_dq.append(lhs)
        r = exp_dq.popleft()
        answer = max(answer, abs(int(r[:-1])))

    return answer


if __name__ == '__main__':
    result = solution(expression='100-200*300-500+20')
    print(result)
