package HashMaps;
/*leetcode:外星语言是否排序*/

import java.util.HashMap;
import java.util.Map;

/*1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
在words[i]和order中的所有字符都是英文小写字母。
*/
public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            orderMap.put(order.charAt(i), i);
        }
        /*借鉴冒泡排序，每两个相邻的单词比较*/
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            //比较w1与w2都有的公共长度部分
            for (int j = 0; j < len; j++) {
                char w1Char = w1.charAt(j);
                char w2Char = w2.charAt(j);
                if (w1Char != w2Char) {
                    if (orderMap.get(w1Char) > orderMap.get(w2Char))
                        return false;
                    else
                        break;
                }
                //如果公共长度部分都是一样的字符，则比较两者长度
                if (j == len - 1 && w1.length() > w2.length())
                    return false;
            }
        }
        return true;
    }
}
