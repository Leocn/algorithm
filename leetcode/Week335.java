package com.example.demo.leetcode;

import java.util.*;

public class Week335 {
    public static void main(String[] args) {
        System.out.println(findValidSplit(new int[]{4,7,8,15,3,5}));
    }
    public int passThePillow(int n, int time) {
        int ans = 1, re = 0;
        while (time>0){
            if(re == 0){
                ans++;
            }else{
                ans--;
            }
            if(ans == n){
                re = 1;
            }
            if(ans == 1){
                re = 0;
            }
            time--;
        }
        return ans;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(b,a));
        pq.add((long) root.val);
        Deque<TreeNode>  dq = new ArrayDeque<>();
        dq.add(root);
        while (dq.size()>0){
            int s = dq.size();
            long sum = 0;
            while (s-->0){
                TreeNode node = dq.poll();
                if(node.left!=null){
                    dq.add(node.left);
                }
                if(node.right!=null){
                    dq.add(node.right);
                }
                sum += node.val;
            }
            System.out.println(sum);
            pq.add(sum);
        }
        long ans =0;
        while (k>0 && pq.size()>0){

            ans = pq.poll();
            k--;
        }

        return ans;
    }
    static final List<Integer> PRIMES = getPrimesLe(1000001);
    static final  Map<Integer, Integer> map = new HashMap<>();
    public static int findValidSplit(int[] nums) {
        int n = nums.length, m = PRIMES.size();
        for (int i = 0; i < m; i++) {
            map.put(PRIMES.get(i), i);
        }
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            List<Integer> p = getPrimeFactors(nums[i]);
            for (Integer integer : p) {
                cnt[map.get(integer)]++;
            }
        }
        Map<Integer, Integer> mm = new HashMap<>();




        //int[] now = new int[m];
        for (int i = 0; i < n - 1; i++) {
            List<Integer> p = getPrimeFactors(nums[i]);
            for (Integer integer : p) {
                //now[map.get(integer)]++;
                int c = mm.getOrDefault(map.get(integer), 0);
                c++;
                mm.put(map.get(integer), c);
                if(c==cnt[map.get(integer)]){
                    mm.remove(map.get(integer));
                }
            }
            if(mm.size()==0){
                return i;
            }

        }
        return -1;
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


    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int MOD = (int)1E9+7;
        long[][] dp = new long[n+1][target+1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int cnt = types[i][0], v = types[i][1];
            if (target + 1 >= 0) System.arraycopy(dp[i], 0, dp[i + 1], 0, target + 1);
            out:for (int j = 0; j <=target ; j++) {
                for (int k = 1; k <= cnt; k++)
                {
                    if(j+k*v>target){
                        continue out;
                    }
                    dp[i+1][j+k*v] += dp[i][j];
                }
            }
        }
        return(int) (dp[n][target]%MOD);
    }

}
