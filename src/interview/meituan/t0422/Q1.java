package interview.meituan.t0422;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] nums = new int[t];
        for(int i=0;i<t;i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(canMakeDice(nums));

    }
    static boolean canMakeDice(int[] nums) {
        if (nums == null || nums.length % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int[] dice = new int[n];
        boolean[] used = new boolean[n + 1]; // 记录数字是否已经被使用过
        return backtrack(nums, dice, used, 0, n / 2);
    }
    private static boolean backtrack(int[] nums, int[] dice, boolean[] used, int idx, int target) {
        if (idx == dice.length) {
            // 检查所有相对的两面之和是否相等
            int sum = dice[0] + dice[dice.length - 1];
            for (int i = 1; i < dice.length / 2; i++) {
                if (dice[i] + dice[dice.length - 1 - i] != sum) {
                    return false;
                }
            }
            return true;
        }
        // 递归搜索骰子的每一面的数字
        for (int i = 1; i <= nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dice[idx] = nums[i - 1];
                if (idx % 2 == 1 && dice[idx] + dice[idx - 1] != dice[0] + dice[dice.length - 1]) {
                    // 前两个面的和应该等于后两个面的和
                    used[i] = false;
                    continue;
                }
                if (backtrack(nums, dice, used, idx + 1, target)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

}
