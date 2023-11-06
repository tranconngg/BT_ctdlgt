package BTtuan9;
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
public class Closest_Numbers {
    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);

            }
        }

        swap(arr, i + 1, high);
        // printArray(arr);

        return i + 1;
    }
    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            // Chon pivot
            int pivotIndex = partition(arr, low, high);

            // Sap xep cac phan tu nua truoc pivot
            quickSort(arr, low, pivotIndex - 1);

            // Sap xep cac phan tu nua sau pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        quickSort(arr, 0, arr.size()-1);
        int minDiff = Integer.MAX_VALUE;
        List<Integer> closestPairs = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        // tim su chenh lech nho nhat giua cac cap so lien ke
        for (int i = 1; i < arr.size(); i++) {
            int chechlech = arr.get(i) - arr.get(i-1);

            // neu su chech lech nho hon minDiff, cap nhat minDiff va clear danh sach cac cap gan nhat
            if (chechlech < minDiff) {
                minDiff = chechlech;
                closestPairs.clear();
            }


            // neu su chech lech bang minDiff, them cap so lien ke vao danh sach
            if (chechlech == minDiff) {
                closestPairs.add(arr.get(i-1));
                closestPairs.add(arr.get(i));
            }

        }
        for(int i = 0; i<closestPairs.size(); i+=2){
            result.add(closestPairs.get(i));
            result.add(closestPairs.get(i+1));

        }

        return result;
    }
}
