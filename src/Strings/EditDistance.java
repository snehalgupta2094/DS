package Strings;

public class EditDistance {

    public static void main(String[] args) {
        int c=minDistance("intention","execution");
        System.out.println(c);
    }
    public static int minDistance(String word1, String word2) {
        return findDistance(new StringBuffer(word1),new StringBuffer(word2),word1.length(),word2.length());
    }
    public static int findDistance(StringBuffer word1,StringBuffer word2, int i, int j){
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }

        if(word1.charAt(i-1)==word2.charAt(j-1)){
            return findDistance(word1,word2,i-1,j-1);
        }

        int replace=findDistance(word1,word2,i-1,j-1)+1;
        int delete=findDistance(word1,word2,i-1,j)+1;
        int insert=findDistance(word1,word2,i,j-1)+1;
        return Math.min(replace,Math.min(delete,insert));
    }
}
