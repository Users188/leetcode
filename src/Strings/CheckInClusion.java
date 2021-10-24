package Strings;

/*leetcode:字符串中的变位词*/
/*给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 第一个字符串的排列之一是第二个字符串的子串
 * 如何转换“排列之一”？由于字母均为小写，可以用一个26位数组表示s1中每个字符出现的次数，再与s2的子串对应数组比较，
 * 相等子串即为排列之一*/
public class CheckInClusion {
    public boolean checkInClusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            chars[c - 'a']++;
        }
        //滑动窗口（窗口大小固定）
        int left = 0, right = s1.length() - 1;
        while (right < s2.length()) {
            int[] sub_chars = new int[26];
            for (int i = left; i <= right; i++) {
                char c = s2.charAt(i);
                sub_chars[c - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (chars[i] == sub_chars[i])
                    count++;
            }
            if (count == 26)
                return true;
            left++;
            right++;
        }
        return false;
    }
}
