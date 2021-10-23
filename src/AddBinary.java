/*leetcode:二进制加法*/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary_modified(
                "101", "101"));
    }

    public String addBinary(String a, String b) {

        Integer ia = Integer.parseInt(a, 2);
        Integer ib = Integer.parseInt(b, 2);

        return Integer.toBinaryString(ia + ib);
    }

    public String addBinary_modified(String a, String b) {
        /*双指针, 让两个数的末位对齐, 两个指针 i, j均从各自字符串的末尾开始走。
        定义一个string res 来存放结果, 一个int carry来记录每位的进位值, 初始值设为0。
        算当前位置的数时, sum = a[i] + b[j] + carry, 每趟都要记得更新carry的值。
        循环结束时, 由于低位的数字字符先加到了结果字符串中, 最后还需要 reverse 一次, 让位置恢复正常。*/
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            //两个char类型相减，返回两个字符对应的ASCII码的差值
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum % 2;
//            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
