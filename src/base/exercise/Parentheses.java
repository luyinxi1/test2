package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 1.3.4 - 读取标准输入并判断括号是否匹配。
 * @author YCH
 */
public class Parentheses {
    public static void main(String[] args) {
        boolean flag = true;
        Stack<String> stack = new LinkedListStack<>();
        String[] a = {"()", "[]", "{}"};

        while (!StdIn.isEmpty() && flag) {
            String s = StdIn.readString();
            switch (s) {
                case "(" :
                case "[" :
                case "{" : stack.push(s); break;
                default:
                {
                    String temp = stack.pop() + s;
                    flag = (Arrays.binarySearch(a, temp) >= 0);
                    break;
                }
            }
        }
        StdOut.print(flag);
    }

}
