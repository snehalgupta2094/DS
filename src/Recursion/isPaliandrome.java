package Recursion;

import java.util.Locale;

public class isPaliandrome {
    public static boolean isValidPaliandrome(String s, int i, int j){
        //base condition
        if(i>j)
            return true;

        if(s.charAt(i)!=s.charAt(j))
            return false;
        else
            return isValidPaliandrome(s,i+1,j-1);
    }
    public static void main(String[] args) {
        String s="abba";
        System.out.println(isValidPaliandrome(s,0,s.length()-1));
    }
}
