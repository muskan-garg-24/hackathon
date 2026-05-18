'use strict';

const fs = require('fs');

const data = fs.readFileSync(0, 'utf8').split(/\s+/).map(Number);

let p = 0;
const n = data[p++];
const k = data[p++];

const freq = new Map();

let left = 0;
let bestL = 0;
let bestR = 0;

for(let right = 0; right < n; right++) {

    const x = data[p++];

    freq.set(x, (freq.get(x) || 0) + 1);

    while(freq.size > k) {

        const y = data[left + 2]; // array starts after n,k

        freq.set(y, freq.get(y) - 1);

        if(freq.get(y) === 0)
            freq.delete(y);

        left++;
    }

    if(right - left > bestR - bestL) {
        bestL = left;
        bestR = right;
    }
}

console.log((bestL + 1) + " " + (bestR + 1));
