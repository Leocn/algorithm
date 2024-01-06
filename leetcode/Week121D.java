package com.example.demo.leetcode;

import java.util.*;

public class Week121D {
    public static void main(String[] args) {

    }

    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <n ; i++) {
            if(nums[i] == nums[i-1] + 1){
                sum += nums[i];
            }else {
                break;
            }
        }
        for (int i = sum; i < sum + 100 ; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int r = 0;
        for (int num : nums) {
            r ^= num;
        }
        int ans = 0;
        for (int i = 0; i < 28; i++) {
            if(((r>>i)&1)!= ((k>>i)&1)){
                ans++;
            }
        }
        return ans;

    }
    /**
     * 类似BFS
     * */
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y>=x){
            return y-x;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        dq.add(y);
        set.add(y);
        int c = 0;
        while (dq.size()>0){
            int s = dq.size();
            while (s-->0){
                int p = dq.poll();
                if(p == x) return c;
                if(p-1>0 && !set.contains(p-1)){
                    dq.add(p-1);
                    set.add(p-1);
                }
                if( p+1<=11*x && !set.contains(p+1)){
                    dq.add(p+1);
                    set.add(p+1);
                }
                if( p*11<=11*x && !set.contains(p*11)){
                    dq.add(p*11);
                    set.add(p*11);
                }

                if( p*5<=11*x && !set.contains(p*5)){
                    dq.add(p*5);
                    set.add(p*5);
                }

            }
            c++;
        }
        return -1;

    }


    /**
     * 数位DP
     * */
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return calc(finish,limit, s) - calc(start-1,limit, s) ;

    }

    private long calc(long high, int k, String tar) {
        var s = Long.toString(high).toCharArray();
        int n = s.length;
        var memo = new long[n][10];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        char[] t = tar.toCharArray();
        return dfs(0, 0, true, false, k, s, memo, t);
    }

    private long dfs(int i, int pre, boolean isLimit, boolean isNum, int k, char[] s, long[][] memo, char[] tar) {
        if (i == s.length)
            return isNum? 1 : 0; // 找到了一个合法数字
        if (!isLimit && isNum && memo[i][pre] != -1)
            return memo[i][pre];
        long res = 0;
        if (!isNum) // 可以跳过当前数位
            res = dfs(i + 1, pre, false, false,k, s, memo, tar);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 high 的一样，那么这一位至多填数字 s[i]（否则就超过 high 啦）
        for (int d = isNum ? 0 : 1; d <= Math.min(up,k); d++) {// 枚举要填入的数字 d
            int w = s.length - i;
            if( w <=tar.length ){
                if( tar[tar.length -w] -'0' == d && (tar.length -w == 0 ||pre ==  tar[tar.length -w-1] -'0')){
                    res = res + dfs(i + 1, d, isLimit && d == up, true,k,s, memo, tar);
                }
            }else {
                res = res + dfs(i + 1, d, isLimit && d == up, true,k,s, memo, tar);
            }
        }
        if (!isLimit && isNum)
            memo[i][pre] = res; // 记忆化搜索
        return res;
    }

}
