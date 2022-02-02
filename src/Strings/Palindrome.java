package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Palindrome {
    /**leetcode:最多删除一个字符获得回文串
     * s由小写字母组成
     * */
    public boolean validPalindrome(String s) {
        //暴力解法，注意左右两边都要试一下
        int delete = 0;
        //删除从右边开始删
        int first = 0, last = s.length() - 1;
        while (first < last && delete <= 1) {
            if (s.charAt(first) == s.charAt(last))
                first++;
            else
                delete++;
            last--;
        }
        if (delete > 1) {
            //如果从右边删没有得到结果，从左边开始删
            delete = 0;
            first = 0;
            last = s.length() - 1;
            while (first < last && delete <= 1) {
                if (s.charAt(first) == s.charAt(last))
                    last--;
                else
                    delete++;
                first++;
            }
            return delete <= 1;
        } else
            return true;
    }

    /**leetcode:有效的回文
     * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
     * 本题中，将空字符串定义为有效的 回文串 。
     * */
    public boolean isPalindrome_recursion(String s) {
        //递归解法
        int len = s.length();
        if (len == 0 || len == 1)
            return true;
        if (s.charAt(0) == s.charAt(len - 1))
            return isPalindrome(s.substring(1, len - 1));
        return false;
    }

    public boolean isPalindrome_ultimate(String s) {
        s = simplifiedString(s);
        return isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        //双指针
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    public String simplifiedString(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> res = new ArrayList<>();
        Set<Character> validChars = new HashSet<>();
        Set<Character> upperChars = new HashSet<>();
        for (char c = '0'; c <= '9'; c++) {
            validChars.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            validChars.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            upperChars.add(c);
        }
        for (char aChar : chars) {
            if (!validChars.contains(aChar)) {
                if (upperChars.contains(aChar)) {
                    res.add((char) (aChar + 'a' - 'A'));
                }
            } else
                res.add(aChar);
        }
        chars = new char[res.size()];
        for (int i = 0; i < res.size(); i++) {
            chars[i] = res.get(i);
        }
        return String.copyValueOf(chars);
    }

    /**
     * leetcode:分割回文子字符串
     * 给定一个字符串 s ，请将 s 分割成一些子串，
     * 使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     */
    public String[][] partition_dp(String s) {
        int n = s.length();
        //动态规划，dp[i][j]表示s[i...j]是否为回文
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[i - 1][j + 1]))
                    dp[i][j] = true;
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack1(res, path, s, dp, 0);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    private void backtrack1(List<List<String>> lists, List<String> list,
                            String s, boolean[][] dp, int start) {
        if (start == s.length()) {
            lists.add(List.copyOf(list));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            //如果s[start,end]为回文
            if (dp[start][end]) {
                //subString方法取左闭右开区间
                list.add(s.substring(start, end + 1));
                //传递end+1,避免重叠
                backtrack1(lists, list, s, dp, end + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public String[][] partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(res,path,s,0);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    private void backtrack(List<List<String>> lists, List<String> list,
                           String s, int start) {
        if (start == s.length()) {
            lists.add(List.copyOf(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (isPalindrome(subString)) {
                list.add(subString);
                backtrack(lists, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
