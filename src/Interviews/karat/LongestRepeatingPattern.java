package Interviews.karat;

import java.util.ArrayList;
import java.util.List;

/*Two patterns are given, one for each user. Find the longest repeating pattern for both users.

User1: ["hi", "bye", "hello", "leetcode", "start", "end"]
User2: ["hi", "stop", "leetcode", "start", "end", "bye"]

Output: ["leetcode", "start", "end"]
* */
public class LongestRepeatingPattern {

    static List<String> outputList = new ArrayList<>();
    public static void main(String[] args) {
        //String[] User1 = {"hi", "bye", "hello", "leetcode", "start", "end"};
        //String[] User2 = {"hi", "stop", "leetcode", "start", "end", "bye"};

        String[] User1 = {"hi", "stop","bye", "hello", "leetcode", "start", "end", "snehal"};
        String[] User2 = {"hi", "stop", "bye", "snehal","leetcode","abc", "start", "end", "bye"};

        int[] maxLength = new int[1];
        findLongestPattern(0, 0 ,User1, User2, new ArrayList<>(), maxLength);

        System.out.println(maxLength[0]);
        System.out.println(outputList);
    }

    public static int findLongestPattern(int i, int j, String[] User1, String[] User2, List<String> temp, int[] maxLength){
        if(i >= User1.length || j >= User2.length){
            return 0;
        }

        int length = 0;
        if(User1[i].equals(User2[j])){
            temp.add(User1[i]);
            length = findLongestPattern(i + 1, j + 1, User1, User2, temp, maxLength) + 1;
            if(length > maxLength[0]){
                maxLength[0] = length;
                outputList = temp;
            }
        }

        findLongestPattern(i + 1, j , User1, User2, new ArrayList<>(), maxLength);
        findLongestPattern(i , j + 1, User1, User2, new ArrayList<>(), maxLength);
        return length;
    }



}
