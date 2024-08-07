package org.example;

public class MoveKAtEnd {
    // Driver code
    public static void main(String[] args)
    {
        int []arr = { 1, 1, 3, 5, 6 };
        int K = 1;
        //int []ans = moveElementToEnd(arr, K);
        int []ans = moveElementToEnd1(arr, K);

        for(int i = 0; i < arr.length; i++)
            System.out.print(ans[i] + " ");
    }

    static int[] swap(int []arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    static int[] moveElementToEnd1(int []array,
                                  int toMove){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            if(array[low] == toMove){
                swap(array,low,high);
            }
            low++;
            high--;
        }

        return array;
    }
    static int[] moveElementToEnd(int []array,
                                  int toMove)
    {
        // Mark left pointer
        int i = 0;

        // Mark the right pointer
        int j = array.length - 1;

        // Iterate until left pointer
        // crosses the right pointer
        while (i < j)
        {
            while (i < j && array[j] == toMove)

                // Decrement right pointer
                j--;

            if (array[i] == toMove)

                // Swap the two elements
                // in the array
                swap(array, i, j);

            // Increment left pointer
            i++;
        }

        // Return the result
        return array;
    }

}
