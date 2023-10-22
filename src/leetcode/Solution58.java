package leetcode;

public class Solution58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord ("         ava              aa  aa          "));
    }
    public static int lengthOfLastWord(String s) {
        //法一：
//        int len = s.length();
//        int index = len-1;
//        boolean flag = false;
//
//        while (index>=0){
//            char letter = s.charAt(index);
//            if(!flag && letter==' '){
//                len--;
//            }else if(!flag && letter!=' '){
//                flag = true;
//            }
//            if(flag && letter==' '){
//                break;
//            }
//            index--;
//        }
//        if (flag){
//            index++;
//        }
//        System.out.printf("%d,%d\n",len,index);
//        return len-index;

        //法二：
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }
}
