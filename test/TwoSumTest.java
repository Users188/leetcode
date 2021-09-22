import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    @Test
    public void twosumTest(){
        int []nums={1,3,5,5,3};
        int target=8;
        int []ans={1,2};
        TwoSum twosum=new TwoSum();
        assertArrayEquals(twosum.twoSum1(nums,target),ans);
    }

}
