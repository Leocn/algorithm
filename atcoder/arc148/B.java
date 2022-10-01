package com.example.demo.atcoder.arc148;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] cs = str.toCharArray();
        String ans = str;
        for(int i = 0; i<n; i++){
            if(cs[i] == 'd'){
                continue;
            }
            for (int j = n-1; j >=i ; j--) {
                if(cs[j]== 'p'){
                    char[] cp = Arrays.copyOf(cs, n);
                    swap(i, j ,cp);
                    if(ans.compareTo(new String(cp))>0){
                        ans = new String(cp);
                    }
                }
            }
            break ;
        }

        System.out.println(ans);
    }
    private static void  swap(int i, int j, char[] cs){
        for (int k = i; k <= (j+i)/2 ; k++) {
            int tem = cs[j-(k-i)];
            if(cs[k] =='d'){
                cs[j-(k-i)] ='p';
            }else{
                cs[j-(k-i)] = 'd';
            }
            if(tem == 'd'){
                cs[k] ='p';
            }else{
                cs[k] = 'd';
            }
        }
    }
}
