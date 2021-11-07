package Strings;

import java.util.*;

/*leetcode:变位词组*/
/*给定一个字符串数组 strs ，将变位词组合在一起。 可以按任意顺序返回结果列表。
注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
*/
/*str[i]仅包含小写字母*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams_primitive(String[] strs){
        List<String> strings = new LinkedList<>(Arrays.asList(strs));
        List<List<String>> results=new LinkedList<>();
        while (!strings.isEmpty()){
            List<String> result=new LinkedList<>();
            String baseString=strings.get(0);
            for (String curString : strings) {
                if (isAnagram(curString, baseString))
                    result.add(curString);
            }
            for(String rm:result){
                strings.remove(rm);
            }

            results.add(result);
        }
        return results;
    }

    public List<List<String>> groupAnagrams_ultimate(String[] strs){
        //以排序过的字符串为key，将其对应的变位词作为其值
        Map<String,List<String>> stringListMap=new HashMap<>();
        for(String s:strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=String.copyValueOf(chars);
            List<String> values=stringListMap.getOrDefault(key,new ArrayList<>());
            values.add(s);
            stringListMap.put(key,values);
        }
        return new ArrayList<>(stringListMap.values());
    }

    private boolean isAnagram(String s,String t){
        if (s.length()!=t.length())
            return false;
        if (s.equals(t))
            return true;
        int[] countChar=new int[26];
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char s_char=s.charAt(i);
            char t_char=t.charAt(i);
            countChar[s_char-'a']++;
            countChar[t_char-'a']--;
        }
        for(int count:countChar){
            if (count!=0)
                return false;
        }
        return true;
    }

}
