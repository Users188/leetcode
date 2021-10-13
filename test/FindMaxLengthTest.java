import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMaxLengthTest {
    @Test
    public void findMaxLengthTest(){
        int[] nums={0,0,0,1,1,1,0};
        int ans = 6;
        Assertions.assertEquals(ans,new FindMaxLength().findMaxLength_unfinish(nums));
    }
}
