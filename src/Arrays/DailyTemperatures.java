package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/*leetcode:每日温度*/
/*请根据每日 气温 列表 temperatures，
重新生成一个列表，要求其对应位置的输出为：
要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
*/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //用于储存无法立刻观测到更高气温的天气（气温，日期）
        Deque<Integer[]> stack = new ArrayDeque<>(temperatures.length);
        for (int i = 0; i < temperatures.length - 1; i++) {
            int today = temperatures[i];
            int tomorrow = temperatures[i + 1];
            if (today < tomorrow) {
                res[i] = 1;
                while (!stack.isEmpty()) {
                    Integer[] temp = stack.peek();
                    if (temp[0] >= tomorrow)
                        break;
                    res[temp[1]] = i + 1 - temp[1];
                    stack.pop();
                }
            } else {
                Integer[] temp = new Integer[]{temperatures[i], i};
                stack.push(temp);
            }
        }
        return res;
    }
}
