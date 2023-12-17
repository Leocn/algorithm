package com.example.demo.leetcode;

public class Week356 {
    public static void main(String[] args) {

    }

    public String minimumString(String a, String b, String c) {
        String ans1 = minimumString( minimumString(a,b),c);
        String ans2 = minimumString( minimumString(a,c),b);
        String ans3 = minimumString( minimumString(b,c),a);
        String ans4 = minimumString( minimumString(b,a),c);

        String ans5 = minimumString( minimumString(c,a),b);
        String ans6 = minimumString( minimumString(c,b),a);
        String ans = compare(ans1, ans2);
        ans = compare(ans, ans3);
        ans = compare(ans, ans4);
        ans = compare(ans, ans5);
        ans = compare(ans, ans6);
        return ans;

    }

    private String minimumString(String a, String b){
        if(a.contains(b)) {
            return a;
        }
        for (int i = b.length(); i >0; i--) {
            if(a.endsWith(b.substring(0,i))){
                return a + b.substring(i);
            }
        }
        return a+b;
    }

    private String compare(String a, String b){
        if(a.length()>b.length()){
            return b;
        }else if(a.length()<b.length()){
            return a;
        }else {
            if(a.compareTo(b)>=0){
                return b;
            }
        }
        return a;
    }
}
