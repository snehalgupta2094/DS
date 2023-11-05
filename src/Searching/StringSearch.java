package Searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringSearch {

    public static void main(String[] args) {
        String input="EJOABCOIEFIUASKJMDJCBBCACUDH";
        String output="";
        ArrayList<String> allSuccessfullEventsList=new ArrayList<>();
        for(int i=input.length()-1;i>=0;i--){
            if(input.charAt(i)=='C'){
                String temp="";
                Set<Character> set=new HashSet<>();
                while(input.charAt(i)=='A' || input.charAt(i)=='B' || input.charAt(i)=='C'){
                    temp=temp+input.charAt(i);
                    set.add(input.charAt(i));
                    i--;
                }
                if(set.size()==3 && set.contains('A') && set.contains('B') && set.contains('C')){
                    if(temp.length()>output.length()){
                        output=temp;
                    }
                    allSuccessfullEventsList.add(temp);
                }
            }
        }
        System.out.println(allSuccessfullEventsList);
        System.out.println(output);
    }
}
