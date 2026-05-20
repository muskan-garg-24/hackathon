s=input()

n=len(s)

lps=[0]*n

j=0

for i in range(1,n):

    while j>0 and s[i]!=s[j]:
        j=lps[j-1]

    if s[i]==s[j]:
        j+=1

    lps[i]=j

seen=[0]*(n+1)

for i in range(n-1):
    seen[lps[i]]=1

length=lps[n-1]

while length>0:

    if seen[length]:
        print(s[:length])
        exit()

    length=lps[length-1]

print("Just a legend")