import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*leetcode:字符串中所有的变位词（变位词：以相同字母排列的字符串）*/
/*给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
* s,p只包含小写字母*/
public class FindAnagrams {
    public List<Integer> findAnagrams(String s,String p){
        List<Integer> ans=new ArrayList<>();
        if (s.length()<p.length())
            return ans;
       int[] chars=new int[26];
        int[] sub_chars=new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c=p.charAt(i);
            char m=s.charAt(i);
            chars[c-'a']++;
            sub_chars[m-'a']++;
        }
        if(Arrays.equals(chars,sub_chars))
            ans.add(0);
        int left=0,right=p.length();
        while (right<s.length()){
            sub_chars[s.charAt(left++)-'a']--;
            sub_chars[s.charAt(right++)-'a']++;
            if (Arrays.equals(chars,sub_chars))
                ans.add(left);
        }
        return ans;
    }
}
