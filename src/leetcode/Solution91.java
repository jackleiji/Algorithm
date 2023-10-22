package leetcode;

public class Solution91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] flag = new int[len+1];
        flag[0] = 1;
        for(int i=1;i<len+1;i++){
            if(i>0&&s.charAt(i-1)!='0'){
                flag[i]+=flag[i-1];
            }
            if(i>1&&s.charAt(i-2)!='0'&&((s.charAt(i-2)-'0') *10 + (s.charAt(i-1)-'0')<=26)){
                flag[i]+=+flag[i-2];
            }
        }
        return flag[len];
    }
}
