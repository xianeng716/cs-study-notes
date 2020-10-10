package 二叉树;

import java.lang.reflect.Array;
import java.util.Arrays;

public class offer56_1数组中数字出现的次数 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new offer56_1数组中数字出现的次数().
//                singleNumbers(new int[]{4, 1, 4, 6})));

        System.out.println(Arrays.toString(new offer56_1数组中数字出现的次数().
                singleNumbers(new int[]{3, 2, 1, 3})));
    }

    /**
     * 先做一遍快排，然后再遍历一遍
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);

        int index = 0;
        int resultIndex = 0;
        while (index < nums.length - 1) {
            boolean flag = false;
            while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
                flag = true;
                index++;
            }
            if (!flag) {
                result[resultIndex++] = nums[index++];
            } else {
                index++;
            }
        }

        if (resultIndex < 2) {
            result[1] = nums[nums.length - 1];
        }

        return result;
    }
}
