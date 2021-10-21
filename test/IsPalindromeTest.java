import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsPalindromeTest {
    @Test
    public void isPalindromeTest(){
        String s="A man, a plan, a canal: Panama";
        boolean ans = true;
        Assertions.assertEquals(ans,new IsPalindrome().isPalindrome(s));
        Assertions.assertEquals(ans,new IsPalindrome().isPalindrome_ultimate(s));
    }

    @Test
    public void simplifiedString(){
        String s="A man, a plan, a canal: Panama";
        String ans="amanaplanacanalpanama";
        Assertions.assertEquals(ans,new IsPalindrome().simplifiedString(s));
    }
}
