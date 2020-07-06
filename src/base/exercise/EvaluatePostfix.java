package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.11 - 后序表达式求值。
 * @author YCH
 */
public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> stack = new LinkedListStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": stack.push(-stack.pop() + stack.pop()); break;
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": stack.push(stack.pop() / stack.pop()); break;
                default: stack.push(Double.parseDouble(s));
            }
        }
        System.out.println(stack.pop());
    }
}
