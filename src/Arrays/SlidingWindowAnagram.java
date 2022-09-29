package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowAnagram {
    public static List<Integer> findAnagrams(String s, String p) {
        int pArr[]=new int[26];
        int sArr[]=new int[26];

        for(int i=0;i<p.length();i++){
            pArr[p.charAt(i)-'a']++;
        }
        int start=0;
        int end=0;
        int k=p.length();
        ArrayList<Integer> result=new ArrayList<>();
        while(end<s.length()){
            if(end-start>k-1){
                sArr[s.charAt(start)-'a']--;
                start++;
            }
            else{
                if(end-start==k && Arrays.equals(pArr, sArr))
                    result.add(start);
                sArr[s.charAt(end)-'a']++;
                end++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result=findAnagrams("cbaebabacd","abc");
        System.out.println(result);
    }
}
