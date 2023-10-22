package interview.arithmetic;

public class Solution19 {
    public boolean validPalindrome(String s) {
        boolean res = true;
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            char leftl= s.charAt(left);
            char rigthl = s.charAt(right);
            if(leftl == rigthl){
                left++;
                right--;
            }else {
                break;
            }
            if(left==right || left>right){
                return res;
            }
        }
        String sb1 = s.substring(left+1,right+1);
        String sb2 = s.substring(left,right);

        return Palindrome(sb1) || Palindrome(sb2);
    }
    public boolean Palindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            char leftl= s.charAt(left);
            char rigthl = s.charAt(right);
            if(leftl == rigthl){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
