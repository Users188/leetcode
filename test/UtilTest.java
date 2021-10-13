import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class UtilTest {

    @Test
    public void quickSortTest(){
        int[] input={1,3,5,1,3};
        Util.quickSort(input);
        int []output={1,1,3,3,5};
        assertArrayEquals(input,output);
    }

}
