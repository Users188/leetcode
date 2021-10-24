import Integers.Divide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {
    @Test
    public void divideTest(){
        int dividend=Integer.MIN_VALUE,divisor=1,ans=dividend/divisor;
        assertEquals(ans,new Divide().divide_modified(Integer.MIN_VALUE,1));
    }
}
