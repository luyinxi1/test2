package base.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 双栈算术表达式求值。
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<Double> values = new LinkedListStack<>();
        Stack<String> ops = new LinkedListStack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(" : break;
                case "+" :
                case "-" :
                case "*" :
                case "/" : ops.push(s); break;
                case ")" :
                    {
                        String op = ops.pop();
                        double v = values.pop();
                        if ("+".equals(op)) {
                            v = values.pop() + v;
                        } else if ("-".equals(op)) {
                            v = values.pop() - v;
                        } else if ("*".equals(op)) {
                            v = values.pop() * v;
                        } else if ("/".equals(op)) {
                            v = values.pop() / v;
                        }
                        values.push(v);
                    }; break;
                default: values.push(Double.parseDouble(s)); break;
            }
        }
        StdOut.println(values.pop());
    }


}
