import Arrays.Util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtilTest {

    @Test
    public void quickSortTest(){
        int[] input={1,3,5,1,3};
        Util.quickSort(input);
        int []output={1,1,3,3,5};
        assertArrayEquals(input,output);
    }

    @Test
    public void FibonacciTest(){
        int ans = 89,n=10;
        assertEquals(ans,Util.Fibonacci(n));
    }

}
