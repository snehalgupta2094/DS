package Greedy;

import java.util.*;
//activity selection problem
public class NMeetingsRoom {

    static class Pair<K,V>{
        K first;
        V second;
        Pair(K first, V second){
            this.first=first;
            this.second=second;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int count=1;
        // add your code here
        ArrayList<Pair<Integer,Integer>> intervals=new ArrayList<>();
        for(int i=0;i<n;i++){
            intervals.add(new Pair(start[i],end[i]));
        }
        Collections.sort(intervals, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.second.compareTo(o2.second);
            }
        });

        int prevEnd=intervals.get(0).second;
        for(int i=1;i<n;i++){
            if(intervals.get(i).first>prevEnd){
                count++;
                prevEnd=intervals.get(i).second;
            }
        }
        return count;
    }
}
