/*leetcode:二进制加法*/
public class AddBinary {
    public String addBinary(String a,String b){

        Integer ia=Integer.parseInt(a,2);
        Integer ib=Integer.parseInt(b,2);

        return Integer.toBinaryString(ia+ib);
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("-101","101"));
    }
}
