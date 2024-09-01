package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week406 {
    public static void main(String[] args) {

    }

    public String getSmallestString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n-1; i++) {
            if((cs[i]-'0')%2 == (cs[i+1]-'0')%2 &&  cs[i+1]-'0'< cs[i]-'0'){
                char c = cs[i];
                cs[i] = cs[i+1];
                cs[i+1] = c;
                break;
            }
        }
        return new String(cs);
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode cur = h;
        while ( cur.next!=null){
            if(set.contains(cur.next.val)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }

        }

        return h.next;
    }

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans = 0;
        long l = 1, r = 1;
        int loc1 = m-2, loc2 = n-2;
        while (loc1>=0 || loc2>=0){
            if(loc1>=0 && loc2>=0){
                if(horizontalCut[loc1]>=verticalCut[loc2]){
                    ans += horizontalCut[loc1]* r;
                    l++;
                    loc1--;
                }else {
                    ans += verticalCut[loc2]*l;
                    r++;
                    loc2--;
                }
            }else if(loc1>=0){
                ans += horizontalCut[loc1]* r;
                l++;
                loc1--;
            }else {
                ans += verticalCut[loc2]*l;
                r++;
                loc2--;
            }
        }
        return ans;
    }
}
