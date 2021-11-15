package Arrays;
/*leetcode:滑动窗口平均值*/
/*给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 MovingAverage 类：
MovingAverage(int size) 用窗口大小 size 初始化对象。
double next(int val) 成员函数 next每次调用的时候都会往滑动窗口增加一个整数，
请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 */

import java.util.ArrayDeque;
import java.util.Deque;

/*tip:用基本数据类型可以大大减少所用时间*/
public class MovingAverage {
    private int size;
    private Deque<Integer> window;
    private Double sum;

    public MovingAverage(int size) {
        this.size = size;
        sum=0d;
        window = new ArrayDeque<>(size);
    }

    public double next(int val) {
        if (window.size() >= size) {
            sum -= window.poll();
        }
        sum+=val;
        window.offer(val);
        return sum/window.size();
    }
}

