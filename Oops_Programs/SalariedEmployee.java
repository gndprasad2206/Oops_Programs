
/*
Challenge 1:
You are building a payroll system for a company that has two types of employees: salaried employees and hourly employees. The payroll system needs to calculate the monthly salary for each employee based on their specific type and hours worked. Additionally, the system should demonstrate polymorphism by calculating the monthly salary for different types of employees.
Sample Input:
For Salary Base Employee
Enter Employee Name: John Doe
Enter Employee Id : 1001, 
Enter Employee Salary: 5000.0

For hourly Based Employee
Enter Employee Name: Jane Smith
Enter Employee Id : 1002
Enter Employee Salary: 5000.0
Enter Hourly Rate:  200.0
Enter hoursWorked : 150.0
Sample Output:
Employee Name: John Doe
Employee ID: 1001
Monthly Salary:  5000.0
Employee Name: Jane Smith
Employee ID: 1002
Monthly  Salary: 30000.0
  */
import java.util.Scanner;

class SalariedEmployee {
    private String name;
    private int id;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

class HourlyBasedEmployee {
    private String name;
    private int id;
    private double salary;
    private double hourlyRate;
    private double hourWorked;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHourWorked(double hourWorked) {
        this.hourWorked = hourWorked;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return (hourlyRate * hourWorked);
    }
}

public class Scenario1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of salaried employees");
        int n = sc.nextInt();
        SalariedEmployee salEmp[] = new SalariedEmployee[n];
        for (int i = 0; i < salEmp.length; i++) {
            salEmp[i] = new SalariedEmployee();
            System.out.println("Entre the " + (1 + i) + " Employee details");
            System.out.print("Name :");
            sc.nextLine();
            salEmp[i].setName(sc.nextLine());
            System.out.print("Id :");
            salEmp[i].setId(sc.nextInt());
            System.out.print("Salary :");
            salEmp[i].setSalary(sc.nextDouble());
        }
        System.out.println("Enter the number of Hourly Based Employees ");
        int m = sc.nextInt();
        HourlyBasedEmployee hourEmp[] = new HourlyBasedEmployee[m];
        for (int i = 0; i < hourEmp.length; i++) {
            hourEmp[i] = new HourlyBasedEmployee();
            System.out.println("Entre the " + (1 + i) + " Employee details");
            System.out.print("Name :");
            sc.nextLine();
            hourEmp[i].setName(sc.nextLine());
            System.out.print("Id :");
            hourEmp[i].setId(sc.nextInt());
            System.out.print("Salary :");
            hourEmp[i].setSalary(sc.nextDouble());
            System.out.print("Hourly rate :");
            hourEmp[i].setHourlyRate(sc.nextDouble());
            System.out.print("Hours Worked :");
            hourEmp[i].setHourWorked(sc.nextDouble());
        }
        for (int i = 0; i < salEmp.length; i++) {
            System.out.println();
            System.out.println("Employee Name: " + salEmp[i].getName());
            System.out.println("Employee ID: " + salEmp[i].getId());
            System.out.println("Monthly Salary: " + salEmp[i].getSalary());
        }
        for (int i = 0; i < hourEmp.length; i++) {
            System.out.println();
            System.out.println("Employee Name: " + hourEmp[i].getName());
            System.out.println("Employee ID: " + hourEmp[i].getId());
            System.out.println("Monthly Salary: " + hourEmp[i].getSalary());
        }
    }
}