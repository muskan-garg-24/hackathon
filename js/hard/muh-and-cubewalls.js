const fs=require("fs");

const input=fs.readFileSync(0,"utf8").trim().split(/\s+/).map(Number);

let p=0;

let n=input[p++];
let w=input[p++];

let a=[];
let b=[];

for(let i=0;i<n;i++)
a.push(input[p++]);

for(let i=0;i<w;i++)
b.push(input[p++]);

if(w===1){
    console.log(n);
    process.exit();
}

let A=[];
let B=[];

for(let i=1;i<n;i++)
A.push(a[i]-a[i-1]);

for(let i=1;i<w;i++)
B.push(b[i]-b[i-1]);

let pi=Array(B.length).fill(0);

for(let i=1,j=0;i<B.length;i++){

    while(j>0 && B[i]!==B[j])
        j=pi[j-1];

    if(B[i]===B[j])
        j++;

    pi[i]=j;
}

let ans=0;

for(let i=0,j=0;i<A.length;i++){

    while(j>0 && A[i]!==B[j])
        j=pi[j-1];

    if(A[i]===B[j])
        j++;

    if(j===B.length){
        ans++;
        j=pi[j-1];
    }
}

console.log(ans);