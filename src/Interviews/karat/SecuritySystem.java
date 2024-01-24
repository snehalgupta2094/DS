package Interviews.karat;
/*

We are working on a security system for a badged-access room in our company's building.
Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

records1 = [
["Paul", "enter"],
["Pauline", "exit"],
["Paul", "enter"],
["Paul", "exit"],
["Martha", "exit"],
["Joe", "enter"],
["Martha", "enter"],
["Steve", "enter"],
["Martha", "exit"],
["Jennifer", "enter"],
["Joe", "enter"],
["Curtis", "exit"],
["Curtis", "enter"],
["Joe", "exit"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "exit"],
["Joe", "enter"],
["Joe", "enter"],
["Martha", "exit"],
["Joe", "exit"],
["Joe", "exit"]
]
ENTER W/O EXIT EXIT W/O ENTER
Expected output: ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]

Other test cases:

records2 = [
["Paul", "enter"],
["Paul", "exit"],
]

Expected output: [], []

records3 = [
["Paul", "enter"],
["Paul", "enter"],
["Paul", "exit"],
["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

records4 = [
["Raj", "enter"],
["Paul", "enter"],
["Paul", "exit"],
["Paul", "exit"],
["Paul", "enter"],
["Raj", "enter"],
]

Expected output: ["Raj", "Paul"], ["Paul"]

All Test Cases:
mismatches(records1) => ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
mismatches(records2) => [], []
mismatches(records3) => ["Paul"], ["Paul"]
mismatches(records4) => ["Raj", "Paul"], ["Paul"]

n: length of the badge records array

*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecuritySystem {
    public static final String ENTER = "enter";
    public static final String EXIT = "exit";
    public static void main(String[] argv) {
        String[][] records1 = {
                {"Paul", "enter"}, //no issue
                {"Pauline", "exit"}, // issue, means she entered the room w/o using badge, exit w/o enter
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"},
                };
        fetchBadgedEmployees(records1);

        String[][] records2 = {
                {"Paul", "enter"},
                {"Paul", "exit"},
                };
        fetchBadgedEmployees(records2);

        String[][] records3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                };
        fetchBadgedEmployees(records3);

        String[][] records4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
                };
        fetchBadgedEmployees(records4);
    }

    public static void fetchBadgedEmployees(String[][] records){
        Map<String, String> recordMap = new HashMap<>();
        Set<String> entries = new HashSet<>();
        Set<String> exits = new HashSet<>();
        for(int recordIndex = 0; recordIndex < records.length; recordIndex++){
            String name = records[recordIndex][0];
            String badgeAction = records[recordIndex][1];
            String previousRecord = recordMap.get(name);

            if(previousRecord != null){
                if(previousRecord.equals(badgeAction)){
                    switch (badgeAction){
                        case "enter":
                            entries.add(name);
                            break;
                        case "exit":
                            exits.add(name);
                            break;
                    }
                }
            }
            else if(badgeAction.equals("exit")){
                exits.add(name);
            }

            recordMap.put(name, badgeAction);
        }

        Set<Map.Entry<String, String>> recordSet = recordMap.entrySet();

        for(Map.Entry<String, String> record : recordSet){
            if(record.getValue().equals("enter")){
                entries.add(record.getKey());
            }
        }

        System.out.println(entries);
        System.out.println(exits);
    }
}

//