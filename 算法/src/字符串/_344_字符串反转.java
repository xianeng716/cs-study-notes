package 字符串;
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//
//
//
// 示例 1：
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
// Related Topics 双指针 字符串
// 👍 283 👎 0
public class _344_字符串反转 {
    public void reverseString(char[] s) {
        if (s == null) return;
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        char[] a = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] b = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        new _344_字符串反转().reverseString(a);
        new _344_字符串反转().reverseString(b);

        System.out.println(new String(a));
        System.out.println(new String(b));
    }
}
