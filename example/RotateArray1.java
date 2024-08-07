// https://leetcode.com/problems/rotate-array

import java.util.*; 
class RotateArray1 {
    // public void rotate(int[] nums, int rotate) {
    //     int rotateCount = 0;
    //     int len = nums.length;
    //     while (rotateCount < rotate) {
    //         int last = nums[len-1];
    //         for (int i = len-1; i >0; i--) {
    //             nums[i] = nums[i-1];
    //         }
    //         nums[0] = last;
    //         rotateCount++;
    //     }
    // }

    public void rotate(int[] numsArray, int rotate) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : numsArray) {
            nums.add(num);
        }
        System.out.println(""+nums);
        int rotateCount = 0;
        int len = nums.size();
        while (rotateCount < rotate) {
            int last = nums.get(len - 1);
            System.out.println("last: "+last);
            for (int i = len - 1; i > 0; i--) {
                nums.set(i, nums.get(i - 1));
            }
            nums.set(0, last);
            rotateCount++;
        }
        for (int i = 0; i < nums.size(); i++)
            numsArray[i] = nums.get(i);
    }
}