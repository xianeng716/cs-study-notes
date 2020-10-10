package 排序;
//给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑
//充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
//
// 示例 1:
//
// 输入: [[0, 30],[5, 10],[15, 20]]
//输出: 2
//
// 示例 2:
//
// 输入: [[7,10],[2,4]]
//输出: 1
// Related Topics 堆 贪心算法 排序
// 👍 170 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _253_会议室II {

    public static void main(String[] args) {
//        [[0, 30],[5, 10],[15, 20]]
//        System.out.println(new _253_会议室II().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new _253_会议室II().minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));

    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }

            queue.add(intervals[i][1]);
        }

        return queue.size();
    }
}
