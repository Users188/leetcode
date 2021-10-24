import Strings.LengthOfLongestSubString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthOfLongestSubStringTest {
    @Test
    public void lengthOfLongestSubStringTest(){
        String s="ab";
        int ans=2;
        Assertions.assertEquals(ans,new LengthOfLongestSubString().lengthOfLongestSubString(s));
    }

}
