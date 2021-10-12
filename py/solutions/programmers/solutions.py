class Solutions:

    def joystick(self, name: str) -> int:
        change_count = [min(ord(ch) - ord('A'), 1 + ord('Z') - ord(ch)) for ch in name]

        p = 0
        c = 0
        while True:
            c += change_count[p]
            change_count[p] = 0
            if sum(change_count) == 0:
                return c

            left, right = 1, 1
            while change_count[p + right] == 0:
                right += 1
            while change_count[p - left] == 0:
                left += 1

            c += min(left, right)
            p += -left if left < right else right

    def k_num_index(self, array: [int], commands: [[int]]) -> [int]:
        answer = []
        for command in commands:
            i, j, k = command[0] - 1, command[1], command[2] - 1
            sub_arr = array[i:j]
            sub_arr.sort()
            answer.append(sub_arr[k])
        return answer

    def h_index(self, citations: [int]) -> int:
        citations.sort()
        ref = len(citations)
        for i, v in enumerate(citations):
            if v >= ref - i:
                return ref - i
