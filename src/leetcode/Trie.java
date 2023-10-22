package leetcode;

public class Trie {
    //208. 实现 Trie (前缀树)
    Trie[] mapTree;
    boolean isEnd;
    public Trie() {
        mapTree = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            int site = word.charAt(i)-'a';
            if(node.mapTree[site]==null){
                node.mapTree[site] = new Trie();
            }
            node = node.mapTree[site];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            int site = word.charAt(i)-'a';
            if(node.mapTree[site]==null) return false;
            node = node.mapTree[site];
        }
        if(node.isEnd==true) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i=0;i<prefix.length();i++){
            int site = prefix.charAt(i)-'a';
            if(node.mapTree[site]==null) return false;
            node = node.mapTree[site];
        }
        return true;
    }
}
