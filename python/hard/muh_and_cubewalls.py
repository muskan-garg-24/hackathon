n,w=map(int,input().split())

a=list(map(int,input().split()))
b=list(map(int,input().split()))

if w==1:
    print(n)
    exit()

A=[]
B=[]

for i in range(1,n):
    A.append(a[i]-a[i-1])

for i in range(1,w):
    B.append(b[i]-b[i-1])

pi=[0]*len(B)

j=0

for i in range(1,len(B)):

    while j>0 and B[i]!=B[j]:
        j=pi[j-1]

    if B[i]==B[j]:
        j+=1

    pi[i]=j

ans=0
j=0

for x in A:

    while j>0 and x!=B[j]:
        j=pi[j-1]

    if x==B[j]:
        j+=1

    if j==len(B):
        ans+=1
        j=pi[j-1]

print(ans)