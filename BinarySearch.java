package BTtuan1CTGL;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] a, int number){
        int l=0, r=a.length-1;
        while (l<=r)
        {
            int mid=(l+r)/2;
            if(a[mid]==number) return mid;
            else if(a[mid]>number) r=mid-1;
            else if(a[mid]<number) l=mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number;
        number=sc.nextInt();
        int[] a={1,2,3,4,5};
        binarySearch(a,number);
    }
}
