import java.util.Arrays;

public class ATest {
    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

    public static void main(String[] args) {
        System.out.println(1<<4);
        System.out.println(getType('1'-'0'));
        System.out.println(Arrays.toString(new int[5]));
    }
}
