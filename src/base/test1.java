package base;

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 99; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-5d", j, i, i*j);
            }
            System.out.println();
        }

    }
}
