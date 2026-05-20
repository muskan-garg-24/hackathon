'use strict';

const fs=require('fs');

const input=fs.readFileSync(0,'utf8').trim().split(/\s+/).map(Number);

let p=0;

const n=input[p++];
const k=input[p++];
const q=input[p++];

const MAX=200000;

let diff=new Array(MAX+2).fill(0);

for(let i=0;i<n;i++){

    let l=input[p++];
    let r=input[p++];

    diff[l]++;

    if(r+1<=MAX)
        diff[r+1]--;
}

let freq=new Array(MAX+2).fill(0);

for(let i=1;i<=MAX;i++)
    freq[i]=freq[i-1]+diff[i];

let pref=new Array(MAX+2).fill(0);

for(let i=1;i<=MAX;i++){

    pref[i]=pref[i-1];

    if(freq[i]>=k)
        pref[i]++;
}

let out=[];

for(let i=0;i<q;i++){

    let l=input[p++];
    let r=input[p++];

    out.push(pref[r]-pref[l-1]);
}

console.log(out.join("\n"));