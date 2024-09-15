package com.example.demo.algorithm;

import java.util.PriorityQueue;

public class KthLargestFinder {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestFinder finder = new KthLargestFinder();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = finder.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result); // Expected output: 5
    }
}