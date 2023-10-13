package Tuan6;

import java.util.List;

public class InsertionSort2 {
    public static void prinArr(List<Integer> arr){
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+ " ");
        }
        System.out.println();
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for(int i=1; i<n; i++){
            int val=arr.get(i);
            int j=i-1;
            while(j>=0 && arr.get(j)> val){
                arr.set(j+1, arr.get(j));
                j--;
               // prinArr(arr);
            }
            arr.set(j+1,val);
            prinArr(arr);
        }
       // prinArr(arr);

    }

}
