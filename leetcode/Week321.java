package com.example.demo.leetcode;

import java.util.*;

public class Week321 {
    public static void main(String[] args) {

    }
    public int pivotInteger(int n) {

        for (int i = 1; i <=n ; i++) {
            if( n*(n+1)/2 - i*(i+1)/2 + i == i*(i+1)/2  ){
                return i;
            }
        }
        return -1;
    }


    public int appendCharacters(String s, String t) {

        int n = s.length();
        int m = t.length();
        int ans = m;
        int loc = 0;
        for (int i = 0; i <m ; i++) {
            while (loc<n && s.charAt(loc)!=t.charAt(i) ){
                loc++;
            }
            if(loc==n){
                ans = i;
                break;
            }
            loc++;
        }
        return  m-ans;

    }

    public ListNode removeNodes(ListNode head) {


        Stack<ListNode> stack = new Stack<>();
        ListNode t = new ListNode(Integer.MAX_VALUE);
        t.next = head;
        stack.push(t);
        while (head!=null){
            if(head.val<=stack.peek().val){
                stack.push(head);
            }else{
                while (head.val>stack.peek().val){
                    stack.pop();
                }
                stack.peek().next = head;
                stack.push(head);
            }
            head = head.next;
        }
        return t.next;
    }


    public int countSubarrays(int[] nums, int k) {
        int loc = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == k){
                loc = i;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 1;
        for(int i= loc-1; i>=0 ; i--){
            if(nums[i]<k){
                sum--;
            }else{
                sum++;
            }
            if(sum==0 || sum ==1){
                ans++;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        sum = 0;
        for(int i = loc+1; i<n;i++){
            if(nums[i]<k){
                sum--;
            }else{
                sum++;
            }
            if(sum==0 || sum ==1){
                ans++;
            }
            if(map.getOrDefault(-sum,0)!=0){
                ans+= map.get(-sum);
            }
            if(map.getOrDefault(1-sum,0)!=0){
                ans+= map.get(1-sum);
            }
        }
        return ans;

    }

}
