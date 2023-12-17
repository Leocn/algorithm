package com.example.demo.leetcode;

import java.util.*;

public class Week371 {
    public static void main(String[] args) {
        maximumStrongPairXor(new int[]{3,49,81,95,92});
    }

    static public int maximumStrongPairXor(int[] nums) {

        Arrays.sort(nums);
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int n = nums.length;
        int d = 31 - Integer.numberOfLeadingZeros(max);
        int ans = 0, mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=d; i>=0; i--){
            int t = 1<<i;
            mask |= t;
            int a = ans | t;
            map.clear();
            for (int j = 0; j < n; j++) {
                int tem = nums[j];
                int num =tem&mask;
                if(map.containsKey(num^a) && map.get(num^a)*2>=tem){
                    ans = a;
                    break;
                }
                map.put(num, tem);
            }
        }
        return ans;
    }


    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(List<String> acc: access_times){
            String name = acc.get(0);
            String time = acc.get(1);
            int hour = Integer.valueOf(time.substring(0,2));
            int min = Integer.valueOf(time.substring(2,4));
            int sum = 60*hour + min;
            List<Integer> list = map.getOrDefault(name, new ArrayList<>());
            list.add(sum);
            map.put(name, list);
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> m : map.entrySet()){
            List<Integer> v = m.getValue();
            if(v.size()>=3){
                Collections.sort(v);
                for (int i = 0; i < v.size()-2; i++) {
                    if(v.get(i+2) -v.get(i)<60){
                        ans.add(m.getKey());
                        break;
                    }
                }
            }
        }
        return ans;
    }


}
