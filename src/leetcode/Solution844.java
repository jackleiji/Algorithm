package leetcode;

public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char letter = s.charAt(i);
            if(letter=='#' && s1.length()!=0){
                s1.deleteCharAt(s1.length()-1);
            }else if(letter!='#'){
                s1.append(letter);
            }

        }
        for(int i=0;i<t.length();i++){
            char letter = s.charAt(i);
            if(letter=='#' && t1.length()!=0){
                t1.deleteCharAt(t1.length()-1);
            }else if(letter!='#'){
                t1.append(letter);
            }
        }
        System.out.println(t1+" "+s1);
        return s1.toString().equals(t1.toString());
    }
}
