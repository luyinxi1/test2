package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.9 - 补全一个缺少左括号的中序表达式。
 * @author YCH
 */
public class LeftBracketCompletion {
    public static void main(String[] args) {
        Stack<String> vals = new LinkedListStack<>();
        Stack<String> ops = new LinkedListStack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+" :
                case "-" :
                case "*" :
                case "/" : ops.push(s + " "); break;
                case ")" :
                {
                    String val1 = vals.pop();
                    String val2 = vals.pop();
                    String temp = "( " + val2 + ops.pop() + val1 + ") ";
                    vals.push(temp);
                }; break;
                default: vals.push(s + " ");
            }
        }
        if (!ops.isEmpty()) {
            throw new RuntimeException("表达式括号输入有误，左右不完全匹配");
        }
        StdOut.print(vals.pop());
    }
}
