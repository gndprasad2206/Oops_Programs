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
  class SalariedEmployee{
    private String name;
    private int id;
    private double salary;
    public void setName(String name){
      this.name=name;
    }
    public void setId(int id){
      this.id=id;
    }
    public void setSalary(double salary){
      this.salary=salary;
    }
    public String getName(){
      return name;
    }
    public int getId(){
      return id;
    }
    public double getSalary(){
      return salary;
    }
  }
  class HourlyBasedEmployee {
    private String name;
    private int id;
    private double salary;
    private double hourlyRate;
    private double hourWorked;
    public void setName(String name){
      this.name=name;
    }
    public void setId(int id){
      this.id=id;
    }
    public void setSalary(double salary){
      this.salary=salary;
    }
    public void setHourlyRate(double hourlyRate){
      this.hourlyRate=hourlyRate;
    }
    public void setHourWorked(double hourWorked){
      this.hourWorked=hourWorked;
    }
    public String getName(){
      return name;
    }
    public int getId(){
      return id;
    }
    public double getSalary(){
      return (hourlyRate*hourWorked);
    }  
  }
  public class Scenario1{
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the number of salaried employees");
      int n=sc.nextInt();
      SalariedEmployee salEmp[]=new SalariedEmployee[n];
      for(int i=0;i<salEmp.length;i++){
        salEmp[i]=new SalariedEmployee();
        System.out.println("Entre the "+(1+i)+" Employee details");
        System.out.print("Name :");
        sc.nextLine();
        salEmp[i].setName(sc.nextLine());
        System.out.print("Id :");
        salEmp[i].setId(sc.nextInt());
        System.out.print("Salary :");
        salEmp[i].setSalary(sc.nextDouble());
      }
      System.out.println("Enter the number of Hourly Based Employees ");
      int m=sc.nextInt();
      HourlyBasedEmployee hourEmp[]=new HourlyBasedEmployee[m];
      for(int i=0;i<hourEmp.length;i++){
        hourEmp[i]=new HourlyBasedEmployee();
        System.out.println("Entre the "+(1+i)+" Employee details");
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
      for(int i=0;i<salEmp.length;i++){
        System.out.println();
        System.out.println("Employee Name: "+salEmp[i].getName());
        System.out.println("Employee ID: "+salEmp[i].getId());
        System.out.println("Monthly Salary: "+salEmp[i].getSalary());
      }
      for(int i=0;i<hourEmp.length;i++){
        System.out.println();
        System.out.println("Employee Name: "+hourEmp[i].getName());
        System.out.println("Employee ID: "+hourEmp[i].getId());
        System.out.println("Monthly Salary: "+hourEmp[i].getSalary());
      }
    }
  }/*Challenge 2:
Scenario: Online Shopping Platform Product Data Input
You are a software developer working for an online shopping platform. The platform allows customers to purchase a wide variety of products. Your task is to develop a program that allows the platform administrators to input product data dynamically and validate the inputs according to specific requirements. The program should also display the data for all the products entered.
As per the requirements, each product should have the following attributes: productId, productName, price, category, and quantityInStock. The program should enforce the following validations:
1.	productId: A unique 4-digit number.
2.	productName: A name between 2 and 50 characters in length.
3.	price: A positive value (in dollars).
4.	category: The category or type of the product.
5.	quantityInStock: A positive integer indicating the quantity of the product available in stock.
Your task is to implement a Java program that fulfills these requirements. The program should allow the user to input data for five products dynamically. Each product's data should be validated according to the mentioned rules. After inputting the data for all five products, the program should display the entered product data for verification.
In addition, you are required to add a custom exception for the price attribute. If the price entered for a product is not a positive value, an InvalidPriceException should be thrown with an appropriate error message.
Write the Java program that implements the above requirements, including input validation and displaying the product data.

Example Input and Output:
Sample Input:
Enter data for product 1:
Product ID: P001
Product Name: Laptop
Price: 1500.0
Category: Electronics
Quantity in Stock: 10

Enter data for product 2:
Product ID: P002
Product Name: T-Shirt
Price: -34.4
Category: Clothing
Quantity in Stock: 50

Output:
Product ID: P001
Product Name: Laptop
Price: 1500.0
Category: Electronics
Quantity in Stock: 10

Product ID: P002
Product Name: T-Shirt
InvalidPriceException : Invalid price format, please enter a positive value
Category: Clothing
Quantity in Stock: 50
  */
import java.util.Scanner;
class Shooping{
  private String id;
  private String name;
  private double price;
  private String category;
  private int quantity;
  public void setId(String id){
    this.id=id;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setPrice(double price){
    this.price=price;
  }
  public void setCategogy(String category){
    this.category=category;
  }
  public void setQuantity(int quantity){
    this.quantity=quantity;
  }
  public String getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public double getPrice(){
    return price;
  }
  public String getCategory(){
    return category;
  }
  public int getQuantity(){
    return quantity;
  }
}
class InvalidPriceException extends Exception{
  public InvalidPriceException(String str){
    super(str);
  }
}
public class Scenario2 extends Shooping{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the count of products");
    int n=sc.nextInt();
    Shooping shop[]=new Shooping[n];
    for(int i=0;i<shop.length;i++){
      System.out.println("Enter data for product "+(1+i));
      shop[i]=new Shooping();
      System.out.print("Product ID: ");
      sc.nextLine();
      String id=sc.nextLine();
      shop[i].setId(id);
      System.out.print("Product Name: ");
      //sc.nextLine();
      String name=sc.nextLine();
      shop[i].setName(name);
      System.out.print("Price: ");
      double price=sc.nextDouble();
      shop[i].setPrice(price);
      System.out.print("Category: ");
      sc.nextLine();
      String category=sc.nextLine();
      shop[i].setCategogy(category);
      System.out.print("Quantity in Stock: ");
      int quantity=sc.nextInt();
      shop[i].setQuantity(quantity);
    }
    for(int i=0;i<shop.length;i++){
      System.out.println();
      System.out.println("Product ID: "+shop[i].getId());
      System.out.println("Product Name: "+shop[i].getName());
      try{
        if(shop[i].getPrice()<0){
          throw new InvalidPriceException("Invalid price format, please enter a positive value");
          
        }
        else{
          System.out.println("Price :"+shop[i].getPrice());
        }
      }
      catch(InvalidPriceException e){
        System.out.println("InvalidPriceException: "+e.getMessage());
      }
      System.out.println("Category :"+shop[i].getCategory());
      System.out.println("Quantity :"+shop[i].getQuantity());
    }
  }
}