package com.example.demo.atcoder.abc270;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        if(x==1 || y==1){
            set.add(1);
            ans+=1;
        }
        if(x==2 || y==2){
            set.add(2);
            ans +=2;
        }

        if(x==3 || y==3){
            if(!set.contains(1)){
                set.add(1);
                ans+=1;
            }
            if(!set.contains(2)){
                set.add(2);
                ans+=2;
            }
        }

        if(x==4 || y==4){
            set.add(4);
            ans +=4;
        }
        if(x==5 || y==5){
            if(!set.contains(1)){
                set.add(1);
                ans+=1;
            }
            if(!set.contains(4)){
                set.add(4);
                ans+=4;
            }
        }


        if(x==6 || y==6){
            if(!set.contains(2)){
                set.add(2);
                ans+=2;
            }
            if(!set.contains(4)){
                set.add(4);
                ans+=4;
            }
        }
        if(x==7 || y==7){
            ans = 7;
        }

        System.out.println(ans);
    }
}
