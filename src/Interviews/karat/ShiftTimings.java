package Interviews.karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* We want to find employees who badged into our secured room unusually often.
* We have an unordered list of names and entry times over a single day.
* Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period.
* Your function should return each of the employees who fit that criteria,
* plus the times that they badged in during the one-hour period.
* If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
["Paul", "1355"], ["Jennifer", "1910"], ["Jose", "835"],
["Jose", "830"], ["Paul", "1315"], ["Chloe", "0"],
["Chloe", "1910"], ["Jose", "1615"], ["Jose", "1640"],
["Paul", "1405"], ["Jose", "855"], ["Jose", "930"],
["Jose", "915"], ["Jose", "730"], ["Jose", "940"],
["Jennifer", "1335"], ["Jennifer", "730"], ["Jose", "1630"],
["Jennifer", "5"], ["Chloe", "1909"], ["Zhang", "1"],
["Zhang", "10"], ["Zhang", "109"], ["Zhang", "110"],
["Amos", "1"], ["Amos", "2"], ["Amos", "400"],
["Amos", "500"], ["Amos", "503"], ["Amos", "504"],
["Amos", "601"], ["Amos", "602"], ["Paul", "1416"],
];
* */
class FrequentEntries{

    class Time implements Comparable<Time> {
        int hh;
        int mm;
        String originalTime;
        Time(int hh, int mm, String originalTime){
            this.hh = hh;
            this.mm = mm;
            this.originalTime = originalTime;
        }

        @Override
        public int compareTo(Time other) {
            int hourComparison = Integer.compare(this.hh,other.hh);

            if(hourComparison == 0){
                return Integer.compare(this.mm, other.mm);
            }
            return hourComparison;
        }

        @Override
        public String toString(){
            return hh+"hr "+mm;
        }
    }

    public Map<String, List<Time>> createMap(String[][] badgeTimes){
        Map<String, List<Time>> badgeTimesMap = new HashMap<>();

        for(int entry = 0; entry < badgeTimes.length; entry++){
            String name = badgeTimes[entry][0];
            Time timestamp = formatTimeStamp(badgeTimes[entry][1]);

            List<Time> times = badgeTimesMap.getOrDefault(name, new ArrayList<>());
            times.add(timestamp);
            badgeTimesMap.put(name, times);
        }
        return badgeTimesMap;
    }

    private Time formatTimeStamp(String timestamp) {
        int length = timestamp.length();

        switch (length){
            case 1:
            case 2:
                return new Time(0, Integer.parseInt(timestamp), timestamp);
            case 3:
                int mm = Integer.parseInt(timestamp.substring(1,3));
                int hh = Integer.parseInt(timestamp.substring(0,1));
                return new Time(hh, mm, timestamp);
            case 4:
                mm = Integer.parseInt(timestamp.substring(2,4));
                hh = Integer.parseInt(timestamp.substring(0,2));
                return new Time(hh, mm, timestamp);
        }
        return null;
    }


    public void findFrequentEntries(Map<String, List<Time>> badgeTimesMap){
        Set<Map.Entry<String, List<Time>>> entries = badgeTimesMap.entrySet();
        Map<String, List<String>> outputMap = new HashMap<>();

        for(Map.Entry<String,List<Time>> entry: entries) {
            List<String> output = new ArrayList<>();
            List<Time> timestamps = entry.getValue();
            Collections.sort(timestamps);
            int start = 0;
            int end = 0;

            while ( end < timestamps.size()) {
                Time startTime = timestamps.get(start);
                Time endTime = timestamps.get(end);
                int startTimeInMinutes = (startTime.hh * 60) + startTime.mm;
                int endTimeInMinutes = (endTime.hh * 60) + endTime.mm;

                if(endTimeInMinutes - startTimeInMinutes  <= 60){
                    output.add(endTime.originalTime);
                    end++;
                }
                else {
                    if (output.size() >= 3){
                        outputMap.putIfAbsent(entry.getKey(),output);
                        break;
                    }
                    output.remove(startTime.originalTime);
                    start++;
                }
            }
            if (output.size() >= 3){
                outputMap.putIfAbsent(entry.getKey(),output);
            }
        }
        System.out.println(outputMap);
    }
}

public class ShiftTimings {

    public static void main(String[] args) {
        String[][] badgeTimes = {
                {"Paul", "1355"}, {"Jennifer", "1910"}, {"Jose", "835"},
                {"Jose", "830"}, {"Paul", "1315"}, {"Chloe", "0"},
                {"Chloe", "1910"}, {"Jose", "1615"}, {"Jose", "1640"},
                {"Paul", "1405"}, {"Jose", "855"}, {"Jose", "930"},
                {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"},
                {"Jennifer", "1335"}, {"Jennifer", "730"}, {"Jose", "1630"},
                {"Jennifer", "5"}, {"Chloe", "1909"}, {"Zhang", "1"},
                {"Zhang", "10"}, {"Zhang", "109"}, {"Zhang", "110"},
                {"Amos", "1"}, {"Amos", "2"}, {"Amos", "400"},
                {"Amos", "500"}, {"Amos", "503"}, {"Amos", "504"},
                {"Amos", "601"}, {"Amos", "602"}, {"Paul", "1416"}
        };

        FrequentEntries entries = new FrequentEntries();
        Map<String, List<FrequentEntries.Time>> badgeTimesMap = entries.createMap(badgeTimes);
        entries.findFrequentEntries(badgeTimesMap);
    }
}
