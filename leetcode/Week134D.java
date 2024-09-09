package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week134D {
    public static void main(String[] args) {

    }

    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(colors[i%n] == colors[(i+2)%n] && colors[i%n] != colors[(i+1)%n]){
                ans ++;
            }
        }
        return ans;
    }

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        if(currentEnergy<enemyEnergies[0]){
            return 0;
        }
        long t = currentEnergy;
        for(int i=1; i<n; i++){
            t += enemyEnergies[i];
        }
        return t/enemyEnergies[0];
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0, n = colors.length;
        int[] cnt = new int[2*n];
        cnt[0] = 1;
        for(int i=1; i<2*n; i++){
            if(colors[i%n]!=colors[(i-1)%n]){
                cnt[i] = cnt[i-1] + 1;
            }else{
                cnt[i] = 1;
            }
        }
        for(int i=0; i<n; i++){
            if(cnt[i+k-1]>=k){
                ans++;
            }
        }
        return ans;
    }

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            Map<Integer, Integer> tem = new HashMap<>();

            for(int m: map.keySet()){
                tem.merge(m& num, map.get(m), Integer::sum);
            }
            tem.merge(num, 1, Integer::sum);

            map = tem;
            ans += map.getOrDefault(k, 0);
        }

        return ans;

    }

}
