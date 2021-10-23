/*leetcode:回文子串的个数*/
/*给定一个字符串 s（s由小写字母组成），请计算这个字符串中有多少个回文子字符串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。*/
public class CountSubStrings {
    public int countSubStrings(String s){
        //暴力解法
        int count=s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j++) {
                if (new IsPalindrome().isPalindrome(s.substring(i,j)))
                    count++;
            }
        }
        return count;
    }

    public int countSubStrings_dp(String s){
        //动态规划(dynamic programming)
        //参考：https://houbb.github.io/2020/01/23/data-struct-learn-07-base-dp
        int n=s.length(),count=0;
        //dp[i][j]表示s[i..j]是否为回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j>=0; j--) {
                //新的回文=相等的左右两边字符+旧的回文
                if (s.charAt(i)==s.charAt(j)){
                    //i-j<=1用于表示回文的中心（判断根据）
                    if (i-j<=1){
                        dp[i][j]=true;
                    }
                    else {
                        dp[i][j]=dp[i-1][j+1];
                    }
                }
                count+=dp[i][j]?1:0;
            }
        }
        return count;
    }
}
