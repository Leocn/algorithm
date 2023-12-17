package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Week372 {
    public static void main(String[] args) {

    }
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = 101;
        n = Math.min(n, s1.length());
        n = Math.min(n, s2.length());
        n = Math.min(n, s3.length());
        for (int i = n-1; i >=0 ; i--) {
            if(s1.substring(0,i+1).equals(s2.substring(0,i+1)) && (s2.substring(0,i+1).equals(s3.substring(0,i+1))) ){
                return s1.length() + s2.length() + s3.length() - (i+1)*3;
            }
        }
        return -1;
    }

    public long minimumSteps(String s) {
        long sum = 0, ans = 0;
        char[] cs = s.toCharArray();
        for(char c: cs){
            if(c=='1'){
                sum++;
            }else {
                ans += sum;
            }
        }
        return ans;

    }


    public int maximumXorProduct(long a, long b, int n) {
        if(a<b){
            long tem = a;
            b = a;
            a = tem;

        }
        long mask = (1L<<n) - 1;
        long ansA = a & (~mask), aR = a & (mask);
        long ansB = b & (~mask), bR = b & (mask);
        long r = aR ^ bR;
        long one = mask ^ r;
        ansA |= one;
        ansB |= one;

        if(r>0 && ansA == ansB){
            long highBit = 1L << (63 - Long.numberOfLeadingZeros(r));
            ansA |= highBit;
            r ^= highBit;

        }
        ansB |= r;
        final long MOD = 1_000_000_007;
        return (int) (ansA % MOD * (ansB % MOD) % MOD);

    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        ArrayList<int[]>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);
        for (int i = 0; i < q; i++) {
            int[] qu = queries[i];
            int a = qu[0], b = qu[1];
            if(a>b){
                int tem = b;
                b = a;
                a = tem;
            }
            if(a == b || heights[a]<heights[b]){
                ans[i] = b;
            }else {
                arr[b].add(new int[]{heights[a], i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for (int i = 0; i < n; i++) {
            while (pq.size()>0 && pq.peek()[0]<heights[i]){
                ans[pq.poll()[1]] = i;
            }
            pq.addAll(arr[i]);
        }
        return ans;

    }

}
