package Arrays;/*leetcode:左右两边子数组的和相等*/

public class PivotIndex {
    public int pivotIndex_primitive(int[] nums) {
        int pivot = 0, leftSum = 0, rightSum = 0;
        for (; pivot < nums.length; pivot++) {
            leftSum = Util.array_sum(nums, 0, pivot);
            rightSum = Util.array_sum(nums, pivot, nums.length - 1);
            if (leftSum == rightSum) {
                return pivot;
            }
        }
        return -1;
    }

    public int pivotIndex_ultimate(int[] nums) {
        int pivot = 0, leftSum = 0, rightSum = 0;
        int total = Util.array_sum(nums, 0, nums.length - 1);
        for (int num : nums) {
            leftSum += num;
            rightSum = total - leftSum + num;
            if (leftSum == rightSum)
                return pivot;
            pivot++;
        }
        return -1;
    }
}
