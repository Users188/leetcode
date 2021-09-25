import java.util.Arrays;

/*leetcode:只出现一次的数字*/
public class SingleNumber {
    //nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现三次
    public int singleNumber_primitive(int []nums){
        //使用排序
//        QuickSort.quickSort(nums);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int begin =0,end= nums.length-1;
        while (begin<end){
            if (nums[begin+1] == nums[begin])
                begin+=3;
            else
                return nums[begin];
            if (nums[end-1]==nums[end])
                end-=3;
            else
                return nums[end];
        }
        return nums[begin];
    }
}
