package Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
Given an input sentence and a list of tuples indicating a pair of synonyms, return all the different possible
valid sentence combinations that can be made with those synonyms, in sorted order.

Example:

input_sentence = "The cat walked across the road"
synonyms = [('cat', 'dog'), ('walked', 'ran'), ('walked', 'crawled'), ('cat', 'monkey'), ('road','building'),('road','roof')]

output = ['The cat crawled across the road',
'The cat ran across the road',
'The cat walked across the road',
'The dog crawled across the road',
'The dog ran across the road',
'The dog walked across the road',
'The monkey crawled across the road',
'The monkey ran across the road',
'The monkey walked across the road']
 */

//cat, dog, monkey
//crawled, ran, walked
//building, road, roof, tree

public class PermutationsInSentence {

    public static List<String> getAllCombinations(String input_sentence, String[][] synonyms){
        List<String> output=new ArrayList<>();
        //Create sorted map
        HashMap<String, TreeSet<String>> synonymMap=new HashMap<>();
        for(int i=0;i<synonyms.length;i++){
            TreeSet<String> replacement=new TreeSet<>();
            if(synonymMap.get(synonyms[i][0])!=null){
                replacement=synonymMap.get(synonyms[i][0]);
                   replacement.add(synonyms[i][1]);
                   synonymMap.put(synonyms[i][0],replacement);
                }
                else{
                    replacement.add(synonyms[i][0]);
                }
            replacement.add(synonyms[i][1]);
            synonymMap.put(synonyms[i][0],replacement);
            }
        //get All combinations
        String[] words=input_sentence.split(" ");
        getCombination(words,synonymMap,0,new StringBuffer(),output);
        return output;
    }
    public static void getCombination(String[] words,HashMap<String,TreeSet<String>> synonymMap, int index,StringBuffer sentence, List<String> solution){
        if(index>words.length){
            return;
        }
        if(index==words.length){
            solution.add(new String(sentence));
            return;
        }
        if(synonymMap.containsKey(words[index])){
          TreeSet<String> replacements=synonymMap.get(words[index]);
               for(String replacement: replacements){
                   StringBuffer copySentence=new StringBuffer(sentence);
                   copySentence.append(replacement+" ");
                   getCombination(words,synonymMap,index+1,copySentence,solution);
               }
           }
        else{
            sentence.append(words[index]+" ");
            getCombination(words,synonymMap,index+1,sentence,solution);
        }
    }

    public static void main(String[] args) {
        String input_sentence="The cat walked across the road";
        String[][] synonyms={{"cat","dog"},{"walked","ran"},{"walked","crawled"},{"cat","monkey"}};
        List<String> outputList=getAllCombinations(input_sentence,synonyms);
        System.out.println(outputList);
    }
}
