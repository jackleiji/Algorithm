package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2063 {
    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
    }
    static List<List<Character>> list = new ArrayList<>();
    static long res = 0;
    public static long countVowels(String word) {
        //递归超时
//        for(int i=0;i<word.length();i++){
//            dfs(word,new LinkedList<>(),i,0);
//        }
//        for(List<Character> l: list){
//            System.out.println(l.toString());
//        }
//        return res;
        //法二：公式法
        int len = word.length();
        for (int i = 0; i < len; ++i) {
            char data = word.charAt(i);
            if(data == 'a' || data == 'e'||data == 'i'||data == 'o'||data == 'u'){
                res += (long)(i + 1) * (len - i);
            }
        }
        return res;
    }
    public static void dfs(String word,List<Character> subword,int index,int count){
        if(index>=word.length()){
            return;
        }
        Character data = word.charAt(index);
        subword.add(data);
        if(data == 'a' || data == 'e'||data == 'i'||data == 'o'||data == 'u'){
            count++;
        }
        list.add(new ArrayList<>(subword));
        res+=count;
        dfs(word,subword,index+1,count);
    }
}
