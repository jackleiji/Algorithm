package leetcode;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        int res = haystack.indexOf(needle);
        return res;
    }
}
