package search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author acer
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<>();

        int i = 0;
        String temp = null;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }

            temp = word;
            i++;
        }
        System.out.println(temp + " " + i);

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        System.out.println(max + " " + st.get(max));
    }
}
