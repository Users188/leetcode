import Strings.CheckInClusion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckInClusionTest {
    @Test
    public void checkInClusionTest(){
        String s1="ab";
        String s2="eidbaooo";
        boolean ans=true;
        Assertions.assertEquals(ans,new CheckInClusion().checkInClusion(s1,s2));
    }
}
