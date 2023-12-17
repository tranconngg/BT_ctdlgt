package BTtuan11;

import java.util.*;

public class missingNumber {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> missing = new ArrayList<>();
        for (int i : brr) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
            } else {
                missing.add(i);
            }
        }
        Collections.sort(missing);
        return missing;
    }
}
