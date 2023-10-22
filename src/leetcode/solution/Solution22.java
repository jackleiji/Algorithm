package leetcode.solution;

import java.util.*;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(new char[2*n],0,res);
        return res;
    }
    public void dfs(char[] comb,int n,List<String> res){
        if(n==comb.length){
            if(valid(comb)){
                res.add(new String(comb));
            }else {
                comb[n] = '(';
                dfs(comb,n+1,res);
                comb[n] = ')';
                dfs(comb,n+1,res);
            }
        }
    }
//    List<String> res = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        dfs(n,0,new StringBuilder());
//        return res;
//    }
//    public void dfs(int n,int index,StringBuilder sb){
//        if(index>=n) {
//            if(valid(sb.toString().toCharArray()))
//                res.add(sb.toString());
//            return;
//        }
//        sb.append('(');
//        dfs(n,index+1,sb);
//        sb.deleteCharAt(sb.length()-1);
//        sb.append(')');
//        dfs(n,index+1,sb);
//        sb.deleteCharAt(sb.length()-1);
//    }
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
