package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Simple Logic - After sorting, if starttime is less(e.g 5 min) than endTime(e.g 10Min)
* then we will need new room*/
public class MeetingRooms2 {
    public static void main(String[] args) {
        int [][] intervals = new int[][]{{0, 30},{5, 10},{15, 20}};
        int [][] intervals1 = new int[][]{{7, 10},{2,4}};
        List<Integer> startTimeList = new ArrayList<>();
        List<Integer> endTimeList = new ArrayList<>();
        for(int[] interval : intervals1){
            int start = interval[0];
            int end = interval[1];
            startTimeList.add(start);
            endTimeList.add(end);
        }
        Collections.sort(startTimeList);
        Collections.sort(endTimeList);
        int rooms=0;
        for(int startTime : startTimeList){
            int endTime = endTimeList.get(0);
            if(endTime<= startTime){
                endTimeList.remove(0);
            }else{
                rooms++;
            }
        }
       System.out.println("rooms: "+rooms);
    }
}
