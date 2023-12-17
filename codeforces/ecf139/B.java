package com.example.demo.codeforces.ecf139;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String str = scanner.next();
            Set<String> set = new HashSet<>();
            String s = "";
            boolean flag = false;
            for (int i =n-1; i >0; i--) {
                String sub = str.substring(i-1,i+1);

                if(set.contains(sub)){
                    flag = true;
                    break;
                }else{
                    if(s.length()==2){
                        set.add(s);
                    }
                }
                s= sub;
            }
            if(flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
