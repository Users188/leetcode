package Strings;

import java.util.ArrayList;
import java.util.List;
/**
 * leetcode:生成匹配的括号
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * */
public class GenerateParenthesis {
    List<String> res;
    StringBuilder builder;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        builder = new StringBuilder();

        backtrack(n, n, n);
        return res;
    }

    private void backtrack(int left, int right, int n) {
        if (builder.length() == n * 2 && left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }
        //避免栈溢出，只能加入n个左括号
        if (left > 0){
            //加入左括号
            builder.append("(");
            backtrack(left - 1, right, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        //限定右括号必须在左括号后面加入
        if (right > left) {
            //加入右括号
            builder.append(")");
            backtrack(left, right - 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
