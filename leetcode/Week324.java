package com.example.demo.leetcode;

import java.util.*;

public class Week324 {
    public int similarPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            char[] cs = words[i].toCharArray();
            int[] cnt = new int[26];
            for (char c: cs){
                cnt[c-'a']++;
            }

            out: for (int j = i+1; j < words.length; j++) {
                int[] in = new int[26];

                char[] cs1 = words[j].toCharArray();
                for (char c: cs1){
                    in[c-'a']++;
                }
                for (int k = 0; k < 26; k++) {
                    if((in[k]==0 && cnt[k]!=0) ||(in[k]!=0 && cnt[k]==0) ){
                        continue out;
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    static final List<Integer> PRIMES = getPrimesLe(10000);
    public static int smallestValue(int n) {
        int ans = 0;
        while (true){
            List<Integer> list =  getPrimeFactors(n);
            int cnt = 0;
            for(int t: list){
                while (n%t==0){
                    cnt++;
                    ans+=t;
                    n /= t;
                }
            }
            n = ans;
            if(cnt ==1){
                break;
            }
        }
        return n;
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

    /**
     ** 获取质数因子
     * */
    public static List<Integer> getPrimeFactors(int k) {
        List<Integer> ans = new ArrayList<>();
        int r = (int) Math.sqrt(k) + 1;
        for (int p : PRIMES) {
            if (p > r) {
                break;
            }
            int exp = 0;
            while (k % p == 0) {
                exp++;
                k /= p;
            }
            if (exp > 0) {
                ans.add(p);
            }
        }
        if (k != 1) {
            ans.add(k);
        }
        return ans;
    }
    Map<Integer, Integer> map ;
    public boolean isPossible(int n, List<List<Integer>> edges) {
        map = new HashMap<>();
        ArrayList[] arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            arr[a].add(b);
            arr[b].add(a);

        }
        int[] cnt = new int[n+1];
        int sum = 0;
        List<Integer> tss = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            cnt[i] = arr[i].size();
            if(cnt[i]%2!=0){
                sum++;
                tss.add(i);
            }

        }
        if(sum>4){
            return false;
        }
        if(sum==1){
            return false;
        }
        if(sum == 0){
            return true;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] vis = new boolean[n+1];
        for (int i = 1; i <=n; i++) {
            if(vis[i] || arr[i].size()==0){
                continue;
            }
            map.put(i,i);
            dq.add(i);
            vis[i] = true;
            while (dq.size()>0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                for(int t:list){
                    if(vis[t]){
                        continue;
                    }
                    vis[t] = true;
                    dq.add(t);
                    map.put(t,i);
                }
            }
        }
        if(sum==4){
            Set<Integer> set = new HashSet<>();
            for(int ss : tss){
                set.add(map.get(ss));
            }
            if(set.size()>=3){
                return false;
            }
            List<Integer>  aaa = new ArrayList<>();
            for(int gg: tss){
                List<Integer> list = arr[gg];
                int cc = 0;
                Set<Integer> set1= new HashSet<>(tss);
                for(int t: list){
                    if(set1.contains(t) ){
                        cc++;
                    }
                }
                aaa.add(cc);

            }
            Collections.sort(aaa);
            if(aaa.get(3)== aaa.get(1) &&  aaa.get(1)== aaa.get(2) && aaa.get(1) ==2 &&  aaa.get(0)!=2){
                return false;
            }
            if(aaa.get(3)==3){
                return false;
            }
            return true;
        }
        if(sum==2 ){
            if( arr[tss.get(0)].size()==n-1 || arr[tss.get(1)].size()==n-1){
                return false;
            }

            return true;
        }
        return true;

    }


    public int[] cycleLengthQueries(int n, int[][] queries) {
        int t = queries.length;
        int[] ans = new int[t];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x = q[0], y = q[1];
            List<Integer> a= new ArrayList<>();
            while (x>1){
                a.add(x/2);
                x/=2;
            }
            a.add(1);
            List<Integer> b= new ArrayList<>();
            while (y>1){
                b.add(y/2);
                y/=2;
            }
            b.add(1);

            int st = a.size()-1;
            int end = b.size()-1;
            while (st>=0 && end>=0 && Objects.equals(a.get(st), b.get(end))){
                st--;
                end--;
            }
            ans[i] = a.size()-st + b.size()-end;



        }
        return ans;
    }


}
