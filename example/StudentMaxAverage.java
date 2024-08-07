package org.example;

import java.util.HashMap;
import java.util.Map;

public class StudentMaxAverage {
    public static void main(String[] args) {
        // Example input
        String[][] students = {
                {"bobby", "20"},
                {"arun", "30"},
                {"bobby", "60"}
        };
        // Call the function to find the maximum average score
        //int maxAverage = findMaxAverage(students);
        // Print the result
        //System.out.println("The maximum average score is: " + maxAverage);

        int maxAverage = findMaxAverage1(students);
        System.out.println("The maximum average score is: " + maxAverage);
    }

    private static int findMaxAverage1(String[][]students){
        Map<String,int[]> studentMaxAverageMap = new HashMap<>();
        for(String[] student: students){
            String name = student[0];
            int score = Integer.parseInt(student[1]);
            System.out.println("name: "+student[0]);
            System.out.println("score: "+student[1]);
            if(!studentMaxAverageMap.containsKey(name)){
                studentMaxAverageMap.put(name,new int[]{score,1});
            }else{
                int [] scoreAndOccu = studentMaxAverageMap.get(name);
                score = score + scoreAndOccu[0];
                int occu = scoreAndOccu[1]+1;
                studentMaxAverageMap.put(name,new int[]{score,occu});
            }
        }
        double maxAvg = Double.MIN_VALUE;
        for(Map.Entry<String,int[]> studentMaxAverage: studentMaxAverageMap.entrySet()){
            int [] scoreData = studentMaxAverage.getValue();
            double avg = (double) scoreData[0]/scoreData[1];
            if(avg>maxAvg){
                maxAvg = avg;
            }
        }
        return (int)Math.floor(maxAvg);

    }

    public static int findMaxAverage(String[][] students) {
        // Create a map to store the total score and count for each student
        Map<String, int[]> scoresMap = new HashMap<>();

        // Iterate over the student records
        for (String[] student : students) {
            String name = student[0];
            int score = Integer.parseInt(student[1]);

            // Get the current total score and count for the student
            int[] scoreData = scoresMap.getOrDefault(name, new int[]{0, 0});
            scoreData[0] += score; // Add the score to total
            scoreData[1] += 1;     // Increment the count

            // Put the updated data back in the map
            scoresMap.put(name, scoreData);
        }

        // Variable to track the maximum average
        double maxAverage = Double.NEGATIVE_INFINITY;

        // Iterate over the map to compute averages and find the maximum
        for (Map.Entry<String, int[]> entry : scoresMap.entrySet()) {
            int[] scoreData = entry.getValue();
            double average = (double) scoreData[0] / scoreData[1];
            if (average > maxAverage) {
                maxAverage = average;
            }
        }

        // Return the floor value of the maximum average
        return (int) Math.floor(maxAverage);
    }
}
