/*Challenge 3:
Scenario:
You are building a student management system for a school that allows teachers to manage student information. The system should be able to add new students, display student details, calculate average marks, and handle exceptions for invalid inputs. Your task is to create a Java program that implements the necessary classes and methods to achieve these functionalities.
Instructions:
Create a class called "Student" with the following instance variables:
studentId 
name 
marks 
The "Student" class should have the following methods:
A constructor that takes the student ID, name, marks, and total number of subjects as parameters and initializes the instance variables.
Add a method that displays the student's ID, name, and marks for each subject.
Add a method to calculates and returns the average marks of the student.
Custom exception handling for invalid inputs:
Create a custom exception class called "InvalidMarkException" that extends the Exception class. This exception should be thrown when a mark is less than 0 or greater than 100.
In the main method of the program, create multiple Student objects with different student IDs, names, marks, and total subjects. Demonstrate the functionality of the Student class by calling the necessary methods to display student details and calculate average marks. Handle any possible exceptions that may occur.

Sample Output:
Welcome to the Student Management System!
Student Details:
Student ID: S001
Name: John Doe
Marks:
Subject 1: 85
Subject 2: 90
Subject 3: 92
Subject 4: 78
Subject 5: 87
Average Marks: 86.4

Student Details:
Student ID: S001
Name: John Doe
Marks:
Subject 1: 85
Subject 2: 90
Subject 3: 92
Subject 4: 78
Subject 5: -5
Exception: InvalidMarkException - Invalid mark entered: -5
  */
import java.util.*;
import java.util.Scanner;
class StudentDemo{
  int studentId;
  String name;
  int subject1;
  int subject2;
  int subject3;
  int subject4;
  int subject5;
  StudentDemo(int studentId,String name,int subject1,int subject2,int subject3,int subject4,int subject5){
    this.studentId=studentId;
    this.name=name;
    this.subject1=subject1;
    this.subject2=subject2;
    this.subject3=subject3;
    this.subject4=subject4;
    this.subject5=subject5;
  }
  public void details(){
    System.out.println("student details");
    System.out.println("Student Id "+studentId);
    System.out.println("name :"+name);
    System.out.println("Marks");
    System.out.println("Subject 1: "+subject1);
    System.out.println("Subject 2: "+subject2);
    System.out.println("Subject 3: "+subject3);
    System.out.println("Subject 4: "+subject4);
    System.out.println("Subhect 5: "+subject5);
  }
  public void avgMarks(){
    double avg=0,sum=0;
    sum=subject1+subject2+subject3+subject4+subject5;
    avg=sum/5;
    System.out.println("Average Marks: "+avg);
  }
}
class InvalidMarkException extends Exception
  {
    public InvalidMarkException(String str){
      super(str);
    }
  }
class Scenario3{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int id,sub1,sub2,sub3,sub4,sub5;
    String name;
    System.out.println("Enter number of students");
    int n=sc.nextInt();
    StudentDemo std[]=new StudentDemo[n];
    for(int i=0;i<std.length;i++){
      try{
        System.out.println("Enter the "+(1+i)+" Student Details");
        System.out.print("Student Id: ");
        id=sc.nextInt();
        System.out.print("name: ");
        sc.nextLine();
        name=sc.nextLine();
        System.out.print("Subject 1: ");
        sub1=sc.nextInt();
        if(sub1<0)
          throw new InvalidMarkException("Invalid mark entered: "+sub1);
        System.out.print("Subject 2: ");
        sub2=sc.nextInt();
        if(sub2<0)
          throw new InvalidMarkException("Invalid mark entered: "+sub2);
        System.out.print("Subject 3: ");
        sub3=sc.nextInt();
        if(sub3<0)
          throw new InvalidMarkException("Invalid mark entered: "+sub3);
        System.out.print("Subject 4: ");
        sub4=sc.nextInt();
        if(sub4<0)
          throw new InvalidMarkException("Invalid mark entered: "+sub4);
        System.out.print("Subject 5: ");
        sub5=sc.nextInt();
        if(sub5<0)
          throw new InvalidMarkException("Invalid mark entered: "+sub5);
        std[i]=new StudentDemo(id,name,sub1,sub2,sub3,sub4,sub5);
      }
       catch(InvalidMarkException e){
        System.out.println("Exception: "+e.getMessage());
        System.exit(0);
      }
      
    }
   
    System.out.println("Welcome to the Student Management System!");
    for(int i=0;i<std.length;i++){
      System.out.println();
      std[i].details();
      std[i].avgMarks();
    }
  }
}
