package BTtuan5;
import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    public int front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        QueueUsingTwoStacks s=new QueueUsingTwoStacks();
        Scanner sc= new Scanner(System.in);
        int q=sc.nextInt();
        for(int i=0; i<q; i++){
            int truyvan=sc.nextInt();
            if(truyvan==1){
                int x=sc.nextInt();
                s.enqueue(x);
            }
            if(truyvan==2){
                s.dequeue();
            }
            if(truyvan==3){
                int z=s.front();
                System.out.println(z);
            }
        }
    }
}

