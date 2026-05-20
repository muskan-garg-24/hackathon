const fs=require("fs");

const input=fs.readFileSync(0,"utf8").trim().split(/\s+/);

let p=0;

let n=+input[p++];

let a=[];

for(let i=0;i<n;i++)
    a.push(+input[p++]);

let left=Array(n+1).fill(0);
let right=Array(n+1).fill(0);

let mp=new Map();

for(let i=1;i<=n;i++){

    let x=a[i-1];

    let v=(mp.get(x)||0)+1;

    mp.set(x,v);

    left[i]=v;
}

mp.clear();

for(let i=n;i>=1;i--){

    let x=a[i-1];

    let v=(mp.get(x)||0)+1;

    mp.set(x,v);

    right[i]=v;
}

let bit=Array(n+2).fill(0);

function update(i,val){

    while(i<=n){

        bit[i]+=val;

        i+=i&-i;
    }
}

function query(i){

    let s=0;

    while(i>0){

        s+=bit[i];

        i-=i&-i;
    }

    return s;
}

let ans=0;

for(let i=n;i>=1;i--){

    ans+=query(left[i]-1);

    update(right[i],1);
}

console.log(ans.toString());