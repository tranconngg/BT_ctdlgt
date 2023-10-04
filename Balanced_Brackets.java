package BTtuan5;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Balanced_Brackets {
    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') { //neu la may dau dong ngoac thi kiem tra luon stack neu khong co gi the tra ve NO luon
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return "NO";
                }
            }
        }

        // sau vong lap ma van con sot lai dau trong stack thi tra ve NO
        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
}
