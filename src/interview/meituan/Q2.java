package interview.meituan;

import java.util.*;

public class Q2 {
    //求差值和
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(nums[i] - nums[i + 1]);
        }
        System.out.println(ans);
    }
}
