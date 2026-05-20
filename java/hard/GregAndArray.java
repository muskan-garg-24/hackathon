package java.hard;

import java.util.*;

public class GregAndArray {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        long[] a=new long[n+1];

        for(int i=1;i<=n;i++)
            a[i]=sc.nextLong();

        int[] l=new int[m+1];
        int[] r=new int[m+1];
        int[] d=new int[m+1];

        for(int i=1;i<=m;i++){

            l[i]=sc.nextInt();
            r[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }

        long[] op=new long[m+3];

        for(int i=0;i<k;i++){

            int x=sc.nextInt();
            int y=sc.nextInt();

            op[x]++;
            op[y+1]--;
        }

        for(int i=1;i<=m;i++)
            op[i]+=op[i-1];

        long[] diff=new long[n+3];

        for(int i=1;i<=m;i++){

            long val=1L*d[i]*op[i];

            diff[l[i]]+=val;
            diff[r[i]+1]-=val;
        }

        for(int i=1;i<=n;i++){

            diff[i]+=diff[i-1];

            System.out.print(a[i]+diff[i]+" ");
        }
        sc.close();
    }
}