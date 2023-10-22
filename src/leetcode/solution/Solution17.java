package leetcode.solution;

import java.util.*;

public class Solution17 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        List<Character[]> list = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            char digit = digits.charAt(i);
            if(digit == '2'){
                list.add(new Character[]{'a','b','c'});
            }else if(digit == '3'){
                list.add(new Character[]{'d','e','f'});
            }else if(digit == '4'){
                list.add(new Character[]{'g','h','i'});
            }else if(digit == '5'){
                list.add(new Character[]{'j','k','l'});
            }else if(digit == '6'){
                list.add(new Character[]{'m','n','o'});
            }else if(digit == '7'){
                list.add(new Character[]{'p','q','r','s'});
            }else if(digit == '8'){
                list.add(new Character[]{'t','u','v'});
            }else if(digit == '9'){
                list.add(new Character[]{'w','x','y','z'});
            }
        }
        dfs(list,new boolean[list.size()],0,new StringBuilder());
        System.out.println(res.toString());
        return res;
    }

    public void dfs(List<Character[]> list,boolean[] flag,int site,StringBuilder str){
        if(site==list.size()){
            res.add(str.toString());
            return;
        }
        for(int i=0;i<list.get(site).length;i++){
            Character[] characters= list.get(site);
            str.append(characters[i]);
            dfs(list,flag,site+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
