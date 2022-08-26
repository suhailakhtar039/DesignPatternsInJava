package com.example.helloworld.practice;

import java.math.BigDecimal;
import java.util.*;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        int[] a1 = findPerm(a, b);
        for(int i:a1)
            System.out.println(i);
    }
}
