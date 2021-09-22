import java.util.HashMap;
import java.util.Map;

/*leetcode:两数之和*/
public class TwoSum {
    /*暴力破解方法*/
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<=nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[0];
    }

    /*hashmap辅助，解决重复值，利用哈希查找*/
    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            map.put(nums[i], i);
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
//        return new int[0];
    }

}
