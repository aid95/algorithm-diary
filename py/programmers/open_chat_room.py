import collections


def solution(record: [str]) -> [str]:
    history = collections.defaultdict()
    seq = []
    for v in record:
        ss = v.split()

        if ss[0] == 'Change':
            history[ss[1]] = ss[2]
            continue

        if ss[0] == 'Leave':
            seq.append((ss[0], ss[1]))
            continue

        history[ss[1]] = ss[2]
        seq.append((ss[0], ss[1]))

    def get_welcome_msg(o: str, u: str):
        if o == 'Enter':
            return f'{history[u]}님이 들어왔습니다.'
        return f'{history[u]}님이 나갔습니다.'

    return [get_welcome_msg(c_opr, c_uid) for (c_opr, c_uid) in seq]


if __name__ == '__main__':
    result = solution(record=["Enter uid1234 Muzi",
                              "Enter uid4567 Prodo",
                              "Leave uid1234",
                              "Enter uid1234 Prodo",
                              "Change uid4567 Ryan"])
    print(result)
