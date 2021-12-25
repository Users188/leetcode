package Strings;

/**
 * leetcode:实现前缀树
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
 */

//26叉树
public class Trie {
    TreeNode root;
    boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode();
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new TreeNode();
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        int count = 0;
        for (char c : prefix.toCharArray()) {
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    class TreeNode {
        boolean isEnd;
        TreeNode[] next;

        public TreeNode() {
            next = new TreeNode[26];
        }
    }
}

