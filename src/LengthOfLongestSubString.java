import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*leetcode:不含重复字符的最长子字符串*/
public class LengthOfLongestSubString {
    private boolean containsRepeatedCharacter(String s) {
        if (s == null || s.length() == 0)
            return false;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterSet.contains(c)) {
                return true;
            }
            characterSet.add(c);
        }
        return false;
    }

    public int lengthOfLongestSubString_primitive(String s) {
        //暴力解法
        if (s == null || s.isEmpty())
            return 0;
        int length = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (!containsRepeatedCharacter(subString))
                    length = Math.max(length, subString.length());
            }
        }
        return length;
    }

    public int lengthOfLongestSubString(String s) {
        //滑动窗口
        //map存储字符串每个字符索引
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, length = 0;
        //保证窗口内没有重复值
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                //如果重复值索引在left左边，则已经遍历过，在右边，则将left指针移到重复值右侧
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //如果遇到重复元素会更新索引值
            map.put(s.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}
