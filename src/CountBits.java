/*leetcode:前n个数字二进制中1的个数*/
public class CountBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];//new的新数组会被0填充
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) { //偶数
                ans[i] = ans[i >> 1];
                System.out.println(i);
            } else { //奇数
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }

}
