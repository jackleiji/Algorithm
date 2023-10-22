package leetcode.solution;

import java.util.HashMap;

public class Solution13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        int res = 0;
        Character[] charArr = new Character[]{'I','V','X','L','C','D','M'};
        int[] valueArr = new int[]{1,5,10,50,100,500,1000};
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<7;i++){
            map.put(charArr[i],valueArr[i]);
        }
        int len = s.length();
        int index = 0;
        while (index<len){
            Character value = s.charAt(index);
            int numb = map.get(value);;
            if(value.equals('I') && index<len-1){
                Character next_value = s.charAt(index+1);
                if(next_value.equals('V')){
                    numb=4;
                    index++;
                }else if(next_value.equals('X')){
                    numb=9;
                    index++;
                }
            }else if(value.equals('X') && index<len-1){
                Character next_value = s.charAt(index+1);
                if(next_value.equals('L')){
                    numb=40;
                    index++;
                }else if(next_value.equals('C')){
                    numb=90;
                    index++;
                }
            }else if(value.equals('C') && index<len-1){
                Character next_value = s.charAt(index+1);
                if(next_value.equals('D')){
                    numb=400;
                    index++;
                }else if(next_value.equals('M')){
                    numb=900;
                    index++;
                }
            }
            res += numb;
            index++;
        }

        return res;
    }
}
