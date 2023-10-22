package leetcode;

public class Main {
    public static void main(String[] args) {
        String s = "0.411111543";
        int k = 4;

        String result = removeKDigits(s, k);

        System.out.println("最大数为：" + result);
    }

    public static String removeKDigits(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        // 只需循环k次，删除k个字符即可
        for (int i = 0; i < k; i++) {
            int j = 0;

            // 找到第一个比后面大的字符
            while (j < sb.length() - 1 && sb.charAt(j) >= sb.charAt(j + 1)) {
                j++;
            }

            // 删除该字符
            sb.deleteCharAt(j);
        }

        // 删除前导零
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        sb.delete(0, i);

        return sb.toString();
    }
}
