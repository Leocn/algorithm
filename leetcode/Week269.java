package com.example.demo.leetcode;

import java.util.*;

public class Week269 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
        System.out.println(minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                list.add(i);
            }
            if(nums[i]>target){
                break;
            }
        }
        return list;
    }


    public static int[] getAverages(int[] nums, int k) {

        long[] res = new long[nums.length];
        Arrays.fill(res,-1);
        if(nums.length<=2*k){
            int[] r = new int[nums.length];
            Arrays.fill(res,-1);
            return r ;
        }

        long sum = 0;
        for (int i = 0; i <= 2*k; i++) {
            sum += nums[i];
        }
        res[k] = sum/(2*k+1);
        for (int i = k+1; i < nums.length-k; i++) {
            sum = sum - nums[i-k-1]+ nums[i+k];
            res[i] = sum/(2*k+1);

        }
        int[] r = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            r[i] = (int)res[i];
        }

        return r;
    }


    public static int minimumDeletions(int[] nums) {
        int l = nums.length;
        int min = 10000000;
        int max = -1000000;
        int minPositionPP = 0;
        int maxPositionPP = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                maxPositionPP = i;
                max = nums[i];
            }
            if(nums[i]<min){
                minPositionPP = i;
                min = nums[i];
            }
        }
        if(maxPositionPP==minPositionPP) {
            return 1;
        }

        int minPosition = Math.min(minPositionPP,maxPositionPP);
        int maxPosition = Math.max(minPositionPP,maxPositionPP);


        if( maxPosition<=l/2){
            return maxPosition+1;
        }
        if(maxPosition>=l/2 && minPosition<=l/2){
            int res = 0;
            if(minPosition+1<= l- maxPosition){
                res += minPosition+1;
                if(maxPosition-minPosition<= l-maxPosition){
                    res += maxPosition-minPosition;
                }else {
                    res += l-maxPosition;
                }


            }else {
                res += l- maxPosition;
                if(maxPosition-minPosition>minPosition+1){
                    res += minPosition+1;
                }else {
                    res += maxPosition-minPosition;
                }

            }
            return res;

        }


        return l- minPosition;

    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        boolean[] record = new boolean[n];
        int[] smallTime = new int[n];

        Map<Integer,List<int[]>> map = new HashMap<>();
        for (int i = 0; i < meetings.length; i++) {
            int[] tem  = meetings[i];
            List<int[]> l = map.getOrDefault(tem[0], new ArrayList<>());
            l.add(new int[]{tem[1],tem[2]});
            map.put(tem[0],l);

            List<int[]> l2 = map.getOrDefault(tem[1], new ArrayList<>());
            l2.add(new int[]{tem[0],tem[2]});
            map.put(tem[1],l2);
        }
        record[0] = true;
        record[firstPerson]= true;
        Arrays.fill(smallTime,100000000);
        smallTime[0] = 0;
        smallTime[firstPerson] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(firstPerson);
        while (!queue.isEmpty()){
            int first = queue.poll();
            if(map.containsKey(first)){
                List<int[]> l = map.get(first);
                for (int i = 0; i < l.size(); i++) {
                    int[] edge = l.get(i);
                    if(record[first] && edge[1]>=smallTime[first]){
                        record[edge[0]] = true;
                        if(smallTime[edge[0]]>edge[1]){
                            queue.add(edge[0]);
                            smallTime[edge[0]] = edge[1];
                        }
                    }
                }

            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if(record[i]){
                list.add(i);
            }
        }
        return list;
    }

}
