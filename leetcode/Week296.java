package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Week296 {
    public int minMaxGame(int[] nums) {
        int n  = nums.length;
        while (n>1){
            for (int i = 0; i < n/2; i++) {
                if(i%2==0){
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                }else{
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            n/=2;
        }
        return nums[0];
    }


    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            while(i<nums.length && nums[i]-s<=k ){
                i++;
            }
            ans++;
        }
        return ans;
    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int[] op:operations){
            int loc = map.get(op[0]);
            map.remove(op[0]);
            map.put(op[1], loc);
            nums[loc] = op[1];
        }
        return nums;

    }

    class TextEditor {

        int loc;
        StringBuilder s;
        public TextEditor() {
            loc = 0;
            s  = new StringBuilder();
        }

        public void addText(String text) {
            s.insert(loc, text);
            loc += text.length();
        }

        public int deleteText(int k) {
            int tem = loc;
            s.replace(Math.max(0, loc-k), loc, "");
            loc = Math.max(0, loc-k);
            return tem-loc;
        }

        public String cursorLeft(int k) {
            loc= Math.max(0, loc-k);
            return  s.substring(  Math.max(0,loc- Math.min(10, s.length())) ,loc);
        }

        public String cursorRight(int k) {
            loc= Math.min(s.length(), loc+k);
            return  s.substring(  Math.max(0,loc- Math.min(10, s.length())) ,loc);

        }
    }

}
