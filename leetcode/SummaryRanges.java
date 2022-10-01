package com.example.demo.leetcode;

import java.util.*;

/**
 * 352. 将数据流变为多个不相交区间
 * */
public class SummaryRanges {
    private final TreeSet<Integer> sortedSet;
    private final TreeMap<Integer,int[]> map = new TreeMap<>();


    public SummaryRanges() {
        this.sortedSet = new TreeSet<>();
    }

    public void addNum(int val) {
        if(!sortedSet.add(val)){
            return;
        }

        Integer low = map.floorKey(val);
        Integer high = map.higherKey(val);

        if(low == null && high == null){
            map.put(val, new int[]{val,val});
            return;
        }
        if(low == null){
            int[] tem = map.get(high);
            if(tem[0] == val + 1){
                map.remove(high);
                map.put(val, new int[]{val,tem[1]});
            }else {
                map.put(val, new int[]{val,val});
            }
            return;
        }
        if(high == null){
            int[] tem = map.get(low);
            if(tem[1] == val - 1){
                map.get(low)[1] = val;
            }else {
                map.put(val, new int[]{val,val});
            }
            return;
        }

        if(val - 1 == map.get(low)[1] && map.get(high)[0] ==  val + 1){
            map.get(low)[1] = map.get(high)[1];
            map.remove(high);
            return;
        }

        if(val - 1 == map.get(low)[1]){
            map.get(low)[1] = val;
            return;
        }

        if(map.get(high)[0] ==  val + 1){
            map.put(val, new int[]{val,map.get(high)[1]});
            map.remove(high);
            return;
        }
        map.put(val, new int[]{val,val});

    }

    public int[][] getIntervals() {
//        Iterator<Integer> iterator = sortedSet.iterator();
//        int start = iterator.next();
//        int left = start;
//        List<int[]> list = new ArrayList<>();
//        while(iterator.hasNext()){
//            int h = iterator.next();
//            if(h-left==1){
//                left = h;
//            }else {
//                list.add(new int[]{start,left});
//                start = left = h;
//            }
//        }
//        list.add(new int[]{start,left});

        return new ArrayList<>(map.values()).toArray(new int[0][]);
    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(1);
        s.addNum(7);
        s.addNum(3);
        s.addNum(9);
        s.addNum(10);
        s.addNum(11);
        System.out.println(Arrays.deepToString(s.getIntervals()));
    }
}
