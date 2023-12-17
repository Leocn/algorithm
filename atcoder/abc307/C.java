package com.example.demo.atcoder.abc307;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h1 = sc.nextInt(), w1 = sc.nextInt();
        char[][] cs1 = new char[h1][w1];
        for (int i = 0; i < h1; i++) {
            cs1[i] = sc.next().toCharArray();
        }
        int a1 = -1, b1= -1;
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w1; j++) {
                if(cs1[i][j] == '#'){
                    if(a1==-1){
                        a1 = i;
                        b1= j;
                    }else {
                        list1.add(new int[]{i-a1,j-b1});
                    }

                }
            }

        }


        int a2 = -1, b2 = -1;
        int h2 = sc.nextInt(), w2 = sc.nextInt();
        char[][] cs2 = new char[h2][w2];
        for (int i = 0; i < h2; i++) {
            cs2[i] = sc.next().toCharArray();
        }
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w2; j++) {
                if(cs2[i][j] == '#'){
                    if(a2==-1){
                        a2 = i;
                        b2= j;
                    }else {
                        list2.add(new int[]{i-a2,j-b2});
                    }

                }
            }

        }


        int h3 = sc.nextInt(), w3 = sc.nextInt();
        char[][] cs3 = new char[h3][w3];
        for (int i = 0; i < h3; i++) {
            cs3[i] = sc.next().toCharArray();
        }

        int x = -1, y =-1;
        List<int[]> list3 = new ArrayList<>();
        for (int i = 0; i < h3; i++) {
            for (int j = 0; j < w3; j++) {
                if(cs3[i][j]=='#') {
                    if(x==-1){
                        x= i;
                        y = j;
                    }else{
                        list3.add(new int[]{i-x,j-y});
                    }
                }


            }
        }

        if(x==-1){
            if(a1==-1 && a2==-1) {
                System.out.println("Yes");

            }else {
                System.out.println("No");
            }
            return;
        }


        char[][] tar = new char[h3][w3];
        for (int i = 0; i < h3; i++) {
            System.arraycopy(cs3[i], 0, tar[i], 0, w3);
        }
        if(check(tar,x,y,list1,list2, new boolean[h3][w3],a1,a2)){
            System.out.println("Yes");
            return;
        }
        tar = new char[h3][w3];
        for (int i = 0; i < h3; i++) {
            System.arraycopy(cs3[i], 0, tar[i], 0, w3);
        }
        if(check(tar,x,y,list2,list1, new boolean[h3][w3],a2,a1)){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");





    }

    private static boolean check(char[][] tar, int x, int y, List<int[]> list1, List<int[]> list2, boolean[][] vis, int a1, int a2 ){
        if(a1!=-1){
            vis[x][y] = true;
            for(int[] l: list1){
                if(x+l[0] >= tar.length || y+l[1] >= tar[0].length|| x+l[0]<0 || y+l[1]<0) return false;
                if(tar[x+l[0]][y+l[1]]!='#'){
                    return false;
                }else {
                    vis[x+l[0]][y+l[1]] = true;
                }
            }
        }
        if(a2!=-1){
            boolean f = false;
            for (int i = 0; i < tar.length; i++) {
                for (int j = 0; j <tar[0].length; j++) {
                    if(tar[i][j]=='#'){
                        char[][] next = new char[tar.length][tar[0].length];
                        boolean[][] vr = new boolean[tar.length][tar[0].length];
                        for (int k = 0; k < tar.length; k++) {
                            System.arraycopy(tar[k], 0, next[k], 0, tar[0].length);
                            System.arraycopy(vis[k], 0, vr[k], 0, tar[0].length);
                        }
                        vr[i][j] =true;
                        if(check2(next, i,j,list2,vr)){
                            f = true;
                            break;
                        }
                    }
                }
            }
            return f;


        }

        for (int i = 0; i < tar.length; i++) {
            for (int j = 0; j <tar[0].length; j++) {
                if(tar[i][j]=='#' && !vis[i][j]){
                    return false;
                }

            }
        }
        return true;


    }

    private static  boolean check2(char[][] tar, int x, int y,  List<int[]> list2, boolean[][] vis){
        for(int[] l: list2){
            if(x+l[0] >= tar.length || y+l[1] >= tar[0].length || x+l[0]<0 || y+l[1]<0) return false;
            if(tar[x+l[0]][y+l[1]]!='#'){
                return false;
            }else {
                vis[x+l[0]][y+l[1]] = true;
            }
        }
        for (int i = 0; i < tar.length; i++) {
            for (int j = 0; j <tar[0].length; j++) {
                if(tar[i][j]=='#' && !vis[i][j]){
                    return false;
                }

            }
        }
        return true;
    }
}
