n,m,k=map(int,input().split())

a=[0]+list(map(int,input().split()))

l=[0]*(m+1)
r=[0]*(m+1)
d=[0]*(m+1)

for i in range(1,m+1):
    l[i],r[i],d[i]=map(int,input().split())

op=[0]*(m+3)

for _ in range(k):
    x,y=map(int,input().split())

    op[x]+=1
    op[y+1]-=1

for i in range(1,m+1):
    op[i]+=op[i-1]

diff=[0]*(n+3)

for i in range(1,m+1):

    val=d[i]*op[i]

    diff[l[i]]+=val
    diff[r[i]+1]-=val

for i in range(1,n+1):

    diff[i]+=diff[i-1]

    print(a[i]+diff[i],end=' ')