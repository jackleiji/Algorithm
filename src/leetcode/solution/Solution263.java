package leetcode.solution;

public class Solution263 {
    public boolean isUgly(int n) {
        //丑数必然是2，3，5的倍数，不断除2，3，5直到除不尽为1就是丑数
        if(n==1) return false;
        while (n%2==0){
            n/=2;
        }
        while (n%3==0){
            n/=3;
        }
        while (n%5==0){
            n/=5;
        }
        return n==1?true:false;
    }
}
