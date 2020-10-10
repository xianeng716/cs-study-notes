package 动态规划;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2778 👎 0
public class _5_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(new _5_最长回文子串().longestPalindrome("cbbd"));
    }


    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[j] != charArray[i]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //缩小包围圈
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                int max = j - i + 1;

                if (dp[i][j] && max > maxLen) {
                    maxLen = max;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
