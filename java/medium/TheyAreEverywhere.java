// https://codeforces.com/problemset/problem/701/C

package java.medium;

import java.io.*;
import java.util.*;

public class TheyAreEverywhere {

    public static void main(String[] args)throws Exception {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        HashSet<Character> set = new HashSet<>();

        for(char c:s.toCharArray())
            set.add(c);

        int total=set.size();

        HashMap<Character,Integer> map = new HashMap<>();

        int left=0;
        int ans=n;

        for(int right=0;right<n;right++){

            char ch=s.charAt(right);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()==total){

                ans=Math.min(ans,right-left+1);

                char c = s.charAt(left);

                map.put(c,map.get(c)-1);

                if(map.get(c)==0)
                    map.remove(c);

                left++;
            }
        }

        System.out.println(ans);
    }
}