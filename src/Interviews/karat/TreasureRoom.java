package Interviews.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
You are with your friends in a castle, where there are multiple rooms named after flowers. Some of the rooms contain treasures - we call them the treasure rooms.
        Each room contains a single instruction that tells the player which room to go to next.

        *** instructions_1 ***

        lily -------- daisy sunflower

        | | |

        v v v

        jasmin -> tulip violet -> rose --->

        ^ | ^ ^ |

        | | | | |

        ----- iris -----

        *** instructions_2 ***

        lily --------

        |

        v
        jasmin -> tulip -- > violet

        Write a function that takes two parameters as input:

        * a list containing the treasure rooms, and
        * a list of instructions represented as pairs of (source_room, destination_room)

        Returns a collection of all the rooms that satisfy the following two conditions:

        * at least two *other* rooms have instructions pointing to this room
        * this room's instruction immediately leads to a treasure room

        Examples
        instructions_1 = [
        ["jasmin", "tulip"],
        ["lily", "tulip"],
        ["tulip", "tulip"],
        ["rose", "rose"],
        ["violet", "rose"],
        ["sunflower", "violet"],
        ["daisy", "violet"],
        ["iris", "violet"]
        ]
        treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]
        treasure_rooms_2 = ["lily", "jasmin", "violet"]
        instructions_2 = [
        ["jasmin", "tulip"],
        ["lily", "tulip"],
        ["tulip", "violet"],
        ["violet", "violet"]
        ]
        treasure_rooms_3 = ["violet"]

        filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
        * tulip can be accessed from rooms lily and jasmin. Tulip's instruction leads to a treasure room (tulip itself)
        * violet can be accessed from daisy, sunflower and iris. Violet's instruction leads to a treasure room (rose)

        filter_rooms(treasure_rooms_2, instructions_1) => []
        * none of the rooms reachable from tulip or violet are treasure rooms

        filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
        * tulip can be accessed from rooms lily and jasmin. Tulip's instruction leads to a treasure room (violet)

        All the test cases:

        filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
        filter_rooms(treasure_rooms_2, instructions_1) => []
        filter_rooms(treasure_rooms_3, instructions_2) => [tulip]

        Complexity Analysis variables:
        N: treasure rooms
        P: instructions
**/


public class TreasureRoom {

    public static void main(String[] args) {
        String[][] instructions_1 = {{"jasmin", "tulip"},
                                    {"lily", "tulip"},
                                    {"tulip", "tulip"},
                                    {"rose", "rose"},
                                    {"violet", "rose"},
                                    {"sunflower", "violet"},
                                    {"daisy", "violet"},
                                    {"iris", "violet"}};
        String[] treasure_rooms_1 = {"lily", "tulip", "violet", "rose"};
        String[] treasure_rooms_2 = {"lily", "jasmin", "violet"};
        String[][] instructions_2 = {{"jasmin", "tulip"},
                                     {"lily", "tulip"},
                                     {"tulip", "violet"},
                                     {"violet", "violet"}};
        String[] treasure_rooms_3 = {"violet"};

        Set<String> filteredRooms = filterRoomsOnDestination(instructions_1);
        List<String> filteredRoomList = filterRoomsOnSource(instructions_1, treasure_rooms_1, filteredRooms);
        System.out.println(filteredRoomList);

        filteredRooms = filterRoomsOnDestination(instructions_1);
        filteredRoomList = filterRoomsOnSource(instructions_1, treasure_rooms_2, filteredRooms);
        System.out.println(filteredRoomList);

        filteredRooms = filterRoomsOnDestination(instructions_2);
        filteredRoomList = filterRoomsOnSource(instructions_2, treasure_rooms_3, filteredRooms);
        System.out.println(filteredRoomList);
    }

    public static Set<String> filterRoomsOnDestination(String[][] instructions){
        Set<String> filteredRooms = new HashSet<>();
        Map<String, List<String>> roomMap = new HashMap<>();

        for(int index = 0; index < instructions.length; index++){
            String sourceRoom = instructions[index][0];
            String destinationRoom = instructions[index][1];

            if(!sourceRoom.equals(destinationRoom)){
                List<String> sourceRooms = roomMap.getOrDefault(destinationRoom, new ArrayList<>());
                sourceRooms.add(sourceRoom);
                roomMap.put(destinationRoom, sourceRooms);
            }
        }

        Set<Map.Entry<String, List<String>>> entries = roomMap.entrySet();
        for(Map.Entry<String, List<String>> entry : entries){
            List<String> sourceRooms = entry.getValue();

            if(sourceRooms.size() >= 2){
                filteredRooms.add(entry.getKey());
            }
        }
        return filteredRooms;
    }

    public static List<String> filterRoomsOnSource(String[][] instructions, String[] treasure_rooms, Set<String> filteredRooms){
        List<String> filteredRoomList = new ArrayList<>();
        Set<String> treasureRooms = new HashSet<>();

        for(String treasureRoom : treasure_rooms){
            treasureRooms.add(treasureRoom);
        }

        for(int index = 0; index < instructions.length; index++){
            String sourceRoom = instructions[index][0];
            String destinationRoom = instructions[index][1];

            if(filteredRooms.contains(sourceRoom) && treasureRooms.contains(destinationRoom)){
                filteredRoomList.add(sourceRoom);
            }
        }
        return filteredRoomList;
    }
}
