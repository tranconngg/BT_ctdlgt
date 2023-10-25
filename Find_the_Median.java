package Tuan7;
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
public class Find_the_Median {
    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;

                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }

        int temp = arr.get(i+1);
        arr.set(i+1,arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int findMedian(List<Integer> arr) {

        quickSort(arr, 0, arr.size()-1);

        int median;
        if (arr.size() % 2 == 0) {
            int middleIndex = arr.size() / 2;
            median = (arr.get(middleIndex - 1) + arr.get(middleIndex)) /2;
        } else {
            int middleIndex = arr.size() / 2;
            median = arr.get(middleIndex);
        }

        return median;
    }
}
