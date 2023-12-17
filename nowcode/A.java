package com.example.demo.nowcode;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String str  = sc.next();
            int ans = 0;
            Set<String> set = new HashSet<>();
            set.add("NE");
            set.add("ES");
            set.add("SW");
            set.add("WN");
            for (int i = 0; i+1 < str.length(); i++) {
                if(set.contains(str.substring(i,i+2))){
                    ans++;
                    continue;
                }
                if(str.charAt(i)!=str.charAt(i+1) ){
                    ans--;
                }


            }
            if(ans>0){
                System.out.println("CW");
            }else {
                System.out.println("CCW");
            }
        }

    }
}
