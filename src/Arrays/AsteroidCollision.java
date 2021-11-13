package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*leetcode:小行星碰撞*/
/*给定一个整数数组 asteroids，表示在同一行的小行星。
对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
*/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids){
        Deque<Integer> stack=new ArrayDeque<>(asteroids.length);
        List<Integer> result=new ArrayList<>(asteroids.length);
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            }
            if (asteroid < 0) {
                boolean flag=false;
                while (!stack.isEmpty()){
                    if (stack.peek() >= -asteroid){
                        if (stack.peek()==-asteroid)
                            stack.pop();
                        flag=true;
                        break;
                    }
                    else
                        stack.pop();
                }
                if (!flag)
                    result.add(asteroid);
            }
        }
        while (!stack.isEmpty()){
            //保证顺序与asteroids一致
            result.add(stack.pollLast());
        }
        //将List<Integer>转换为int[]
        int[] res=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i]=result.get(i);
        }
        return res;
    }
}
