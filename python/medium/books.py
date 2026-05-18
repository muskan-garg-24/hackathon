import sys

input = sys.stdin.readline

n, t = map(int, input().split())

a = list(map(int, input().split()))

left = 0
currSum = 0
ans = 0

for right in range(n):

    currSum += a[right]

    while currSum > t:
        currSum -= a[left]
        left += 1

    ans = max(ans, right - left + 1)

print(ans)