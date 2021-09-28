/*leetcode:整数除法*/
public class Divide {
    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
    // 所以，我们将 a 和 b 都转成负数
    // 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
    public int divide_primitive(int a, int b) {
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        // ^异或符号
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    public int divide_modified(int dividend, int divisor) {
        //特殊情况-2^31/-1 会溢出
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //记录负数的个数，并将两数都转为负数
        int negative = 2;
        if(dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if(divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        //两个负数的除法
        int result = 0;
        //注意是两个负数的比较大小
        while(dividend <= divisor){
            //value用来存储除数翻倍后的值
            int value = divisor;
            //quotient用来存储除数翻的倍数
            int quotient = 1;
            //除数每次从1倍开始翻倍。直到-2^31的一半-2^30
            while(value >= Integer.MIN_VALUE>>1 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            //倍数累加为商
            result += quotient;
            //被除数减去这部分除数翻倍后的值
            dividend -= value;
        }
        //根据负号对商进行符号的修改
        return negative == 1 ? -result : result;
    }

    // 时间复杂度：O(1)
    public int divide_ultimate(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
}
