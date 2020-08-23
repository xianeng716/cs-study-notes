package 排序.经典排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class InsertSort {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 1, 3, 11, -6, 9, 2, 10, 31, 15, -8};
//        new InsertSort().sort(nums);
//        System.out.println(Arrays.toString(nums));


        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(1);
        queue.add(2);
        queue.add(3);
//        queue.add(-3);
        System.out.println(queue.poll());
    }

    private void sort(int[] array) {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && array[cur] < array[cur - 1]) {
                int temp = array[cur];
                array[cur] = array[cur - 1];
                array[cur - 1] = temp;
                cur--;
            }
        }
    }
}
