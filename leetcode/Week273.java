package com.example.demo.leetcode;

import java.util.*;

public class Week273 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(recoverArray(new int[]{1, 3, 4, 2, 6, 8})));

    }

    public boolean isSameAfterReversals(int num) {
        return num ==0 || num%10 !=0;
    }


    public int[] executeInstructions(int n, int[] startPosTemp, String s) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {

            int[] startPos = new int[2];
            System.arraycopy(startPosTemp, 0, startPos, 0, startPosTemp.length);
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                if(c == 'L'){
                    startPos[1]--;
                }
                if(c=='R'){
                    startPos[1]++;
                }
                if(c == 'U'){
                    startPos[0]--;
                }
                if(c=='D'){
                    startPos[0]++;
                }
                if(startPos[0]<0 || startPos[0]>n-1 ||  startPos[1]<0 || startPos[1]>n-1){
                    res[i] = j-i;
                    break;
                }
                if(j == chars.length-1){
                    res[i] = j-i+1;
                }

            }
        }

        return res;
    }

    public static long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        long[] ddd = new long[arr.length];
        List[] record = new List[100001];
        long[] sum = new long[100001];
        for (int i = 0; i < record.length; i++) {
            record[i] = new ArrayList();
        }
        for (int i = 0; i < arr.length; i++) {
            record[arr[i]].add(i);
            sum[arr[i]] += i;
        }

        for (int i = 0; i < sum.length; i++) {
            if(sum[i]==0){
                continue;
            }
            List<Integer> list = record[i];
            res[list.get(0)] =  sum[i] - list.size()* list.get(0);
            ddd[list.get(0)] =  res[list.get(0)];
            for (int j = 1; j < list.size(); j++) {
                int s =  j -1 - (list.size()-1-(j)) ;
                ddd[list.get(j)] = ddd[list.get(j-1)] + s*(list.get(j) - list.get(j-1));
                res[list.get(j)] =   Math.abs(ddd[list.get(j)] );
            }
        }

        return res;
    }


    public static int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length / 2];
        for (int i = 1; ; i++) {
            if (nums[i] > nums[0] && (nums[i] - nums[0]) % 2 == 0) {
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                for (int j = 0, k = 0; j < nums.length; j++) {
                    if (!deque.isEmpty() && deque.peek() == nums[j]) {
                        deque.poll();
                    } else if (k == result.length) {
                        break;
                    } else {
                        deque.offer(nums[j] + nums[i] - nums[0]);
                        result[k++] = nums[j] + (nums[i] - nums[0]) / 2;
                    }
                }
                if (deque.isEmpty()) {
                    return result;
                }
            }
        }
    }

}
