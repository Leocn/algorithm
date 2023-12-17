package com.example.demo.atcoder.abc321;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<String> list = new ArrayList<>();

        List<String> tem = new ArrayList<>();
        tem.add("0");
        for (int i = 1; i <=9 ; i++) {
            list.add(i+"");
            tem.add(i+"");

        }
        while (true){
            List<String > s = new ArrayList<>();

            for (int i = 1; i <=9; i++) {
                for(String c: tem){
                    if(i>  c.charAt(0)-'0'){
                        s.add(i+c);
                    }
                }

            }
            if(s.size()==0){
                break;
            }
            list.addAll(s);
            tem = new ArrayList<>(s);

        }
        System.out.println(list.get(k-1));

    }
}
