import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class SingleNumberTest {
    @Test
    public void singleNumberTest(){
        int []nums= {2,2,3,2};
        int ans = 3;
        Assertions.assertEquals(ans,new SingleNumber().singleNumber_primitive(nums));
    }
}
