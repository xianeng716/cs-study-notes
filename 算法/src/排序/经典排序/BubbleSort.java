package 排序.经典排序;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 11, -6, 9, 2, 10, 31, 15, -8};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    private void sort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }


//    private void sort(int[] array) {
//        for (int end = array.length - 1; end > 0; end--) {
//            for (int begin = 1; begin <= end; begin++) {
//                if (array[begin] < array[begin - 1]) {
//                    int temp = array[begin];
//                    array[begin] = array[begin - 1];
//                    array[begin - 1] = temp;
//                }
//            }
//        }
//    }
}
