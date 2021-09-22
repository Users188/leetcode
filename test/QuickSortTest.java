import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class QuickSortTest {

    @Test
    public void quickSortTest(){
        int[] input={1,3,5,1,3};
        QuickSort.quickSort(input);
        int []output={1,1,3,3,5};
        assertArrayEquals(input,output);
    }

}
