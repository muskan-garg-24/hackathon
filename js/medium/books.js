'use strict';

const fs = require('fs');

const input = fs.readFileSync(0,'utf8')
                .trim()
                .split(/\s+/)
                .map(Number);

let p=0;

const n=input[p++];
const t=input[p++];

let a=[];

for(let i=0;i<n;i++){
    a.push(input[p++]);
}

let left=0;
let sum=0;
let ans=0;

for(let right=0;right<n;right++){

    sum+=a[right];

    while(sum>t){
        sum-=a[left];
        left++;
    }

    ans=Math.max(
        ans,
        right-left+1
    );
}

console.log(ans.toString());