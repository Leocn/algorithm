package com.example.demo.leetcode;


import java.util.*;

public class Week368 {
    public static void main(String[] args) {

    }

    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = -1;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if(min>=nums[i]){
                dp[i] = -1;
                min = nums[i];
            }else {
                dp[i] = min;
            }
        }
        min = nums[n-1];
        int ans = Integer.MAX_VALUE;
        for (int i = n-2; i >=0 ; i--) {
            if(min>=nums[i]){
                min = nums[i];
            }else {
                if(dp[i]!=-1){
                    ans = Math.min(dp[i] + min + nums[i], ans);
                }
            }
        }
        ans = ans == Integer.MAX_VALUE?-1:ans;
        return ans;
    }

    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num,1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            list.add(e.getValue());
        }
        Collections.sort(list);
        int ans= Integer.MAX_VALUE;
        int min = list.get(0);
        if(min == 1){
            int sum = 0;
            for(int l: list){
                sum += (l+1)/2;
            }
            return sum;
        }
        out:for (int i = min; i>=2; i--) {
            int sum1 = 0;
            for (int j = 0; j < list.size(); j++) {
                int a = list.get(j);
                int c = Integer.MAX_VALUE;
                if(a%(i+1)== 0){
                    c = a/(i+1);
                }else {
                    boolean f = false;
                    for (int k = a/(i+1); k >=0 ; k--) {
                        if((a- k*(i+1))%i == 0){
                            c = k + (a- k*(i+1))/i;
                            f = true;
                        }
                    }
                    if(!f){
                        continue out;
                    }
                }

                sum1 += c;
            }
            ans = Math.min(sum1,ans);


        }

        return ans;
    }

    public int minimumChanges(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[][] cnt = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                int len = j-i+1;
                int loc = 1, q = (int)Math.sqrt(len);
                int res = len;
                while (loc<=q){
                    int c = 0;
                    if(q%loc!=0){
                        continue;
                    }
                    for (int l = 0; l < loc; l++) {
                        Set<Character> set = new HashSet<>();
                        int f = i+loc-1-l, t = j-1-l;
                        for (int m = f; m <=t ; m+=loc) {
                            set.add(cs[m]);
                        }
                        c+= set.size()-1;
                    }
//                    res = Math.min
                    loc++;
                }
                cnt[i][j] = res;

            }
        }
        int[][] dp = new int[k+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0] = cnt[0];
        for (int i = 1; i < k ; i++) {
            for (int j = 2*i+1; j < n; j++) {
                int res = Integer.MAX_VALUE;
                for (int l = 2*i; l < j ; l++) {
                    res = Math.min(res, dp[i-1][l-1] + cnt[l][j]);
                }
                dp[i][j] = res;

            }
        }
        return dp[k-1][n-1];

    }

}
