#include<bits/stdc++.h>
using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,k,q;

    cin>>n>>k>>q;

    const int MAX=200000;

    vector<int> diff(
    MAX+2,0);

    for(int i=0;i<n;i++){

        int l,r;
        cin>>l>>r;

        diff[l]++;

        if(r+1<=MAX)
            diff[r+1]--;
    }

    vector<int>freq(
    MAX+2,0);

    for(int i=1;i<=MAX;i++)
        freq[i]=
        freq[i-1]
        +diff[i];

    vector<int>pref(
    MAX+2,0);

    for(int i=1;i<=MAX;i++){

        pref[i]=
        pref[i-1];

        if(freq[i]>=k)
            pref[i]++;
    }

    while(q--){

        int l,r;
        cin>>l>>r;

        cout<<
        pref[r]
        -pref[l-1]
        <<"\n";
    }
}