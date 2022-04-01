const User = class {
    #users;
    #accepted;

    constructor() {
        this.#users = [];
        this.#accepted = 0;
    }

    reportedMe(otherUser) {
        this.#users.push(otherUser);
    }

    isBlock() {
        return 2 <= this.#users.length;
    }

    alert() {
        this.#users.map(u => u.#happy());
    }

    #happy() {
        this.#accepted += 1;
    }

    [Symbol.toPrimitive](hint) {
        return this.#accepted;
    }
}

function solution(id_list, report, k) {
    const userMap = id_list.reduce((dict, id) => dict.set(id, new User()), new Map());

    report
        .map(r => r.split(' '))
        .map(([r, l]) => userMap.get(l).reportedMe(userMap.get(r)))

    id_list
        .filter(id => userMap.get(id).isBlock())
        .map(id => userMap.get(id).alert());

    return [...userMap.values()].map(user => +user);
}

const result = solution(
    ["muzi", "frodo", "apeach", "neo"],
    ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],
    2
);

console.log(result);
