package Strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode:替换单词
 * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 需要输出替换之后的句子。
 * <p>
 * 提示：
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 */

public class ReplaceWords {
    public String replaceWords_primitive(List<String> dictionary, String sentence) {
        StringBuilder ret = new StringBuilder();
        Trie trie = new Trie();
        dictionary.sort((Comparator.comparingInt(String::length)));
        List<String> simplifiedDict = new ArrayList<>();
        for (String s : dictionary) {
            if (!trie.startsWith(s)) {
                trie.insert(s);
                simplifiedDict.add(s);
            }
        }
        for (String s : sentence.split(" ")) {
            boolean isSuccessor = false;
            for (String root : simplifiedDict) {
                if (s.startsWith(root)) {
                    ret.append(root).append(' ');
                    isSuccessor = true;
                    break;
                }
            }
            if (!isSuccessor)
                ret.append(s).append(' ');
        }
        if (ret.charAt(ret.length() - 1) == ' ')
            ret.deleteCharAt(ret.length() - 1);
        return ret.toString();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ret = new StringBuilder();
        Trie trie = new Trie();
        for (String s : dictionary)
            trie.insert(s);
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (trie.searchWordPrefix(word))
                ret.append(trie.replace(word)).append(" ");
            else
                ret.append(word).append(" ");
        }
        ret.deleteCharAt(ret.length() - 1);
        return ret.toString();
    }
}
