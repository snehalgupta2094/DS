package Interviews.karat;
/*String[] words = {"cat", dada", breath" , "taking", "doll"}
String pattern = "drctkla"
String pattern = "rdatlbohe"

Answer - cat
Answer - breath

There is a list of words given to you and a string pattern.
Find the word in the pattern.
Letters can be in any order.


* */
public class WordInPattern {

    public static void main(String[] args) {
     String[] words = {"cat", "dada", "breath" , "taking", "doll"};
     String pattern1 = "drctkla";
     String pattern2 = "rdatlbohe";

     String output1 = findWordInPattern(words, pattern1);
     String output2 = findWordInPattern(words, pattern2);

     System.out.println(output1);
     System.out.println(output2);
    }

    public static String findWordInPattern(String[] words, String pattern){
        int[] patternArray = new int[26];

        for(int index = 0; index < pattern.length(); index++){
            patternArray[pattern.charAt(index) - 'a']++;
        }

        for(String word : words){
            if(isValid(word, patternArray)){
                return word;
            }
        }
        return "";
    }

    public static boolean isValid(String word, int[] patternArray){
        int[] wordArray = new int[26];


        for(int index = 0 ;index < word.length(); index++){
            int wordIndex = word.charAt(index) - 'a';
            wordArray[wordIndex]++;

            if(patternArray[wordIndex] < wordArray[wordIndex]) {
                return false;
            }
        }
        return true;
    }
}
