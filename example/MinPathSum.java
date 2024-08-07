package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int matrix[][] = {
                {10, 8, 2},
                {10, 5, 100},
                {1, 1, 2}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int minPathSum = findMinPathSum(rows,cols,matrix);
        System.out.println("minPathSum: "+minPathSum);
    }

    /* This method will be used to create DP matrix and initialize it, call Util function
    * */
    private static int findMinPathSum(int rows, int cols, int[][] matrix) {
        int [][] dp = new int [rows][cols];

        for(int []row :dp){
            Arrays.fill(row,-1);
        }

        return findMinPathSumUtil(rows-1,cols-1,matrix,dp);
    }

    private static int findMinPathSumUtil(int row, int column, int[][] matrix, int[][] dp) {
        if(row ==0 && column ==0){
            return matrix[0][0];
        }
        if(row<0 || column<0){
            return (int)Math.pow(10,9); // out of boundry, return max value;
        }
        if(dp[row][column] != -1){
            return dp[row][column]; // return already calculated value
        }
        // don't forget current value matrix[row][column], added with up and left

         int up = matrix[row][column]+findMinPathSumUtil(row-1,column,matrix,dp);
         int left = matrix[row][column]+findMinPathSumUtil(row,column-1, matrix,dp);
        System.out.println("Up... "+up+" Left: "+left);
         return dp[row][column] = Math.min(up, left);
    }
}
