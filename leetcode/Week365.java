package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Week365 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1}, 0, 3));
    }

    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i%10 == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1,-1};
        }
        int index = 1;
        int lastIndex = 0;
        int firstIndex = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;


        ListNode  beforeNode = head;
        ListNode cur = head.next;
        while (cur!=null && cur.next!=null){
            if( (cur.val > beforeNode.val &&  cur.val >  cur.next.val) ||  (cur.val < beforeNode.val &&  cur.val <  cur.next.val) ){

                if(lastIndex != 0){
                    min = Math.min(min,index -lastIndex );
                }

                lastIndex = index;
                if(firstIndex == 0){
                    firstIndex = index;
                }
            }

            index ++;
            beforeNode = cur;
            cur = cur.next;
        }

        if(firstIndex==0 || lastIndex == 0  || firstIndex == lastIndex ) {return new int[]{-1,-1};}
        max = lastIndex -firstIndex;

        return new int[]{min,max};
    }



    /**
     * BFS
     * */
    public static int minimumOperations(int[] nums, int start, int goal) {

        Queue<Integer> queue = new LinkedList<>();
        //记录0-1000数字是否被访问过
        boolean[] record = new boolean[1001];
        queue.add(start);
        record[start] = true;
        int times = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int s = queue.poll();
            //每次queue被访问完,times++.类似层遍历
            times++;
            while (size>0){
                for (int num : nums) {
                    int[] array = new int[]{s + num, s - num, s ^ num};
                    for (int a : array) {
                        if (a == goal) {
                            return times;
                        }
                        //添加满足条件的元素到queue
                        if (0 <= a && a <= 1000 && !record[a]) {
                            queue.offer(a);
                            record[a] = true;
                        }
                    }
                }
                size --;
                if(size>0){s = queue.poll();}

            }
        }
        return -1;
    }

}
