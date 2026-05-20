#include<bits/stdc++.h>
using namespace std;

class BIT{
public:
    vector<int> bit;
    int n;

    BIT(int n){
        this->n=n;
        bit.assign(n+2,0);
    }

    void update(int idx,int val){
        while(idx<=n){
            bit[idx]+=val;
            idx+=idx&(-idx);
        }
    }

    int query(int idx){
        int sum=0;

        while(idx>0){
            sum+=bit[idx];
            idx-=idx&(-idx);
        }
        return sum;
    }
};

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin>>n;

    vector<int>a(n+1);

    for(int i=1;i<=n;i++)
        cin>>a[i];

    vector<int>left(n+1),right(n+1);

    unordered_map<int,int> mp;

    for(int i=1;i<=n;i++)
        left[i]=++mp[a[i]];

    mp.clear();

    for(int i=n;i>=1;i--)
        right[i]=++mp[a[i]];

    BIT bit(n);

    long long ans=0;

    for(int i=n;i>=1;i--){

        ans += bit.query(left[i]-1);

        bit.update(right[i],1);
    }

    cout<<ans;
}