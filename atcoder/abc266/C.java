package com.example.demo.atcoder.abc266;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a1 = sc.nextInt(), a2 = sc.nextInt();
        int b1 = sc.nextInt(), b2 = sc.nextInt();
        int c1 = sc.nextInt(), c2 = sc.nextInt();
        int d1 = sc.nextInt(), d2 = sc.nextInt();
        boolean flag  = intersection(a1, a2, c1, c2, b1, b2, d1, d2 );
        if(flag){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
    public static boolean intersection(double l1x1, double l1y1, double l1x2, double l1y2,
                                       double l2x1, double l2y1, double l2x2, double l2y2)
    {
        // 快速排斥实验 首先判断两条线段在 x 以及 y 坐标的投影是否有重合。 有一个为真，则代表两线段必不可交。
        if (Math.max(l1x1,l1x2) < Math.min(l2x1 ,l2x2)
                || Math.max(l1y1,l1y2) < Math.min(l2y1,l2y2)
                || Math.max(l2x1,l2x2) < Math.min(l1x1,l1x2)
                || Math.max(l2y1,l2y2) < Math.min(l1y1,l1y2))
        {
            return false;
        }
        // 跨立实验  如果相交则矢量叉积异号或为零，大于零则不相交
        if ((((l1x1 - l2x1) * (l2y2 - l2y1) - (l1y1 - l2y1) * (l2x2 - l2x1))
                * ((l1x2 - l2x1) * (l2y2 - l2y1) - (l1y2 - l2y1) * (l2x2 - l2x1))) > 0
                || (((l2x1 - l1x1) * (l1y2 - l1y1) - (l2y1 - l1y1) * (l1x2 - l1x1))
                * ((l2x2 - l1x1) * (l1y2 - l1y1) - (l2y2 - l1y1) * (l1x2 - l1x1))) > 0)
        {
            return false;
        }
        return true;
    }
}
