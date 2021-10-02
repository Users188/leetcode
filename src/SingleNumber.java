import java.util.*;

/*leetcode:只出现一次的数字*/
public class SingleNumber {
    //nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现三次
    public int singleNumber_primitive(int []nums){
        //使用排序
//        QuickSort.quickSort(nums);
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        /*int begin =0,end= nums.length-1;
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
        return nums[begin];*/
        int left=0,right=2;
        while (right<nums.length){
            if (nums[left]!=nums[right])
                return nums[left];
            left+=3;
            right=left+2;
        }
        return nums[left];
    }

    public int singleNumber_modified(int []nums){
        //利用hashmap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num))
                hashMap.put(num, 1);
            else{
                int occurrences = hashMap.get(num);
                hashMap.put(num,++occurrences);
            }
        }
        //通过map.entrySet()获得键值对，性能较高
        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }


    public  int singleNumber_ultimate(int []nums){
        //位运算
        /*int ret = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += num >> i & 1;
            }
            if (cnt % 3 != 0) {
                ret |= 1 << i;
            }
        }
        return ret;*/

        //有限状态机,三进制
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber(int []nums){
        //集合+数学运算
        Set<Integer> set = new HashSet<>();
        int sum =0,sum3=0,res=0;
        for (int num:nums){
            sum+=num;
            set.add(num);
        }
        for (Integer item:set){
            sum3+=item;
        }
        //容易越界
        return res =sum - (sum - sum3)*3/2;
    }

}
