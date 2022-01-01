package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode:最短的单词编码
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 */
public class MinimumLengthEncoding {
    public int minimumLengthEncoding_primitive(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i] != null && words[j] != null) {
                    //"!="不可修改为!equals()
                    if (words[i].endsWith(words[j]) && words[i] != words[j]) {
                        words[j] = null;
                    }
                }
            }
        }
        int ans = 0;
        for (String word : words) {
            if (word != null) {
                ans += word.length() + 1;
            }
        }
        return ans;
    }

    /**
     * 由数据范围可知一个单词最多含有 7 个后缀，所以我们可以枚举单词所有的后缀。
     * 对于每个后缀，如果其存在 words 列表中，我们就将其从列表中删除。
     * 为了高效删除，我们将 words 用哈希集合来存储。
     */
    public int minimumLengthEncoding_modified(String[] words) {
        Set<String> good = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word : good) {
            ans += word.length() + 1;
        }
        return ans;
    }

    /**
     * 将words中的word倒序插入，字典树中的叶子节点就代表没有后缀的单词（即助记符）
     */
    public int minimumLengthEncoding(String[] words) {
        int[] ans = new int[1];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(reverse(word));
        }
        //level初始为1，因为助记符s以‘#’结尾
        trie.countLeaf(trie.root, 1 ,ans);
        return ans[0];
    }

    private String reverse(String s){
        int len = s.length();
        if (len < 2)
            return s;
        String left = reverse(s.substring(0,len/2));
        String right = reverse(s.substring(len/2));
        return right+left;
    }
}
