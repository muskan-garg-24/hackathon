package java.hard;

import java.util.*;

public class MuhAndCubewalls{

    static int[] lps(long[] p){

        int m=p.length;

        int[] pi=new int[m];

        for(int i=1,j=0;i<m;i++){

            while(j>0 && p[i]!=p[j])
                j=pi[j-1];

            if(p[i]==p[j])
                j++;

            pi[i]=j;
        }

        return pi;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int w=sc.nextInt();

        long[] a=new long[n];
        long[] b=new long[w];

        for(int i=0;i<n;i++)
            a[i]=sc.nextLong();

        for(int i=0;i<w;i++)
            b[i]=sc.nextLong();

        if(w==1){
            System.out.println(n);
            sc.close();
            return;
        }

        long[] A=new long[n-1];
        long[] B=new long[w-1];

        for(int i=1;i<n;i++)
            A[i-1]=a[i]-a[i-1];

        for(int i=1;i<w;i++)
            B[i-1]=b[i]-b[i-1];

        int[] pi=lps(B);

        int ans=0;

        for(int i=0,j=0;i<A.length;i++){

            while(j>0 && A[i]!=B[j])
                j=pi[j-1];

            if(A[i]==B[j])
                j++;

            if(j==B.length){
                ans++;
                j=pi[j-1];
            }
        }

        System.out.println(ans);
        sc.close();
    }
}