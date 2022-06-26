/*
 * Link para questão: https://iudex.io/problem/5b886db33f792000014ace8d/statement
 */

import java.util.Scanner;
import java.util.Stack;

public class Chaves {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        char[] chars = data.toCharArray();
        input.close();

        Stack<Character> brackets = new Stack<Character>();
        boolean wrongClosed = false;
        for (char a : chars) {
            if (a == '{') {
                brackets.push(a);
            } else if (a == '}') {
                if (brackets.empty()) {
                    wrongClosed = true;
                    break;
                } else {
                    brackets.pop();
                }
            }
        }

        if (!wrongClosed && brackets.empty()) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
