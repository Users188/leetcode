import Strings.MinWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinWindowTest {
    @Test
    public void minWindowTest(){
        String s="abudcbccdscs";
        String t="ababds";
        String ans = "";
        Assertions.assertEquals(ans,new MinWindow().minWindow(s,t));
    }
}
