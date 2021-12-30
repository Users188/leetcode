import LinkedLists.IsPalindrome;
import Strings.Palindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {
    @Test
    public void isPalindromeTest(){
        String s="A man, a plan, a canal: Panama";
        boolean ans = true;
        Assertions.assertEquals(ans,new Palindrome().isPalindrome(s));
        Assertions.assertEquals(ans,new Palindrome().isPalindrome_ultimate(s));
    }

    @Test
    public void simplifiedString(){
        String s="A man, a plan, a canal: Panama";
        String ans="amanaplanacanalpanama";
        Assertions.assertEquals(ans,new Palindrome().simplifiedString(s));
    }
}
