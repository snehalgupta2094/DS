package Trie;
class TrieNode{
    char data;
    TrieNode[] children=new TrieNode[26];
    boolean isTerminal;
    TrieNode(char ch){
        this.data=ch;
        isTerminal=false;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        this.root=new TrieNode('\0');
    }
    public void insertUtil(TrieNode root,String word){
        //best case
        if(word.length()==0)
        {
            root.isTerminal=true;
            return;
        }


        //get index of word
        int index=word.charAt(0)-'a';
        TrieNode child;

        //present
        if(root.children[index]!=null){
            child=root.children[index];
        }
        else
        {
            //absent
            child=new TrieNode(word.charAt(0));
            root.children[index]=child;
        }
        insertUtil(child,word.substring(1));
    }
    public void insert(String word){
        insertUtil(root,word);
    }
    public boolean searchUtil(TrieNode root, String word){
        //best case
        if(word.length()==0)
            return root.isTerminal;
        int index=word.charAt(0)-'a';
        TrieNode child;
        //present
        if(root.children[index]!=null){
            child= root.children[index];
        }
        else
        {
            //absent
            return false;
        }
        //recursion
        return searchUtil(child,word.substring(1));
    }
    public boolean search(String word){
        return searchUtil(root,word);
    }
}
public class TrieImplementation {

    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("car");
        t.insert("cat");
        t.insert("ape");
        System.out.println(t.search("ape"));
    }

}
