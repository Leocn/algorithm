package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Week382 {

    public int countKeyChanges(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 1; i <n ; i++) {
            if(cs[i]!=cs[i-1]){
                ans++;
            }
        }
        return ans;
    }

    public int maximumLength(int[] nums) {
        int ans = 1;
        Map<Long, Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge((long)num, 1, Integer::sum);
        }
        long q = (long)Math.sqrt((int)1e9);
        for (int i = 2; i <=q ; i++) {
            long s = i;
            int c = 0;
            while (map.containsKey(s)){

                if((c==0 && map.get(s)>=1) ){
                    c++;
                }else if((c>0 && map.get(s)>=1 && map.get((long)Math.sqrt(s))>=2)){
                    c+=2;
                }else {
                    break;
                }
                s*=s;

            }
            ans = Math.max(c, ans);
        }
        int c  = map.getOrDefault(1L, 0);
        if(c>0 && c%2==0){
            c = c-1;
        }
        ans = Math.max(ans, c);
        return ans;
    }

    public long flowerGame(int n, int m) {
        long ans = (long)(n)*m/2;
        return ans;
    }

    /**
     * 位运算，按位统计， mask记录前期满足条件的位
     * @param nums
     * @param k
     * @return
     */
    public int minOrAfterOperations(int[] nums, int k) {
        int mask = 0;
        int ans = 0;

        for (int i = 29; i >=0 ; i--) {
            mask |= 1<<i;
            int pre = -1;
            int cnt = 0;
            for(int num: nums){
                pre &= num & mask;
                if(pre != 0){
                    cnt++;
                }else {
                    pre = -1;
                }
            }
            if(cnt>k){
                mask ^= 1<<i;
                ans |= 1<<i;
            }
        }
        return ans;

    }

}
