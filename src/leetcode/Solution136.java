package leetcode;

import java.io.IOException;

public class Solution136 {
    public int singleNumber(int[] nums) throws IOException {
        if (nums.length == 0){
            throw new IOException();
        }

        int res = 0;
        for (int numb:nums) {
            res^=numb;
        }
        return res;
    }
}
