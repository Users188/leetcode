package Strings;

import java.util.ArrayList;
import java.util.HashSet;
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
}