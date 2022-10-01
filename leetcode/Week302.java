package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Week302 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(smallestTrimmedNumbers(
//                new String[]{"102", "473", "251", "814"},
//                new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}}
//        )));

        System.out.println(Arrays.toString(smallestTrimmedNumbers(
                new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"},
                new int[][]{{9,4 },{6,1 },{3,8 },{12,9 },{11,4 },{4,9},{2,7},{10,3 },{13,1 },{13,1 },{6,1 },{5,10 }}
        )));


    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        String first = nums[0]+"";
        int n = first.length();
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<n; i++){
            PriorityQueue<String[]> queue = new PriorityQueue<>(Comparator.comparing((String[] o) -> o[0]).thenComparingInt(o -> Integer.parseInt(o[1])));
            for(int j=0; j<nums.length; j++){
                queue.add(new String[]{nums[j].substring(i, n), j+""});
            }
            int[] s = new int[nums.length];
            for(int j=0; j<nums.length; j++){
                String[] po = queue.poll();
                s[j] =  Integer.parseInt(po[1]);

            }

            map.put(i, s);

        }

        int[] ans = new int[queries.length];
        for(int i=0; i<ans.length; i++){
            int[] q= queries[i];
            ans[i] =map.get(n-q[1])[q[0]-1];
        }
        return ans;

    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int m = numsDivide.length;

        BigInteger last =  BigInteger.valueOf(numsDivide[0]);
        for(int i=1; i<m; i++){

            BigInteger a = BigInteger.valueOf(numsDivide[i]);
            last = last.gcd(a);
        }
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(last.intValue()/nums[i]==0){
                break;
            }else{
                ans ++;
            }
        }
        return ans == nums.length ?-1:ans;


    }
}
