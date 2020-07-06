package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;

/**
 * 1.3.12 - 栈的复制。
 */
public class CopyStack {
    public static void main(String[] args) {
        Stack<String> stack = new LinkedListStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        for (String s : copy(stack)) {
            System.out.print(s + " ");
        }
    }
    private static Stack<String> copy(Stack<String> stack) {
        Stack<String> stringStack = new LinkedListStack<>();
        for (String s : stack) {
            stringStack.push(s);
        }

        return stringStack;
    }
}
