package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.10 - 过滤器，将中序表达式转换为后序表达式。
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new LinkedListStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+" :
                case "-" :
                case "*" :
                case "/" : stack.push(s); break;
                case "(" : break;
                case ")" :
                    StdOut.print(stack.pop() + " "); break;
                default: StdOut.print(s + " ");
            }
        }
    }
}
