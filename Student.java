package Tuan6;

import java.util.List;

 class Student {
     private int id;
     private String fname;
     private double cgpa;
     public Student(int id, String fname, double cgpa) {
         super();
         this.id = id;
         this.fname = fname;
         this.cgpa = cgpa;
     }
     public Student(){

     }
     public int getId() {
         return id;
     }
     public String getFname() {
         return fname;
     }
     public double getCgpa() {
         return cgpa;
     }
     public static void nameSort(List<Student> studentList){
         for(int i = 0; i<studentList.size(); i++){
             Student n= new Student();
             n = studentList.get(i);
             int j=i-1;
             while(j>=0 && studentList.get(j).getFname().compareTo(studentList.get(j+1).getFname())>0){
                 studentList.set(j+1, studentList.get(j));
                 j--;
             }
             studentList.set(j+1, n);
         }
     }
     public static void gpaSort(List<Student> studentList){
         for(int i=0; i<studentList.size(); i++){
             Student gpa= new Student();
             gpa = studentList.get(i);
             int j=i-1;
             while (j>=0 && studentList.get(j+1).getCgpa()>studentList.get(j).getCgpa()){
                 studentList.set(j+1, studentList.get(j));
                 j--;
             }
             studentList.set(j+1, gpa);
         }
     }


     public static void idSort(List<Student> studentList){
         for(int i=0; i<studentList.size(); i++){
             Student id= new Student();
             id = studentList.get(i);
             int j=i-1;
             while (j>=0 && studentList.get(j+1).getCgpa()<studentList.get(j).getCgpa()){
                 studentList.set(j+1, studentList.get(j));
                 j--;
             }
             studentList.set(j+1, id);
         }
     }
     public void SortStudent(List<Student> studentList){
         for(int i=0; i<studentList.size()-1; i++) {
             nameSort(studentList);
         }
         for(int i=0; i<studentList.size()-1; i++) {
             gpaSort(studentList);
         }
//             if(studentList.get(i).getCgpa()== studentList.get(i+1).getCgpa()){
//                 nameSort(studentList);
//                 if(studentList.get(i).getFname()== studentList.get(i+1).getFname()){
//                     idSort(studentList);
//                 }
//             }
         }
     }
