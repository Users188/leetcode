package Arrays;
/**leetcode:排序数组中只出现一次的数字
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，
 * 唯有一个数只会出现一次，请找出这个唯一的数字。
 *  */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        for (i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] != nums[i])
                break;
        }
        return nums[i - 1];
    }

    //1. 归零律：a ^ a = 0;
    //2. 恒等律：a ^ 0 = a;
    public int singleNonDuplicateXOR(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target ^= num;
        }
        return target;
    }
}
