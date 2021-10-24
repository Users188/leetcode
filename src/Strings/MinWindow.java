package Strings;

import java.util.HashMap;

/*leetcode:含有所有字符的最短字符串*/
/*给定两个英文字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。
如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
如果 s 中存在多个符合条件的子字符串，返回任意一个。
注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。*/
public class MinWindow {
    public String minWindow(String s, String t) {
        //暴力解法
        String res = "";
        if (s.length() < t.length())
            return res;
        int minLenth = s.length(), minWinLeft = -1, minWinRight = Integer.MAX_VALUE;
        //找出符合条件的最短字符串
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                int length = j - i;
                if (length <= minLenth && isEligible(s.substring(i, j), t)) {
                    //更新最短字符串长度
                    minLenth = length;
                    //记录最短字符串位置
                    minWinLeft = i;
                    minWinRight = j;
                    break;
                }
            }
        }
        return minWinRight == Integer.MAX_VALUE ? "" : s.substring(minWinLeft, minWinRight);
    }

    //判断字符串是否符合条件
    private boolean isEligible(String s, String t) {
        HashMap<Character, Integer> charOccurrences = new HashMap<>();
        for (char c : t.toCharArray()) {
            charOccurrences.put(c, charOccurrences.getOrDefault(c, 0) + 1);
        }
        int count = charOccurrences.size();
        for (char c : s.toCharArray()) {
            if (charOccurrences.containsKey(c)) {
                charOccurrences.put(c, charOccurrences.get(c) - 1);
                if (charOccurrences.get(c) == 0)
                    count--;
            }
            if (count == 0)
                return true;
        }
        return false;
    }
}
