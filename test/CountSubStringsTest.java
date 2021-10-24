import Strings.CountSubStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSubStringsTest {
    @Test
    public void countSubStringsTest(){
        String s="aaa";
        int ans = 6;
        Assertions.assertEquals(ans,new CountSubStrings().countSubStrings_dp(s));
        Assertions.assertEquals(ans,new CountSubStrings().countSubStrings(s));
    }
}
