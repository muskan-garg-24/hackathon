s = input().strip()
good = input().strip()
k = int(input())

n = len(s)

bad = [c == '0' for c in good]

MOD1 = 1000000007
MOD2 = 1000000009
BASE1 = 911382323
BASE2 = 972663749

seen = set()

for i in range(n):

    cnt = 0
    h1 = 0
    h2 = 0

    for j in range(i, n):

        x = ord(s[j]) - 97

        if bad[x]:
            cnt += 1

        if cnt > k:
            break

        val = x + 1

        h1 = (h1 * BASE1 + val) % MOD1
        h2 = (h2 * BASE2 + val) % MOD2

        # pack two hashes into one int
        seen.add((h1 << 32) | h2)

print(len(seen))