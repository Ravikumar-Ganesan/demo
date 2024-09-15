package com.example.demo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    //Convert the array to a list, reverse the list, and then convert it back to an array
    public static void collectionReverseArray(int[] arr) {
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    //Convert the array to a list, reverse the list, and then copy the reversed list back to the array
    public static void collectionReverseArrayCopy(int[] arr) {
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int[] reversedArray = list.stream().mapToInt(Integer::intValue).toArray();
        System.arraycopy(reversedArray, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 20, 30, 40, 50, 60};

        System.out.println("Original arr1: " + Arrays.toString(arr1));
        collectionReverseArrayCopy(arr1);
        System.out.println("Reversed arr1: " + Arrays.toString(arr1));

        System.out.println("Original arr2: " + Arrays.toString(arr2));
        reverseArray(arr2);
        System.out.println("Reversed arr2: " + Arrays.toString(arr2));

    }
}