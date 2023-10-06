package BTtuan5;

public class Equal_Stack {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here

        Stack <Integer> st1= new Stack<>();
        Stack <Integer> st2=new Stack<>();
        Stack <Integer> st3=new Stack<>();
        long sum1=0, sum2=0, sum3 =0;
        boolean check=false;

        for(int i=h1.size()-1; i>=0; i--){
            st1.push(h1.get(i));
            sum1+=h1.get(i);
        }
        for(int i=h2.size()-1; i>=0; i--){
            st2.push(h2.get(i));
            sum2+=h2.get(i);
        }
        for(int i=h3.size()-1; i>=0; i--){
            st3.push(h3.get(i));
            sum3+=h3.get(i);
        }
        // tim cai stack nao cao nhat thi tru dan di
        while(true){
            if(st1.isEmpty()|| st2.isEmpty() || st3.isEmpty()){
                break;
            }
            if(sum1==sum2 && sum2==sum3){
                check=true;
                break;
            }
            if(sum1>=sum2 && sum1 >=sum3){
                sum1 -= st1.pop();
            }
            else if(sum2>=sum1 && sum2 >=sum3){
                sum2 -= st2.pop();
            }
            else if(sum3>=sum1 && sum3 >=sum2){
                sum3 -= st3.pop();
            }

        }
        if(check==true){
            return (int)sum1; //sum nao cung dc
        }
        else return 0;
    }
}
