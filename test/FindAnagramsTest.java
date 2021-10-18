import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagramsTest {
    @Test
    public void findAnagramsTest(){
        String s="ababcba";
        String p="ab";
        List<Integer> ans=new ArrayList<>(Arrays.asList(0,1,2,5));
        Assertions.assertEquals(ans,new FindAnagrams().findAnagrams(s,p));

    }
}
