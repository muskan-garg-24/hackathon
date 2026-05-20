n=int(input())

s=input()

total=len(set(s))

freq={}

left=0

ans=n

for right in range(n):

    ch=s[right]

    freq[ch]=freq.get(
    ch,0)+1

    while len(freq)==total:

        ans=min(
        ans,
        right-left+1)

        c=s[left]

        freq[c]-=1

        if freq[c]==0:
            del freq[c]

        left+=1

print(ans)