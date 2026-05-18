#include <bits/stdc++.h>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,t;
    cin>>n>>t;

    vector<int>a(n);

    for(int &x:a)
        cin>>x;

    int left=0;
    long long sum=0;
    int ans=0;

    for(int right=0;right<n;right++){

        sum+=a[right];

        while(sum>t){
            sum-=a[left];
            left++;
        }

        ans=max(ans,right-left+1);
    }

    cout<<ans;

    return 0;
}