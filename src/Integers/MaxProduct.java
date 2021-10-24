package Integers;

/*leetcode:单词长度的最大乘积*/
public class MaxProduct {
    public int maxProduct_primitive(String[] words) {
        //暴力破解法
        int maxproduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasSameChar_primitive(words[i], words[j]))
                    maxproduct = Math.max(maxproduct, words[i].length() * words[j].length());
            }
        }
        return maxproduct;
    }

    private boolean hasSameChar_primitive(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            //java字符串中查找字符，若indexOf方法找不到则返回-1
            if (word2.indexOf(c) != -1)
                return true;
        }
        return false;
    }

    public int maxProduct_ultimate(String[] words) {
        int maxproduct = 0;
        int[] bitMasks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                //一个单词由26个小写字母组成（题意），每个单词可能出现或不出现，抽象为26位数由低到高分别表示a-z是否出现，出现为1，不出现为0。
                //tip：类比子网掩码
                bitMasks[i] |= (1 << words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < bitMasks.length - 1; i++) {
            for (int j = i + 1; j < bitMasks.length; j++) {
                //如果两个单词没有重复字符，则每位进行与运算时不会有1&1=1，运算结果恒为0
                if ((bitMasks[i] & bitMasks[j]) == 0)
                    maxproduct = Math.max(maxproduct, words[i].length() * words[j].length());
            }
        }
        return maxproduct;
    }
}
