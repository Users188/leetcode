import Arrays.NumSubarrayProductLessThanK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumSubarrayProductLessThankTest {
    @Test
    public void numSubarrayProductLessThankTest(){
        int[] nums= {10,5,2,6};
        int k = 100;
        int ans = 8;
        Assertions.assertEquals(ans,new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(nums,k));
    }
}
