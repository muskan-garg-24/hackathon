#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s, good;
    cin >> s >> good;

    int k;
    cin >> k;

    int n = s.size();

    vector<int> bad(26);

    for(int i = 0; i < 26; i++)
        bad[i] = (good[i] == '0');

    unordered_set<unsigned long long> st;

    const unsigned long long BASE = 911382323;

    for(int i = 0; i < n; i++) {

        int cnt = 0;
        unsigned long long h = 0;

        for(int j = i; j < n; j++) {

            int x = s[j] - 'a';

            if(bad[x])
                cnt++;

            if(cnt > k)
                break;

            h = h * BASE + (x + 1);

            st.insert(h);
        }
    }

    cout << st.size() << "\n";

    return 0;
}