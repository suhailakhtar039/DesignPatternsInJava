package com.example.helloworld.practice;

import java.math.BigDecimal;
import java.util.*;
class Employee1{
    int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return a == employee1.a;
    }

}
public class Practice {
    public static int[] findPerm(int A, long B) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= A; i++)
            arrayList.add(i);
        B--;
        while (B-- > 0) {
            nextPermutation(arrayList);
        }
        int[] a = new int[A];
        for (int i = 0; i < A; i++)
            a[i] = arrayList.get(i);
        return a;
    }

    private static void nextPermutation(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arrayList.get(i) < arrayList.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int swapped = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arrayList.get(i) > arrayList.get(pivot)) {
                swapped = i;
                break;
            }
        }
        Collections.swap(arrayList, pivot, swapped);
        for (int i = pivot + 1, j = n - 1; i <= j; i++, j--) {
            Collections.swap(arrayList, i, j);
        }
    }

    public static void change(Employee1 e1){
        e1.a = 5;
    }
    public static void main(String[] args) {
        Employee1 e1 = new Employee1();
        e1.a = 1;
        Employee1 e2 = new Employee1();
        e2.a = 1;
        if(e1.equals(e2))
            System.out.println("equals");
        else{
            System.out.println(e1.hashCode());
            System.out.println(e2.hashCode());
        }
        change(e1);
        System.out.println(e1.a);
    }
}
