package com.example.demo.leetcode;

import java.util.*;

public class Week267 {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));

        System.out.println(decodeCiphertext("iveo    eed   l te   olc",4));
        //System.out.println(Arrays.toString(friendRequests(5, new int[][]{{0, 1},{1, 2},{2, 3}}, new int[][]{{0, 4}, {1, 2},{3, 1},{3, 4}})));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int l = tickets.length;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if(k>=i){
                sum += Math.min(tickets[i], tickets[k]);
            }else {
                sum += Math.min(tickets[i], tickets[k]-1);
            }
        }
        return sum;
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode cur = head.next;
        ListNode h = head.next;
        ListNode tail = head;
        int times =2;
        int count = 1;
        while (cur.next!=null){
            ListNode tem =  cur.next;

            if(count == times){
                cur.next = null;
                if(times%2 == 0){

                    tail.next = reverseList(h);
                    while (tail.next!=null){
                        tail = tail.next;
                    }
                }else{
                    tail.next = h;
                    while (tail.next!=null){
                        tail = tail.next;
                    }
                }
                h = tem;

                times++;
                count = 1;


            }else{

                count++;

            }
            System.out.println(times + "--" + count);
            cur = tem;
        }
        if(count%2==0){
            tail.next = reverseList(h);
        }else {
            tail.next = h;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while(currentNode!=null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        int width = encodedText.length()/rows;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <rows; j++) {
                int ff =  (j)*width + i+j;
                if(ff<encodedText.length()){
                    s.append(encodedText.charAt(ff ));
                }
            }
        }
        String res= new String(s);
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) != ' ') {
                res = s.substring(0,i+1);
                break;
            }
        }
        return res;

    }



    int[] fa = new int[1001];
    int[] count = new int[1001];
    private void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if(count[rb]== count[ra]){
            fa[rb] = ra;
            count[ra] ++;
        }else if(count[rb]> count[ra]){
            fa[ra] = rb;
        }else if(count[rb]< count[ra]){
            fa[rb] = ra;
        }
    }

    private int find(int a) {
        int root = fa[a];
        if (root == a) {
            return root;
        } else {
            root = find(root);
            fa[a] =  root;
        }
        return root;
    }
    public  boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        fa = new int[1001];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        boolean[] ans = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
           int[] bak = Arrays.copyOf(fa,fa.length);
            union(requests[i][0], requests[i][1]);
            boolean flag = false;
            for (int[] restriction : restrictions) {
                int ukr = find(restriction[0]);
                int vkr = find(restriction[1]);
                if (ukr == vkr) {
                    ans[i] = false;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                fa = bak;
            } else {
                ans[i] = true;
            }
        }
        return ans;

    }





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

}
