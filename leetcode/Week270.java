package com.example.demo.leetcode;

import java.util.*;

public class Week270 {
    public static void main(String[] args) {

    }
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        Set<Integer> set = new HashSet<Integer>();

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<digits.length;i++){
            for (int j = 0; j < digits.length ; j++) {
                if(j==i){
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if(k==i || k==j){
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(digits[i]).append(digits[j]).append(digits[k]);
                    String s = new String(sb);
                    Integer dd = Integer.parseInt(s);
                    if(dd>99 && dd<1000 && dd%2==0){
                        if(set.contains(dd)){
                            continue;
                        }else {
                            set.add(dd);
                            list.add(dd);
                        }

                    }
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode cur = head;
        ListNode fast =head.next;
        while (fast!=null && fast.next!=null){
            cur = cur.next;
            fast = fast.next.next;
        }
        ListNode temp = cur;
        cur = cur.next.next;
        temp.next = cur;
        return head;
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        getPath(root, startValue,left);
        getPath(root, destValue,right);


        StringBuilder res = new StringBuilder();
        int ld = 0;
        for (int i = 0; i < left.length() && i<right.length() && right.charAt(i)==left.charAt(i); i++) {
            ld = i+1;

        }
        left.delete(0,ld);
        right.delete(0,ld);
        for(int i =0; i<left.length(); i++){
            res.append("U");
        }
        return  res.toString() +right;

    }

    public boolean getPath(TreeNode root, int target, StringBuilder path){
        if(root==null){
            return false;
        }
        if(root.val==target){
            return true;
        }
        path.append("L");
        if(!getPath(root.left, target, path)){
            path.deleteCharAt(path.length()-1);
            path.append("R");
            return getPath(root.right, target, path);
        }
        return true;
    }
}
