package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class VendingMachine {
    private HashMap<String, PriorityQueue<int[]>[]> queue = new HashMap<>();
    private HashMap<String, Integer> map = new HashMap<>();
    private HashMap<String, Integer> count = new HashMap<>();

    public void addItem(int time, int number, String item, int price, int duration) {
        int[] e = { time + duration, price, number };
        queue.computeIfAbsent(item, t -> new PriorityQueue[] { new PriorityQueue<int[]>((o, p) -> o[0] - p[0]),
                new PriorityQueue<int[]>((o, p) -> o[1] == p[1] ? o[0] - p[0] : o[1] - p[1]) })[0].offer(e);
        queue.get(item)[1].offer(e);
        map.put(item, map.getOrDefault(item, 0) + number);
    }

    public long sell(int time, String customer, String item, int number) {
        while (!queue.getOrDefault(item, new PriorityQueue[] { new PriorityQueue<>() })[0].isEmpty()
                && queue.get(item)[0].peek()[0] < time) {
            map.put(item, map.get(item) - queue.get(item)[0].poll()[2]);
        }
        if (map.getOrDefault(item, 0) < number) {
            return -1;
        }
        long sum = 0;
        while (number > 0) {
            if (queue.get(item)[1].peek()[0] < time) {
                queue.get(item)[1].poll();
            } else {
                int num = Math.min(number, queue.get(item)[1].peek()[2]);
                map.put(item, map.get(item) - num);
                sum += queue.get(item)[1].peek()[1] * (long) num;
                number -= num;
                if ((queue.get(item)[1].peek()[2] -= num) == 0) {
                    queue.get(item)[1].poll();
                }
            }
        }
        count.put(customer, count.getOrDefault(customer, 0) + 1);
        return (sum * Math.max(70, (101 - count.get(customer))) + 99) / 100;
    }

//    Map<String,Integer> mapC;
//    Map<String, PriorityQueue<int[]>[]> mapP;
//    Map<String,Integer> mapCount;
//    public VendingMachine() {
//        mapC = new HashMap<>();
//        mapP = new HashMap<>();
//        mapCount = new HashMap<>();
//    }
//
//    public void addItem(int time, int number, String item, int price, int duration) {
//        var t = new int[]{price, time+duration, number};
//        PriorityQueue<int[]>[] p = mapP.getOrDefault(item, new PriorityQueue[]{ new PriorityQueue<int[]>(),
//                new PriorityQueue<int[]>((a,b)->{
//                    if(a[0]==b[0]){
//                        return a[1]-b[1];
//                    }else{
//                        return a[0]-b[0];
//                    }
//                })});
//        p[0].add(t);
//        p[1].add(t);
//        mapP.put(item,p);
//        mapCount.put(item, mapCount.getOrDefault(item, 0)+ number);
//
//    }
//
//    public long sell(int time, String customer, String item, int number) {
//        int dis = mapC.getOrDefault(customer,100);
//
//        while( !mapP.getOrDefault(item, new PriorityQueue[]{ new PriorityQueue<>()})[0].isEmpty()
//                && mapP.get(item)[0].peek()[1]<time ){
//            mapCount.put(item ,mapCount.get(item)- mapP.get(item)[0].poll()[2] );
//        }
//
//        if(mapCount.get(item)<0){
//            return -1;
//        }
//        long sum = 0;
//        PriorityQueue<int[]>[] p = mapP.get(item);
//        while ( number>0){
//            if(p[1].peek()[1]<time){
//                p[1].poll();
//            }
//            int[] poll = p[1].poll();
//            if(number<poll[2]){
//                sum += (long) poll[0] * number ;
//                poll[2] = poll[2]- number;
//                p[1].add(poll);
//
//                number= 0 ;
//            }else{
//                sum += (long) poll[0] * poll[2];
//                number -= poll[2];
//            }
//        }
//        mapP.put(item,p);
//        mapCount.put(item,  mapCount.get(item)- number);
//
//
//        mapC.put(customer,dis-1);
//        return (sum+99)*dis/100;
//
//    }
}
