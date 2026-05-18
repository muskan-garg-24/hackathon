// https://www.hackerrank.com/challenges/bear-and-steady-gene/problem

package java.medium;

import java.util.*;

class BearAndSteadyJene {

    public static int steadyGene(String gene){

        int n=gene.length();

        HashMap<Character,Integer> map=
                new HashMap<>();

        for(char c:gene.toCharArray())
            map.put(c,
            map.getOrDefault(c,0)+1);

        int req=n/4;

        int left=0;

        int ans=n;

        for(int right=0;right<n;right++){

            char ch=gene.charAt(right);

            map.put(
            ch,
            map.get(ch)-1);

            while(
                left<n &&
                map.getOrDefault('A',0)<=req &&
                map.getOrDefault('C',0)<=req &&
                map.getOrDefault('G',0)<=req &&
                map.getOrDefault('T',0)<=req
            ){

                ans=Math.min(
                ans,
                right-left+1);

                char c=
                gene.charAt(left);

                map.put(
                c,
                map.get(c)+1);

                left++;
            }
        }

        return ans;
    }
}