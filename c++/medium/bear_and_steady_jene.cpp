#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;
int steadyGene(string gene) {

    int n=gene.size();

    unordered_map<char,int> cnt;

    for(char c:gene)
        cnt[c]++;

    int req=n/4;

    int left=0;
    int ans=n;

    for(int right=0;right<n;right++){

        cnt[gene[right]]--;

        while(
        cnt['A']<=req &&
        cnt['C']<=req &&
        cnt['G']<=req &&
        cnt['T']<=req){

            ans=min(
            ans,
            right-left+1);

            cnt[
            gene[left]
            ]++;

            left++;
        }
    }

    return ans;
}