package com.example.demo.leetcode;

import java.util.*;

public class Week290 {


    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        int[] cnt = new int[1001];
        for (int i = 0; i < n; i++) {
            Set<Integer> set= new HashSet<>();
            for (int j = 0; j < nums[0].length; j++) {
                if(!set.contains(nums[i][j])){
                    set.add(nums[i][j]);
                    cnt[nums[i][j]]++;
                }

            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if(cnt[i] == n){
                list.add(i);
            }
        }
        return list;
    }


    public int countLatticePoints(int[][] circles) {
        int ans = 0;
        for (int i = 0; i <=200; i++) {
            out:for (int j = 0; j <=200; j++) {
                for (int[] circle : circles) {
                    int x = circle[0], y = circle[1], r = circle[2];
                    if (r * r >= (x - i)*(x - i) + (y - j)* (y - j)) {
                        ans++;
                        continue out;
                    }
                }
            }
        }
        return ans;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        ArrayList[] list = new ArrayList[101];
        for (int i = 0; i < 101; i++) {
            list[i] = new ArrayList<Integer>();
        }
        Arrays.sort(rectangles, (a,b)->a[0]-b[0]);
        for(int[] r: rectangles){
            int x = r[0], y = r[1];
            list[y].add(x);
        }
        int[] ans = new int[points.length];
        for(int k=0; k<points.length; k++){
            int[] p = points[k];
            int x = p[0], y = p[1];
            int res = 0;
            for (int i = y; i <101 ; i++) {
                if(list[i].size()==0){
                    continue;
                }
                ArrayList<Integer> s = list[i];
                int left = 0, right = s.size();
                while (left<right){
                    int mid = left+right>>1;
                    if(s.get(mid)<x){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                res += s.size()-right;
            }
            ans[k] = res;
        }
        return ans;
    }


    /**
     * 离散化
     * */
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        //Arrays.sort(flowers,(a,b)->a[0]-b[0]);
        //离散化
        int n = flowers.length;
        int[] record = new int[n];
        int[] record2 = new int[n];
        for (int i = 0; i < n; i++) {
            record[i] = flowers[i][0]-1;
            record2[i] = flowers[i][1];
        }
        Arrays.sort(record);
        Arrays.sort(record2);

        int[] ans = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            ans[i] = search(record, persons[i]) - search(record2, persons[i]);
        }
        return ans;
    }
    private int search(int[] arr, int t){
        int left = 0, right = arr.length;
        while (left<right){
            int mid = left+right>>1;
            if(arr[mid]<t){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return  right;
    }


}
