package org.example;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

class PriorityQueueExample {
    // Method to find median
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int i;
        int n = nums1.length;
        int m = nums2.length;
        // initializing Priority Queue (Min Heap)
        PriorityQueue<Integer> pq
                = new PriorityQueue<Integer>();
        System.out.println("Comparator: "+pq.comparator());
        // pushing array A values to priority Queue
        for (i = 0; i < n; i++) {
            pq.add(Integer.valueOf(nums1[i]));
        }
        // pushing array B values to priority Queue
        for (i = 0; i < m; i++) {
            pq.add(Integer.valueOf(nums2[i]));
        }
        int check = n + m;
        double count = -1;
        double mid1 = -1, mid2 = -1;
        while (!pq.isEmpty()) {
            count++;
            // returning mid value if combined length(n+m)
            // is odd
            if (check % 2 != 0 && count == check / 2) {
                double ans = pq.peek();
                return ans;
            }
            // maintaining mid1 value if combined
            // length(n+m) is even where we need to maintain
            // both mid values in case of even combined
            // length
            if (check % 2 == 0
                    && count == (check / 2) - 1) {
                mid1 = pq.peek();
            }
            // now returning the mid2 value with previous
            // maintained mid1 value by 2
            if (check % 2 == 0 && count == check / 2) {
                mid2 = pq.peek();
                double ans = (mid1 + mid2) / 2;
                return ans;
            }
            pq.poll();

        }
        return 0.00000;
    }

    public static void main(String[] args)
    {
        int [] arr1 = new int[]{1,3};
        int [] arr2 = new int[]{1,3};
        System.out.println("Median of the two arrays are");
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
