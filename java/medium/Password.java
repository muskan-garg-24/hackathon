package java.medium;

import java.util.*;

public class Password {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        String s=sc.next();

        int n=s.length();

        int[] lps=new int[n];

        for(int i=1,j=0;i<n;i++){

            while(j>0 && s.charAt(i)!=s.charAt(j))
                j=lps[j-1];

            if(s.charAt(i)==s.charAt(j))
                j++;

            lps[i]=j;
        }

        boolean[] seen=new boolean[n+1];

        for(int i=0;i<n-1;i++)
            seen[lps[i]]=true;

        int len=lps[n-1];

        while(len>0){

            if(seen[len]){
                System.out.println(
                    s.substring(0,len)
                );
                sc.close();
                return;
            }

            len=lps[len-1];
        }

        System.out.println("Just a legend");

        sc.close();
    }
}