package jianzhioffer;

import java.util.*;

public class Solution5 {
//    public int maxProduct(String[] words) {
//        int ans = 0;
//        for(int i=0;i<words.length;i++){
//            String word = words[i];
//            for(int j=i+1;j<words.length;j++){
////                System.out.println(ans);
//                ans = Math.max(compareExist(word,words[j])==false?word.length()*words[j].length():ans,ans);
//            }
//        }
//        return ans;
//    }
//    public boolean compareExist(String a,String b){
//// O(m)
//        int[] count = new int[26];
//        for (char c : a.toCharArray()) count[c - 'a'] = 1;
//        for (char c : b.toCharArray()) {
//            if (count[c - 'a'] == 1) return true;
//        }
//        return false;
//    }
    //法二：降低时间复杂度
// 位运算 + 预计算
// 时间复杂度：O((m + n)* n)
// 空间复杂度：O(n)
    public int maxProduct(String[] words) {
        // O(mn)
        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for (char c : words[i].toCharArray()) {
                bitMask |= (1 << (c - 'a'));
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));
        }

        // O(n^2)
        int ans = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;
    }

}
