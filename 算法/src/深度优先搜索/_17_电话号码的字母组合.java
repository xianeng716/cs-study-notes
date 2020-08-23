package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合 {


    public static void main(String[] args) {
        List<String> list = new _17_电话号码的字母组合().letterCombinations("23");
        for (String string : list) {
            System.out.println(string);
        }
    }

    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    List<String> result = new ArrayList<>();
    char[] charsArray;
    char[] charsString;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        charsArray = digits.toCharArray();
        charsString = new char[charsArray.length];
        dfs(0);
        return result;
    }

    public void dfs(int index) {
        if (index == charsArray.length) {
            result.add(new String(charsString));
            return;
        }
        char[] array = lettersArray[charsArray[index] - '2'];
        for (int i = 0; i < array.length; i++) {
            charsString[index] = array[i];
            dfs(index + 1);
        }
    }

}
