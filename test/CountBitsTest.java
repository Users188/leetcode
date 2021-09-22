import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CountBitsTest {

    @Test
    public void countBitsTest(){
        int[] ans={0,1,1,2,1,2};
        int n=5;
        assertArrayEquals(CountBits.countBits(n),ans);
    }
}
