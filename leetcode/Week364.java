package com.example.demo.leetcode;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Week364 {
    public String maximumOddBinaryNumber(String s) {
        char[] cs = s.toCharArray();
        int x = 0, y = 0;
        for(char c: cs){
            if(c=='0'){
                x++;
            }else {
                y++;
            }
        }
        String ans = "1".repeat(y-1);
        ans += "0".repeat(x);
        ans +="1";
        return  ans;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        long ans = 0;
//        int n = maxHeights.size();
//        long[] l = new long[n];
//        long min = maxHeights.get(0);
//        l[0] = min;
//        for (int i = 1; i <n ; i++) {
//            l[i] = Math.min(l[i-1], maxHeights.get(i));
//        }
//
//        min = maxHeights.get(n-1);
//        long[] r = new long[n];
//        r[n-1] = min;
//        for (int i = n-2; i >=0 ; i--) {
//            r[i] = Math.min(r[i+1], maxHeights.get(i));
//        }
//
//        long[] sumL = new long[n+1];
//        for (int i = 0; i < n; i++) {
//            sumL[i+1] = sumL[i] + l[i];
//        }
//
//        long[] sumR = new long[n+1];
//        for (int i = n-1; i >=0 ; i--) {
//            sumR[i] = sumR[i+1] + r[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            long sum = sumL[n]- sumL[i] + sumR[0] - sumR[i];
//            System.out.println(i + " " + sum);
//            ans = Math.max(sum, ans);
//        }
//        return ans;
        int n = maxHeights.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeights.get(i);
        }
        long[] left = new long[n];
        long[] right = new long[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = (long) arr[i] * (i + 1);
            } else {
                left[i] = (long) arr[i] * (i - stack.peek()) + left[stack.peek()];
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1;i >= 0;i--) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = (long) arr[i] * (n - i);
            } else {
                right[i] = (long) arr[i] * (stack.peek() - i) + right[stack.peek()];
            }
            stack.push(i);
        }
        int idx = 0;
        long max = 0L;
        for(int i = 0;i < n;i++) {
            long l = left[i] + right[i] - arr[i];
            if(max < l) {
                max = l;
                idx = i;
            }
        }
        long[] ans = new long[n];
        ans[idx] = arr[idx];
        long prev = arr[idx];
        for(int i = idx - 1;i >= 0;i--) {
            if(arr[i] < prev) {
                prev = arr[i];
            }
            ans[i] = prev;
        }
        prev = arr[idx];
        for(int i = idx + 1;i < n;i++) {
            if(arr[i] < prev) {
                prev = arr[i];
            }
            ans[i] = prev;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += ans[i];
        }
        return res;



    }

    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }

    static Set<Integer> PRIMES;
    static {
        PRIMES = new HashSet<>(getPrimesLe((int)1e5));
    }
    static ArrayList<Integer>[] g;
    int[] count;
    public long countPaths(int n, int[][] edges) {
        long ans = 0;
        g = new ArrayList[n+1];
        count = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int i = 1; i <=n ; i++) {
            if(!PRIMES.contains(i)) continue;
            List<Integer> list = g[i];
            int sum = 0;
            for(int c: list){
                if(PRIMES.contains(c)) continue;
                List<Integer> nodes = new ArrayList<>();
                if(count[c]==0){
                    count[c] = dfs(c,i,nodes);
                    for(int u: nodes){
                        count[u] = count[c];
                    }
                }
                int cnt = count[c];
                ans += (long)cnt*sum;
                ans += cnt;
                sum += cnt;
            }
        }
        return ans;
    }

    private int dfs(int c, int p, List<Integer> nodes){
        List<Integer> list = g[c];
        nodes.add(c);
        int res = 1;
        for(int nx: list){
            if(nx == p) continue;
            if(PRIMES.contains(nx)) continue;
            res += dfs(nx, c,nodes);
        }
        return res;
    }


    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int loc = 2;
        for (int p: PRIMES) {
            while (loc<=100000 && PRIMES.contains(loc)) {
                loc++;
            }
            list.add(new int[]{loc, 1});
            list.add(new int[]{loc, p});
            loc++;
        }
        while (loc<=100000){
            if(!PRIMES.contains(loc)) {
                list.add(new int[]{loc,1});
            }
            loc++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int[] i : list){
            sb.append(Arrays.toString(i)).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb);
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("C:\\Users\\J1J\\Desktop\\新建文本文档.txt");
            BufferedOutputStream b = new BufferedOutputStream(f);
            b.write(sb.toString().getBytes());
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
