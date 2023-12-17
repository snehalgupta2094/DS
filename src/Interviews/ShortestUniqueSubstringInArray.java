package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/*
Find shortest unique substring for each string in array and append <u></u>
Eg. input={"Bird","Cat","Cow","Dog","Wallaby"}
output={"B<u>i</u>rd","Ca<u>t</u>","<u>Co</u>w","Do<u>g</u>","Wa<u>l</u>laby"}
 */
public class ShortestUniqueSubstringInArray {
    public static void main(String[] args) {
        List<String> input= Arrays.asList("Bird", "Cat", "Cow", "Dog", "Wallaby");
        List<String> output=shortestUniqueSubstring(input);
        System.out.println(output);
    }
    public static List<String> shortestUniqueSubstring(List<String> input) {
        List<String> output = new ArrayList<>();

        Map<String,Integer> allPossibleSubstringsCount=new HashMap<>();
        for (String word : input) {
            String lowerCaseWord = word.toLowerCase();
            HashSet<String> possibleSubstrings = findAllPossibleSubstrings(lowerCaseWord);
            for(String substring: possibleSubstrings) {
                allPossibleSubstringsCount.put(substring, allPossibleSubstringsCount.getOrDefault(substring,0)+1);
            }
        }

        for (String word : input) {
          String outputString=findShortestUniqueSubstring(word,allPossibleSubstringsCount);
          outputString=word.replaceFirst(outputString,"<u>"+outputString+"</u>");
          output.add(outputString);
        }

        return output;
    }
    private static HashSet<String> findAllPossibleSubstrings(String word){
        HashSet<String> subStrings=new HashSet<>();
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
    private static String findShortestUniqueSubstring(String word, Map<String,Integer> uniqueSubstrings){
        String shortestSubstring=word;
        for(int start=0;start<word.length();start++) {
            String subString = "";
            for (int index = start; index < word.length(); index++) {
                subString=subString+word.charAt(index);
                if(!subString.isEmpty() && uniqueSubstrings.containsKey(subString.toLowerCase())
                   && uniqueSubstrings.get(subString.toLowerCase()) == 1 && shortestSubstring.length()>subString.length()) {
                    shortestSubstring=subString;
                }
            }
        }
        return shortestSubstring;
    }
}
