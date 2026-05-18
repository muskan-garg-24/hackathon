// https://codeforces.com/problemset/problem/616/D?utm_source=chatgpt.com

package java.medium;
import java.io.*;
import java.util.*;

public class LongestKGoodSegment {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long sum = 0;
        int ans = 0;

        for(int right = 0; right < n; right++) {
            sum += a[right];

            while(sum > t) {
                sum -= a[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}