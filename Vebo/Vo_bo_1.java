package BTtuan9;

import java.io.*;
import java.util.*;

public class Vo_bo_1 {

    public static PriorityQueue<Integer> q1 = new PriorityQueue<>();
    public static PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
    public static void add(int key) {
        if (q1.size()> 0 && key > q1.peek()) {
            q1.add(key);
        } else {
            q2.add(key);
        }
        if(q1.size()-q2.size()>1){
            q2.add(q1.remove());
        } else if(q2.size()-q1.size()>1){
            q1.add(q2.remove());
        }
    }

    public static void remove() {
        if (q1.size() > q2.size()) {
            q1.poll();
        } else {
            q2.poll();
        }
    }

    public static void median() {
        int res = 0;
        if (q1.size() > q2.size()) {
            res=q1.peek();
        } else {
            res=q2.peek();
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            add(x);
        }
        for(int j=0; j<m; j++){
            int even = sc.nextInt();
            if(even==1){
                int u=sc.nextInt();
                add(u);
            } else if(even == 2){
                if((q1.size()+q2.size()>0)){ // co it nhat 1 ban
                    remove();
                }
                else return ;
            } else if(even==3){
                if((q1.size()+q2.size()>0))
                {
                    median();
                }
                else System.out.println(0);
            }
        }
    }
}