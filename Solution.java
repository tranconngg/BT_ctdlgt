package Tuan6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Complete the code
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Student m = new Student();
        m.SortStudent(studentList);
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
