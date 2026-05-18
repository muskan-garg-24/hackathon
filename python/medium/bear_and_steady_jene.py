def steadyGene(gene):

    n=len(gene)

    cnt={}

    for c in gene:
        cnt[c]=cnt.get(c,0)+1

    req=n//4

    left=0

    ans=n

    for right in range(n):

        cnt[gene[right]]-=1

        while(
        cnt.get('A',0)<=req and
        cnt.get('C',0)<=req and
        cnt.get('G',0)<=req and
        cnt.get('T',0)<=req
        ):

            ans=min(
            ans,
            right-left+1)

            cnt[
            gene[left]
            ]+=1

            left+=1

    return ans