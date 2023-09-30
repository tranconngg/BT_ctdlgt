import java.util.Scanner;

public class union_find {
    static int root[] = new int[100];

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int dinh = sc.nextInt();
        int res = dinh;
        while ((sc.hasNextInt())) {
          int x= sc.nextInt();
          int y= sc.nextInt();
            if (x != y) {
                res--;
                if (root[x] < root[y]) {
                    root[y] += root[x];
                    root[x] = y;
                } else {
                    root[x] += root[y];
                    root[y] = x;
                }

            }
        }
        System.out.println(res);
    }
}
