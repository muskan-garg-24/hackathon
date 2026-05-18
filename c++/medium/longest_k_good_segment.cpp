#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,k;
    cin >> n >> k;

    vector<int> a(n);
    for(int &x : a) cin >> x;

    unordered_map<int,int> freq;

    int left=0;
    int bestL=0,bestR=0;

    for(int right=0; right<n; right++){

        freq[a[right]]++;

        while(freq.size()>k){

            freq[a[left]]--;

            if(freq[a[left]]==0)
                freq.erase(a[left]);

            left++;
        }

        if(right-left > bestR-bestL){
            bestL=left;
            bestR=right;
        }
    }

    cout << bestL+1 << " " << bestR+1;

    return 0;
}