package leetcode.baidu;

import java.util.*;
//给定一个字符串，问是否可以排列为：Baidu
public class Question1 {
    public static boolean solve() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        if(s.length() != 5) return false;
        Map<Character, Integer> mp = new HashMap<>();
        String Baidu = "Baidu";
        for(char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        for(char c : Baidu.toCharArray()) {
            if(mp.getOrDefault(c, 0) != 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tt = input.nextInt();
        input.nextLine();
        while(tt-- > 0) System.out.println(solve() ? "Yes" : "No");
    }

}
