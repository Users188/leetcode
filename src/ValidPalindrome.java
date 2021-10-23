/*leetcode:最多删除一个字符获得回文串*/
/*s由小写字母组成*/
public class ValidPalindrome {
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
}
