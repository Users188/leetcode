package Arrays;
/*leetcode:最小时间差*/
import java.util.*;

public class FindMinDifference {
    public static void main(String[] args) {
        List<String> test = Arrays.asList("00:00", "23:59");
        System.out.println(new FindMinDifference().findMinDifference(test));
    }

    public int findMinDifference_primitive(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int index = 0;
        for (String time : timePoints) {
            int minutes = 0;
            int i = 1;
            for (String retval : time.split(":")) {
                minutes += Integer.parseInt(retval) * Math.pow(60, i--);
            }
            times[index++] = minutes;
        }
        Arrays.sort(times);
        int diff1 = times[times.length - 1] - times[0];
        int diff2 = 24 * 60 - diff1;
        int minDiff = Math.min(diff1, diff2);
        for (int i = 0; i < times.length - 1; i++) {
            diff1 = times[i + 1] - times[i];
            diff2 = 24 * 60 - diff1;
            int diff = Math.min(diff1, diff2);
            minDiff = Math.min(minDiff, diff);
            if (minDiff == 0)
                return minDiff;
        }
        return minDiff;
    }

    public int findMinDifference(List<String> timePoints) {
        final int ONE_DAY_MINUTES = 24 * 60;
        //一天的时间刻度在分钟单位只有24*60个，如果大于这个数说明有重复时间点，最小时间差为0
        if (timePoints.size() > ONE_DAY_MINUTES) {
            return 0;
        }
        //用于存储转换为以分钟为单位的timePoint
        List<Integer> minutes = new ArrayList<>();
        for (String t : timePoints) {
            //分析正则表达式较为耗时,并且使用split需要多用一些空间
//            String[] time = t.split(":");
//            minutes.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            minutes.add(Integer.parseInt(t.substring(0,2))*60+Integer.parseInt(t.substring(3)));
        }
        Collections.sort(minutes);
        //由于排序后数组最小值与最大值需要比较，故加入最小值+一天的时间，得到两个时间刻度的差
        minutes.add(minutes.get(0) + ONE_DAY_MINUTES);
        //最大的差为一天时间的一半
        int minDiff = ONE_DAY_MINUTES/2;
        for (int i = 1; i < minutes.size(); ++i) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        return minDiff;
    }
}
