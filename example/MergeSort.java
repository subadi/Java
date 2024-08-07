package org.example;

import java.util.ArrayList;
import java.util.List;

// Median of two sorted arrays of same size
class MergeSort{

    public static void main(String[]args){
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        int len = arr.length;
        System.out.println("before sorting: ");
        for(int i=0;i<len;i++){
            System.out.print(" "+arr[i]);
        }
        mergeSort(arr,0,len-1);
        System.out.print("\nAfter sorting: ");
        for(int i=0;i<len;i++){
            System.out.print(" "+arr[i]);
        }
    }

    private static void mergeSort(int [] arr,int low ,int high){
        //base condition : by repeteadly divinding array in half, at last only one element remains, and therefore, low,high and mid are all same
        if(low>=high)
            return;

        int mid = (low+high)/2;
        // Sort, 2 halves repeateldy
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);

        // after sorting merge them into one array
        merge(arr,low,mid,high);

    }

    private static void merge(int [] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>(); // this to to store(merge) elements from both the halves
        int left = low; // start of left half
        int right = mid+1; // start of right half

        // now, take 2 pointer left and right each for respective half
        while(left <=mid && right<=high){
            if(arr[left]<=arr[right]){ // comparing, i.e sorting
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]); // comparing i.e sorting
                right++;
            }
        }
        // after this, there might be elements left in either left or right array, depending upon whether the input array was already sorted asceding or descending

        // for remianign elements in left array
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        // for remianign elements in left array
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        System.out.println("Low is: "+low+" elm: "+arr[low]);
        System.out.println("High is: "+high+" elm: "+arr[high]);
        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}