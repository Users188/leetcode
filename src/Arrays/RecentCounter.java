package Arrays;
/*leetcode:最近请求次数*/

import java.util.ArrayDeque;
import java.util.Deque;

/*写一个RecentCounter类来计算特定时间范围内最近的请求。

请实现 RecentCounter 类：

RecentCounter() 初始化计数器，请求数为 0 。
int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
保证 每次对 ping 的调用都使用比之前更大的 t 值。

*/
public class RecentCounter {
    //将3000ms看作一个关于时间的滑动窗口
    final int TIME;
    Deque<Integer> requests;

    public RecentCounter() {
        TIME = 3000;
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (requests.peek() != null && requests.peek() < t - TIME) {
            requests.poll();
        }
        requests.add(t);
        return requests.size();
    }

//public class RecentCounter {
//    final int TIME=3000;
//    List<Integer> requests;
//    public RecentCounter() {
//        requests=new ArrayList<>(10000  );
//    }
//
//    //t严格递增
//    public int ping(int t) {
//        requests.add(t);
//        int min=t-TIME;
//        int count=0;
//        for (int i = requests.size()-1; i >=0 ; i--) {
//            if (requests.get(i)>=min)
//                count++;
//            else
//                break;
//        }
//        return count;
//    }


}
