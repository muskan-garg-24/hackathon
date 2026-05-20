#include <bits/stdc++.h>
using namespace std;

vector<int> lps(vector<long long>& p){
    int m=p.size();

    vector<int> pi(m,0);

    for(int i=1,j=0;i<m;i++){

        while(j>0 && p[i]!=p[j])
            j=pi[j-1];

        if(p[i]==p[j])
            j++;

        pi[i]=j;
    }

    return pi;
}

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,w;
    cin>>n>>w;

    vector<long long>a(n),b(w);

    for(auto &x:a) cin>>x;
    for(auto &x:b) cin>>x;

    if(w==1){
        cout<<n;
        return 0;
    }

    vector<long long> A,B;

    for(int i=1;i<n;i++)
        A.push_back(a[i]-a[i-1]);

    for(int i=1;i<w;i++)
        B.push_back(b[i]-b[i-1]);

    vector<int> pi=lps(B);

    int ans=0;

    for(int i=0,j=0;i<A.size();i++){

        while(j>0 && A[i]!=B[j])
            j=pi[j-1];

        if(A[i]==B[j])
            j++;

        if(j==B.size()){
            ans++;
            j=pi[j-1];
        }
    }

    cout<<ans;
}