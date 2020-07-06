package base.exercise;

import base.stack.LinkedListStack;
import base.stack.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.15 - 接收一个命令行参数，并打印出标准输出中的倒数第k个字符。
 * @author YCH
 */
public class QueuePrint {
    public static void main(String[] args) {
        Stack<String> stack = new LinkedListStack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readString());
        }

        int a = Integer.parseInt(args[0]);
        int n = stack.size() - a;
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        System.out.println(stack.pop());

    }
}
