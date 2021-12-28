package Strings;

/** leetcode:神奇的字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词互不相同。如果给出一个单词，
 * 请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 提示：
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 *
 * */
public class MagicDictionary {
    String[] dict;
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }

    public boolean search(String searchWord) {
        for (String s : dict) {
            if (diff_a_char(s,searchWord))
                return true;
        }
        return false;
    }

    private boolean diff_a_char(String s1,String s2){
        if (s1.length()!=s2.length() || s1.equals(s2))
            return false;
        int count = 0,len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count>1)
                return false;
        }
        return true;
    }

}
