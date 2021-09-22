import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class DivideTest {
    @Test
    public void divideTest(){
        int dividend=Integer.MIN_VALUE,divisor=1,ans=dividend/divisor;
        assertEquals(ans,new Divide().divide_modified(Integer.MIN_VALUE,1));
    }
}
