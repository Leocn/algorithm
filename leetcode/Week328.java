package com.example.demo.leetcode;

import java.util.*;

public class Week328 {
    public int differenceOfSum(int[] nums) {
        int sum1 = Arrays.stream(nums).sum();
        int sum2 = 0;
        for(int n: nums){
            while (n>0){
                sum2 += n%10;
                n = n/10;
            }
        }
        return Math.abs(sum1-sum2);
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] B = new int[n+1][n+1];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x1 = q[0]+1, y1= q[1]+1 , x2 = q[2]+1, y2 = q[3]+1;
            int c = 1;
            B[x1][y1] += c; //进行差分操作
            B[x1][y2+1] -=c;
            B[x2+1][y1] -=c;
            B[x2+1][y2+1] += c;
        }
        int[][] ans = new int[n][n];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                B[i][j] +=  B[i-1][j] + B[i][j-1] - B[i-1][j-1];
                ans[i-1][j-1] = B[i][j];
            }
        }
        return ans;

    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        int left =0;
        for(int i=0 ;i <n;i++){
           int t =  map.getOrDefault(nums[i], 0);
           sum+=t;
           map.put(nums[i], t+1);
           if(sum>=k){
               while (sum>=k && left<i){
                   int d = map.get(nums[left]);
                   sum -= d-1;
                   map.put(nums[left], d-1);
                   left++;
                   ans+=n-i;
               }
           }
        }
        return  ans;
    }
    List[] arr;
    long ans;
    int[] price;
    public long maxOutput(int n, int[][] edges, int[] _price) {
        price = _price;
        arr =  new List[n];
        ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int[]e : edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        dfs(0, -1);
        return ans;
    }
    private long[] dfs(int now, int before){
        List<Integer> list = arr[now];
        long s1  = price[now], s2 =0;
        for(int d : list){
            if(d==before){
                continue;
            }

            long[] res = dfs(d, now);
            ans = Math.max(ans, s1+res[1]);
            ans = Math.max(ans, s2 +res[0]);
            s1 =Math.max(s1, res[0]+price[now]);
            s2 = Math.max(s2, res[1] + price[now]);

        }
        return new long[]{s1, s2};

    }
}
