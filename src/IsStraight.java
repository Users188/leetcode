import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*leetcode:扑克牌中的顺子*/
/*数组长度为 5
数组的数取值为 [0, 13] .*/
public class IsStraight {
    public boolean isStraight_primitive(int[] nums){
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length-1; i++) {
            //统计大小王
            if (nums[i]==0){
                joker++;
                continue;
            }
            //不能重复
            if (nums[i]==nums[i+1])
                return false;
            //当相邻两数差值大于1时，需要用大小王补上
            joker-=nums[i+1]-nums[i]-1;
            //大小王不够补，不是顺子
            if (joker<0)
                return false;
        }
        return true;
    }

    public boolean isStraight_ultimate(int[] nums){
        //5张牌构成顺子的充要条件：最大值-最小值<5 且 没有重复
        Set<Integer> no_repeat = new HashSet<>();
        int max = 0, min = 13;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(no_repeat.contains(num)) return false; // 若有重复，提前返回 false
            no_repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
