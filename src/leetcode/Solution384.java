package leetcode;

import java.util.Random;

public class Solution384 {
    int nums[];
    int shuffle[];
    Random random;
    public Solution384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        shuffle = nums.clone();
        for(int i=shuffle.length-1;i>0;i++){
            int j= random.nextInt(i+1);
            int temp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = temp;
        }
        return shuffle;
    }
}
