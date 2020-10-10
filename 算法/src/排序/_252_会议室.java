package 排序;
//给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加
//这里面的全部会议。
//
// 示例 1:
//
// 输入: [[0,30],[5,10],[15,20]]
//输出: false
//
//
// 示例 2:
//
// 输入: [[7,10],[2,4]]
//输出: true
//
// Related Topics 排序
// 👍 44 👎 0
import java.util.Arrays;
import java.util.Comparator;

public class _252_会议室 {

    public static void main(String[] args) {
//        [[0,30],[5,10],[15,20]]
        System.out.println(new _252_会议室().canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new _252_会议室().canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
