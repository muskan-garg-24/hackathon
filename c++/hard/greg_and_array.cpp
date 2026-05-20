#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,m,k;
    cin>>n>>m>>k;

    vector<long long>a(n+1);

    for(int i=1;i<=n;i++)
        cin>>a[i];

    vector<int>l(m+1),r(m+1),d(m+1);

    for(int i=1;i<=m;i++)
        cin>>l[i]>>r[i]>>d[i];

    vector<long long>op(m+3,0);

    for(int i=0;i<k;i++){
        int x,y;
        cin>>x>>y;

        op[x]++;
        op[y+1]--;
    }

    for(int i=1;i<=m;i++)
        op[i]+=op[i-1];

    vector<long long>diff(n+3,0);

    for(int i=1;i<=m;i++){

        long long val=1LL*d[i]*op[i];

        diff[l[i]]+=val;
        diff[r[i]+1]-=val;
    }

    for(int i=1;i<=n;i++){

        diff[i]+=diff[i-1];

        cout<<a[i]+diff[i]<<" ";
    }
}