package Arrays;

/**
 * leetcode:查找插入位置
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，
 * 并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 提示:
 * <p>
 * nums 为无重复元素的升序排列数组
 */
public class SearchInsert {
    //二分查找
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // target found
        }
        return low;  // target not found.
    }

    //recursive version
    public int searchInsert(int[] nums, int target, int low, int high) {
        if (low > high)
            return low;

        int mid = (low + high) >>> 1;
        int midVal = nums[mid];

        if (midVal < target)
            return searchInsert(nums, target, mid + 1, high);
        else if (midVal > target)
            return searchInsert(nums, target, low, mid - 1);
        else
            return mid;
    }
}
