const fs=require("fs");

const input=fs.readFileSync(0,"utf8").trim().split(/\s+/);

let p=0;

const n=+input[p++];
const m=+input[p++];
const k=+input[p++];

const a=Array(n+1).fill(0);

for(let i=1;i<=n;i++)
a[i]=+input[p++];

const l=Array(m+1);
const r=Array(m+1);
const d=Array(m+1);

for(let i=1;i<=m;i++){

    l[i]=+input[p++];
    r[i]=+input[p++];
    d[i]=+input[p++];
}

const op=Array(m+3).fill(0);

for(let i=0;i<k;i++){

    let x=+input[p++];
    let y=+input[p++];

    op[x]++;
    op[y+1]--;
}

for(let i=1;i<=m;i++)
op[i]+=op[i-1];

const diff=Array(n+3).fill(0);

for(let i=1;i<=m;i++){

    let val=d[i]*op[i];

    diff[l[i]]+=val;
    diff[r[i]+1]-=val;
}

for(let i=1;i<=n;i++)
diff[i]+=diff[i-1];

let ans=[];

for(let i=1;i<=n;i++)
ans.push(a[i]+diff[i]);

console.log(ans.join(" "));