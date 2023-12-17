package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Week358 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if(x==0) return 0;
        int left = 0;
        int n = nums.size();
        Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        TreeSet<Integer> map = new TreeSet<>();
        for(int i=0; i<n;i++){


            if(i-x>=left){
                int num = nums.get(left++);
                map.add(num);

                int now = nums.get(i);
                max = map.ceiling(now);
                min = map.lower(now);
                if(min!=null){
                    ans = Math.min(ans, Math.abs(now -min));
                }
                if(max!=null){
                    ans = Math.min(ans, Math.abs(max -now));
                }

            }
        }
        return ans;
    }


    static BigInteger mod =  new BigInteger(String.valueOf((int)1E9+7));

    public int maximumScore(List<Integer> nums, int k) {
        int n  = nums.size();
        int[] arr = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            arr[i] = cnt[num];
            pq.add(new int[]{num, i});
        }
        int[] left = new int[n];
        Arrays.fill(left,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <n; i++) {
            while (stack.size()>0 && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            if(stack.size()>0){
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] right = new int[n];
        Arrays.fill(right,n-1);
        stack = new Stack<>();
        stack.push(n-1);
        for (int i = n-2; i>=0; i--) {
            while (stack.size()>0 && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.size()>0){
                right[i] = stack.peek()-1;
            }
            stack.push(i);
        }

        BigInteger ans = new BigInteger("1");
        while (pq.size()>0 && k>0){
            int[] p = pq.poll();
            long  cnt = (long)(p[1] - left[p[1]]) * (right[p[1]] - p[1]+1);
            if(cnt>k){
                ans = ans.multiply(BigInteger.valueOf(p[0]).modPow(new BigInteger(String.valueOf(k)),mod));
                k =0;
            }else {
                ans = ans.multiply(BigInteger.valueOf(p[0]).modPow(new BigInteger(String.valueOf(cnt)),mod));
                k-=cnt;
            }
            ans = ans.mod(mod);
        }
        return ans.intValue();

    }


    static final List<Integer> PRIMES = getPrimesLe((int)1E5+1);
    static int[] cnt = new int[100001];
    static {
        for (int i = 1; i <cnt.length ; i++) {
            List<Integer> list = getPrimeFactors(i);
            HashSet<Integer> set = new HashSet<>(list);
            cnt[i] = set.size();
        }
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
}
