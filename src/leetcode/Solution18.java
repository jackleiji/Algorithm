package leetcode;

public class Solution18 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        boolean res = true;
        //双指针
        int len = s.length();
        int left = 0;
        int right = len-1;
        s = s.toLowerCase();
        while (left<right){
            Character leftletter = s.charAt(left);
            Character rightletter = s.charAt(right);
            while (left<right&&!Character.isLetterOrDigit(leftletter)){
                leftletter = s.charAt(++left);
            }
            while (left<right&&!Character.isLetterOrDigit(rightletter)){
                rightletter = s.charAt(--right);
            }
            if(!rightletter.equals(leftletter)){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return res;
    }
}
