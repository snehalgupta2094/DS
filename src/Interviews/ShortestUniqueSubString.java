package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/*
Find shortest unique substring for each array in string and append <u></u>
Eg. input={"Bird","Cat","Cow","Dog","Wallaby"}
output={"B<u>i</u>rd","Ca<u>t</u>","<u>Co</u>w","Do<u>g</u>","Wa<u>l</u>laby"}
 */
public class ShortestUniqueSubString {

    public static void main(String[] args) {
        List<String> input=Arrays.asList("Bird","Cat","Cow","Dog","Wallaby");
        shortestUniqueSubstring(input);
    }
    public static List<String> shortestUniqueSubstring(List<String> input){
        List<String> output=new ArrayList<>();

        List<String> allPossibleSubstrings=new ArrayList<>();
        for(String word: input) {
            String lowerCaseWord=word.toLowerCase();
            List<String> possibleSubstrings=findAllPossibleSubstrings(lowerCaseWord);
            allPossibleSubstrings.addAll(possibleSubstrings);
        }

        Map<String,Integer> allPossibleSubstringsCount=new HashMap<>();
        for(String substring: allPossibleSubstrings) {
            allPossibleSubstringsCount.put(substring, allPossibleSubstringsCount.getOrDefault(substring,0)+1);
        }
        Set<Map.Entry<String,Integer>> entries=allPossibleSubstringsCount.entrySet();
        for(Map.Entry<String,Integer> entry: entries){
            if(entry.getValue()==1){
                System.out.println(entry.getKey());
            }
        }
        return output;
    }
    public static List<String> findAllPossibleSubstrings(String word){
        List<String> subStrings=new ArrayList<>();
        for(int start=0;start<word.length();start++){
            String subString="";
            for(int index=start;index<word.length();index++){
                subString=subString+word.charAt(index);
                if(!word.equals(subString)){
                    subStrings.add(subString);
                }
            }
        }
        return subStrings;
    }
}
