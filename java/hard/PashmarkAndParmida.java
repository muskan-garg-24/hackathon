package java.hard;

import java.util.*;

public class PashmarkAndParmida {

    static class BIT{
        int[] bit;
        int n;

        BIT(int n){
            this.n=n;
            bit=new int[n+2];
        }

        void update(int idx,int val){
            while(idx<=n){
                bit[idx]+=val;
                idx+=idx&-idx;
            }
        }

        int query(int idx){
            int sum=0;
            while(idx>0){
                sum+=bit[idx];
                idx-=idx&-idx;
            }
            return sum;
        }
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] a=new int[n+1];

        for(int i=1;i<=n;i++)
            a[i]=sc.nextInt();

        int[] left=new int[n+1];
        int[] right=new int[n+1];

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=1;i<=n;i++){
            int v=map.getOrDefault(a[i],0)+1;
            map.put(a[i],v);
            left[i]=v;
        }

        map.clear();

        for(int i=n;i>=1;i--){
            int v=map.getOrDefault(a[i],0)+1;
            map.put(a[i],v);
            right[i]=v;
        }

        BIT bit=new BIT(n);

        long ans=0;

        for(int i=n;i>=1;i--){

            ans+=bit.query(left[i]-1);

            bit.update(right[i],1);
        }

        System.out.println(ans);
        sc.close();
    }
}
