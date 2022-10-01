package com.example.demo.leetcode;

import java.util.*;

public class Week283 {
    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{53,41,90,33,84,26,50,32,63,47,66,43,29,88,71,28,83},76));
        System.out.println(replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}));
    }

    public List<String> cellsInRange(String s) {
        String[] cols = s.split(":");
        char[] chars = s.toCharArray();
        int a = (int) chars[1];
        int b= (int) chars[4];
        char cc = chars[0];
        char bb = chars[3];
        List<String> list = new ArrayList<>();
        for(char c = cc ; c<=bb; c++){
            for(int i=a; i<=b; i++){
                list.add(String.valueOf(c)+i);
            }
        }
        return list;
    }


    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int start = 1;
        int[] cf = new int[nums.length];
        cf[0] = nums[0]-1;
        for(int i=1;i<nums.length;i++){
            cf[i] = nums[i]-nums[i-1];
        }

        for(int i=0; i<cf.length; i++){
            if(i==0 && cf[i]==0){
                start = 2;
                continue;
            }
            if((cf[i]==0 || cf[i]==1) && i>0){
                start = nums[i]+1;
                continue;
            }
            if(k>=nums[i]-start){
                ans += (long) (start + nums[i] - 1) * ( nums[i]-start) /2;
                k -= nums[i]-start;
                start = nums[i]+1;
            }else{
                ans += (long) (start + start+k-1) * ( k) /2;
                k = 0;
                break;

            }
        }

        if(k>0){
            ans += (long) (nums[nums.length-1]+1  + nums[nums.length-1]+1+k-1) * ( k) /2;
        }
        return ans;

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] d: descriptions){
            int f = d[0], s =d[1], t =d[2];
            if(!map.containsKey(f)){map.put(f, new TreeNode(f));}
            if(!map.containsKey(s)){map.put(f, new TreeNode(s));}
            if(t==1){
                map.get(f).left = map.get(s);
            }else {
                map.get(f).right = map.get(s);
            }
            set.add(s);
        }
        for(int t:map.keySet()){
            if(!set.contains(t)){ return  map.get(t);}
        }
        return null;

    }


    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        ans.add(nums[0]);
        for(int i=1; i<nums.length;i++){
            ans.add(nums[i]);
            while (ans.size()>1){
                int a = ans.size();
                int fir = ans.get(a-1);
                int sec = ans.get(a-2);
                int gc = gcd(fir,sec);
                if(gc==1){
                    break;
                }else{
                    ans.remove(a-1);
                    ans.remove(a-2);
                    ans.add(fir/gc * sec);
                }
            }
        }
        return ans;


    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
