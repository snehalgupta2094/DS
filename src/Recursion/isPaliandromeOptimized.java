package Recursion;

public class isPaliandromeOptimized {
    public static boolean isValidPaliandrome(String s, int i){
        int j=s.length()-1-i;
        //base condition
        if(i>j)
            return true;

        if(s.charAt(i)!=s.charAt(j))
            return false;
        else
            return isValidPaliandrome(s,i+1);
    }
    public static void main(String[] args) {
        String s="aaabbaaa";
        System.out.println(isValidPaliandrome(s,0));
    }
}
