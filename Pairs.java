package BTtuan11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static int pairs(int k, List<Integer> array) {
        // Write your code here

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        for (int i : array) {
            if (set.contains(i + k)) {
                count++;
            }
        }
        return count;
    }
}
