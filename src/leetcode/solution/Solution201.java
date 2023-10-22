package leetcode.solution;

public class Solution201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1,2147483647));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        if (left==right) return left;
        int small = left;
        int big = right;
        if(left>right){
            small=right;
            big=left;
        }
        int res = small;
        for(int i=small+1;i<big;i++){
            res &=i;
            if(res==0) return 0;
        }
        res&=big;
        return res;
    }
}
