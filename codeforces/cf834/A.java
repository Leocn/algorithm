package com.example.demo.codeforces.cf834;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            if(!str.startsWith("e") && !str.startsWith("Y") && !str.startsWith("s")){
                System.out.println("No");
                continue;
            }
            if(!str.endsWith("e") && !str.endsWith("Y") && !str.endsWith("s")){
                System.out.println("No");
                continue;
            }
            if(str.startsWith("e")){
                str = "Y" + str;
            }else if(str.startsWith("s")){
                str = "Ye" + str;
            }
            if(str.endsWith("e")) {
                str =  str+ "s";
            }else if(str.endsWith("Y")){
                str = str +"es";
            }
            if(str.length()%3!=0){
                System.out.println("No");
                continue;
            }
            boolean flag = true;
            for (int i = 0; i <= str.length()-3; i+=3) {
                String s = str.substring(i,i+3);
                if(!s.equals("Yes")){
                    flag = false;
                    System.out.println("No");
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }

        }
    }
}
