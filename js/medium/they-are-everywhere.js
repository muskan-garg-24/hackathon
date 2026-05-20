'use strict';

const fs=require('fs');

const input=
fs.readFileSync(
0,'utf8')
.trim()
.split('\n');

const n=
parseInt(input[0]);

const s=
input[1].trim();

const total=
new Set(s).size;

let freq=
new Map();

let left=0;

let ans=n;

for(let right=0;
    right<n;
    right++){

    let ch=
    s[right];

    freq.set(
    ch,
    (freq.get(ch)||0)+1
    );

    while(
    freq.size===total
    ){

        ans=Math.min(
        ans,
        right-left+1
        );

        let c=
        s[left];

        freq.set(
        c,
        freq.get(c)-1
        );

        if(
        freq.get(c)
        ===0)

        freq.delete(c);

        left++;
    }
}

console.log(ans);