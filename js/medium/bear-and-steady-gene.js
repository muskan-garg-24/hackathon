function steadyGene(gene){

    let n=gene.length;

    let cnt=new Map();

    for(let c of gene)
        cnt.set(
        c,
        (cnt.get(c)||0)+1
        );

    let req=n/4;

    let left=0;

    let ans=n;

    for(let right=0;
        right<n;
        right++){

        let ch=gene[right];

        cnt.set(
        ch,
        cnt.get(ch)-1
        );

        while(
        (cnt.get('A')||0)<=req &&
        (cnt.get('C')||0)<=req &&
        (cnt.get('G')||0)<=req &&
        (cnt.get('T')||0)<=req
        ){

            ans=Math.min(
            ans,
            right-left+1
            );

            cnt.set(
            gene[left],
            cnt.get(
            gene[left]
            )+1
            );

            left++;
        }
    }

    return ans;
}