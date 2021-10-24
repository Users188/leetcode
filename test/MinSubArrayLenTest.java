import Arrays.MinSubArrayLen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSubArrayLenTest {
    @Test
    public void minSubArrayLenTest(){
        int[] nums = {2,3,1,2,4,3};
        int target = 3;
        Assertions.assertEquals(1,new MinSubArrayLen().minSubArrayLen(target,nums));
    }
}
