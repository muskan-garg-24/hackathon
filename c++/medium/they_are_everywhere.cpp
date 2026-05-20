#include<bits/stdc++.h>
using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin>>n;

    string s;
    cin>>s;

    set<char> st(
    s.begin(),
    s.end());

    int total=st.size();

    unordered_map<char,int> freq;

    int left=0;
    int ans=n;

    for(int right=0;
        right<n;
        right++){

        freq[s[right]]++;

        while(
        freq.size()==total){

            ans=min(
            ans,
            right-left+1);

            freq[
            s[left]
            ]--;

            if(
            freq[
            s[left]
            ]==0)

            freq.erase(
            s[left]);

            left++;
        }
    }

    cout<<ans;
}