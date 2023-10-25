package Tuan7;
import java.util.*;
public class Quicksort1_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < pivot) {
                left.add(arr.get(i));
            } else if (arr.get(i) == pivot) {
                equal.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        left.addAll(equal);
        left.addAll(right);

        for (int i = 0; i < arr.size(); i++) {
            arr.set(i,left.get(i));
        }
        return arr;

    }

}
