package com.example.helloworld;

import java.util.*;

class Comp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1%10 > o2%10)
            return 1;
        return -1;
    }
}

public class CollectionsExample {
    public static void main(String[] args) {
//        It was for Array list

//        ArrayList<Integer> l1 = new ArrayList<>(5);
//        for(int i=0; i<10; i++)
//            l1.add(i+1);
//        Iterator<Integer> iterator = l1.iterator();
////        for(int i=0; i<l1.size(); i++)
////            System.out.println(l1.get(i));
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        Object[] a = l1.toArray();
//        for(Object i:a)
//            System.out.println(i);

//        =====================Linked list========
//        LinkedList<Integer> l1 = new LinkedList<Integer>();
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        hashMap.put(10,20);
//        hashMap.put(5,20);
//        hashMap.put(0,20);
//        hashMap.put(1,20);
//        for(Map.Entry<Integer,Integer> m: hashMap.entrySet()){
//            System.out.println(m.getKey()+" : "+m.getValue());
//        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(24);
        arrayList.add(245);
        arrayList.add(244);
        arrayList.add(249);
        arrayList.add(241);
        arrayList.add(243);
        Comp comp = new Comp();
        Collections.sort(arrayList,comp);
        for(int i:arrayList){
            System.out.println(i);
        }
    }
}
