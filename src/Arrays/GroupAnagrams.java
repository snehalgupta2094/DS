package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        //Step1: sort each word
        String strs[]={"eat","tea","tan","ate","nat","bat"};
        HashMap<String, ArrayList<String>> groupAnagramsMap=new HashMap<>();
        for(String anagram: strs){
            char[] anagramArray=anagram.toCharArray();
            Arrays.sort(anagramArray);
            System.out.println(String.valueOf(anagramArray));
            ArrayList<String> group=groupAnagramsMap.getOrDefault(String.valueOf(anagramArray),new ArrayList<>());
            group.add(anagram);
            groupAnagramsMap.put(String.valueOf(anagramArray),group);
        }
        for (Map.Entry<String, ArrayList<String>> entry : groupAnagramsMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
