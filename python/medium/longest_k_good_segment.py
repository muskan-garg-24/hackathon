n,k=map(int,input().split())

arr=list(map(int,input().split()))

freq={}

left=0

L=0
R=0

for right in range(n):

    freq[arr[right]]=freq.get(
        arr[right],0)+1

    while len(freq)>k:

        freq[arr[left]]-=1

        if freq[arr[left]]==0:
            del freq[arr[left]]

        left+=1

    if right-left>R-L:

        L=left
        R=right

print(L+1,R+1)