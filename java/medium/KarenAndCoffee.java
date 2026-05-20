package java.medium;

import java.io.*;
import java.util.*;

public class KarenAndCoffee {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());

        int k=Integer.parseInt(st.nextToken());

        int q=Integer.parseInt(st.nextToken());

        int MAX=200000;

        int[] diff=new int[MAX+2];

        for(int i=0;i<n;i++){

            st=new StringTokenizer(br.readLine());

            int l=Integer.parseInt(st.nextToken());

            int r=Integer.parseInt(st.nextToken());

            diff[l]++;

            if(r+1<=MAX)
                diff[r+1]--;
        }

        int[] freq=new int[MAX+2];

        for(int i=1;i<=MAX;i++)
            freq[i]=freq[i-1]+diff[i];

        int[] pref=new int[MAX+2];

        for(int i=1;i<=MAX;i++){

            pref[i]=pref[i-1];

            if(freq[i]>=k)
                pref[i]++;
        }

        StringBuilder sb=new StringBuilder();

        while(q-->0){

            st=new StringTokenizer(br.readLine());

            int l=Integer.parseInt(st.nextToken());

            int r=Integer.parseInt(st.nextToken());

            sb.append(pref[r]-pref[l-1]).append("\n");
        }

        System.out.print(sb);
    }
}