package BTtuan9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Java_map {
    public static void main(String[] args) {
        Map<String, Integer> m= new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=sc.nextLine();
            int phone=sc.nextInt();
            sc.nextLine();
            m.put(name, phone);
        }
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            if(!(m.containsKey(s))){
                System.out.println("Not found");
            }
            else {
                int sdt=m.get(s);
                System.out.println(s+"="+sdt);
            }
        }
    }

}
