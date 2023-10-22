package leetcode;

import java.util.*;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] flag = new boolean[len];
        flag[0] = true;
        for(int i = 1;i<=len;i++){
            //截取s中不同长度字符，用于判断set中是否存在；
            for(int j=0;j<i;j++){
                if(flag[j] && set.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[len];
    }
}
