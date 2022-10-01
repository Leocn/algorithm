package com.example.demo.codeforces;

import java.util.*;

public class ECF810C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str = sc.next();
            char[] st = str.toCharArray();
            int n = st.length;
            int countLe = n/2 , countRi = n/2;
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<n; i++){
                if(st[i]=='('){
                    countLe --;
                }else if(st[i]==')' ){
                    countRi --;
                }else{
                    list.add(i);
                }
            }
            String ans = "YES";
            if(countLe>0 && countRi>0){
                for(int i=0; i<list.size(); i++){
                    if(i<countLe){
                        st[list.get(i)] ='(';
                    }else{
                        st[list.get(i)] =')';
                    }
                }
                st[list.get(countLe)] = '(';
                st[list.get(countLe-1)] = ')';
                ans = check(st)? "NO": "YES";
            }

            System.out.println(ans);
        }
    }

    private static boolean check(char[] st){
        int l = 0, r = 0;
        for(char s: st){
            if(s=='('){l++;}
            if(s==')'){r++;}
            if(r-l>0){ return  false;}
        }
        return l==r;

    }
}
