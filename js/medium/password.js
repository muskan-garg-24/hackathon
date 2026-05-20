const fs=require("fs");

const s=fs.readFileSync(0,"utf8").trim();

const n=s.length;

let lps=Array(n).fill(0);

for(let i=1,j=0;i<n;i++){

    while(j>0 && s[i]!==s[j])
        j=lps[j-1];

    if(s[i]===s[j])
        j++;

    lps[i]=j;
}

let seen=Array(n+1).fill(false);

for(let i=0;i<n-1;i++)
    seen[lps[i]]=true;

let len=lps[n-1];

while(len>0){

    if(seen[len]){
        console.log(s.substring(0,len));
        process.exit();
    }

    len=lps[len-1];
}

console.log("Just a legend");