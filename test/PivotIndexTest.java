import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PivotIndexTest {
    @Test
    public void pivotIndexTest(){
        int[] nums={0,1,0,-1};
        int ans=0;
        Assertions.assertEquals(ans,new PivotIndex().pivotIndex_primitive(nums));
    }
}
