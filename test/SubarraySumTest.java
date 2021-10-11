import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubarraySumTest {
    @Test
    public void subarraySumTest(){
        int[] nums={1,2,3};
        int k=3;
        int ans=2;
        Assertions.assertEquals(ans,new SubarraySum().subarraySum(nums,k));
    }
}
