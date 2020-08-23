package 分治;
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class offer40最小的k个数 {
    /**
     * 通过快排的思想，只要保证从0到k-1有序即可，但是这样会破坏数组结构
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] result = new int[k];

        int start = 0;
        int end = arr.length - 1;

        int pivote = pivoteIndex(arr, start, end);
        while (pivote != k - 1) {
            if (pivote < k - 1) {
                start = pivote + 1;
            } else {
                end = pivote - 1;
            }

            pivote = pivoteIndex(arr, start, end);
        }

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }


        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 9, 1, 2, 7};
        offer40最小的k个数 a = new offer40最小的k个数();
        new offer40最小的k个数().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums, int begin, int end) {
        if (end - begin < 2) return;
        int middle = pivoteIndex(nums, begin, end);
        sort(nums, begin, middle);
        sort(nums, middle + 1, end);
    }

    public int pivoteIndex(int[] nums, int begin, int end) {
        int pivoteIndex = begin + (int) ((end - begin) * Math.random());
        int temp = nums[begin];
        nums[begin] = nums[pivoteIndex];
        nums[pivoteIndex] = temp;

        int pivote = nums[begin];

        while (begin < end) {
            while (begin < end) {
                if (nums[end] > pivote) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin < end) {
                if (nums[begin] < pivote) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin] = pivote;
        return begin;
    }


    /**
     * 通过大顶堆来做，这样可以不破坏数组结构，nlog(k)时间复杂度即可
     */
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr == null || arr.length == 0 || k == 0) {
//            return new int[]{};
//        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                return t1 - integer;
//            }
//        });
//        int[] result = new int[k];
//
//        for (int i = 0; i < arr.length; i++) {
//            if (priorityQueue.size() < k) {
//                priorityQueue.add(arr[i]);
//            } else {
//                int top = priorityQueue.peek();
//                if (top > arr[i]) {
//                    priorityQueue.poll();
//                    priorityQueue.add(arr[i]);
//                }
//            }
//        }
//
//        int index = 0;
//        while (!priorityQueue.isEmpty()) {
//            result[index++] = priorityQueue.poll();
//        }
//
//        return result;
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)