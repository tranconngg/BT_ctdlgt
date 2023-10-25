package Tuan7;
import java.io.*;
import java.util.*;

public class QuicksortIn_Place
        {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Chon pivot
            int pivotIndex = partition(arr, low, high);

            // Sap xep cac phan tu nua truoc pivot
            quickSort(arr, low, pivotIndex - 1);

            // Sap xep cac phan tu nua sau pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);

            }
        }

        swap(arr, i + 1, high);
        printArray(arr);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, n - 1);


        scanner.close();
    }
}
