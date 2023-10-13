package BTtuan5;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class SimpleText {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int q = scanner.nextInt();

            StringBuilder sb = new StringBuilder();

            Stack<String> undoStack = new Stack<>();

            for (int i = 0; i < q; i++) {
                int opera = scanner.nextInt();

                if (opera == 1) {
                    // append
                    undoStack.push(sb.toString());
                    String appendStr = scanner.next();
                    sb.append(appendStr);

                } else if (opera == 2) {
                    // delete
                    undoStack.push(sb.toString());
                    int k = scanner.nextInt();
                    sb.delete(sb.length() - k, sb.length());

                } else if (opera == 3) {
                    // print
                    int k = scanner.nextInt();
                    System.out.println(sb.charAt(k - 1));

                } else if (opera == 4) {
                    // undo
                    if (!undoStack.isEmpty()) {
                        sb = new StringBuilder(undoStack.pop());
                    }
                }
            }
        }
    }
