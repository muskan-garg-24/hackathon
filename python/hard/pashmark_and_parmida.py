import sys

data = list(map(int, sys.stdin.buffer.read().split()))
n = data[0]
a = data[1:]

L = [0] * n
R = [0] * n

cnt = {}

for i in range(n):
    x = a[i]
    cnt[x] = cnt.get(x, 0) + 1
    L[i] = cnt[x]

cnt.clear()

for i in range(n - 1, -1, -1):
    x = a[i]
    cnt[x] = cnt.get(x, 0) + 1
    R[i] = cnt[x]

bit = [0] * (n + 2)

# preload all R values
for x in R:
    while x <= n:
        bit[x] += 1
        x += x & -x

ans = 0

for i in range(n):

    # remove current R[i]
    x = R[i]
    while x <= n:
        bit[x] -= 1
        x += x & -x

    # query count of R[j] < L[i]
    x = L[i] - 1
    s = 0

    while x:
        s += bit[x]
        x -= x & -x

    ans += s

print(ans)