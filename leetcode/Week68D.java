package com.example.demo.leetcode;

import java.util.*;

public class Week68D {
    public static void main(String[] args) {
        System.out.println(canBeValid("))))))))", "00001111"));

    }

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] strings  = sentences[i].split(" ");
            res =Math.max(res, strings.length);
        }
        return res;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < supplies.length; i++) {
            set.add(supplies[i]);
        }

        List<String> res = new ArrayList<>();
        int times = recipes.length+1;
        boolean[] bb = new boolean[recipes.length+1];
        while (times>0){
            int count = 0;
            for (int i = 0; i < recipes.length; i++) {
                if(bb[i]){continue;}
                List<String>  sss = ingredients.get(i);
                boolean tr = true;
                int j = 0;
                while (tr && j<sss.size()){

                    if(!set.contains(sss.get(j))){
                        tr = false;
                    }
                    j++;
                }

                if(tr){
                    res.add(recipes[i]);
                    bb[i] = true;
                    set.add(recipes[i]);
                    count ++;
                }

            }
            times--;
            if(count ==0){
                break;
            }
        }

        return res;

    }


    public static boolean canBeValid(String s, String locked) {

        int left =0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if(locked.charAt(i)=='1'){
                if(s.charAt(i) == '('){left++;}else {
                    right ++;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() && locked.charAt(i) == '1' && s.charAt(i)==')'){return false;}
            if( locked.charAt(i) == '1' && s.charAt(i)=='('){
                stack.push(')');
            }
            if( locked.charAt(i) == '0' && s.charAt(i)=='('){
                if(left < right || stack.isEmpty()){stack.push(')'); left++;}else {
                    stack.pop();
                }
            }

            if(s.charAt(i) == ')'){
                if(stack.isEmpty()) {
                    if(locked.charAt(i) == '1'){return false;}else {
                        stack.push(')');
                    }
                }else {
                    if(left < right){stack.push(')'); left++;}else{
                        stack.pop();

                    }
                }
            }

        }
        return stack.isEmpty();
    }
}
