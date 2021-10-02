import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ThreeSumTest {
    @Test
    public void threeSumTest() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = List.of(List.of(-1,2,-1), List.of(0,1,-1));
        Assertions.assertEquals(ans, threeSum.threeSum(nums));
    }
    @Test
    public void threeSum_modified_Test(){
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = List.of(List.of(-1,2,-1), List.of(0,1,-1));
        Assertions.assertEquals(ans,threeSum.threeSum_modified(nums));
    }
}
