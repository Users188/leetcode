package Strings;

import java.util.HashMap;
import java.util.Map;

/*leetcode:有效的变位符*/
/*s和t仅包含小写字母*/
public class IsAnagram {
    public boolean isAnagram(String s,String t){
        if (s.equals(t)||s.length()!=t.length())
            return false;
        int[] countChar=new int[26];
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char s_char=s.charAt(i);
            char t_char=t.charAt(i);
            countChar[s_char-'a']++;
            countChar[t_char-'a']--;
        }
        for(int count:countChar){
            if (count!=0)
                return false;
        }
        return true;
    }

    public boolean isAnagram_modified(String s,String t){
        if (s.equals(t)||s.length()!=t.length())
            return false;
        Map<Character,Integer> charOccurrence=new HashMap<>();
        for(char c:s.toCharArray()){
            charOccurrence.put(c,charOccurrence.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            if (!charOccurrence.containsKey(c)||charOccurrence.get(c)==0)
                return false;
            charOccurrence.put(c,charOccurrence.get(c)-1);
        }
        return true;
    }
}
