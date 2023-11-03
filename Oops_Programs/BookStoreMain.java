/*Challenge- 1: 

As a manager of a book shop, you are responsible for managing all the operations related to books in the shop. You have a system that stores all the book details(book_id, title, author, price) in an ArrayList of Book objects. 

Your task is to create a Java program that helps you manage the book shop efficiently.  

Create a console-based menu-driven program that allows the user to perform the following operations: 

1. Add books 

2. Calculate total price of all books 

3. Remove a book by book_id 

4. Update book price by book_id 

5. Search books by author 

6. Quit the program 

If no books are found for the given author name, the method should throw a custom exception called BookNotFoundException with an appropriate error message. 

Each menu option should call the corresponding method and display the results or appropriate error messages.    */
import java.util.*;
class Book_7{
  private static int  nextId=1;
  private int id;
  private String title;
  private String author;
  private double price;
  public Book_7(String title,String author,double price){
    this.id=nextId++;
    this.title=title;
    this.author=author;
    this.price=price;
  }
  public int getId() {
	 return id;
  }
  public String getTitle() {
	 return title;
  }
  public String getAuthor() {
	 return author;
  }
  public void setPrice(double price){
    this.price=price;
  }
  public double getPrice() {
	 return price;
  }
}
class Store_7{
  Scanner sc=new Scanner(System.in);
  ArrayList<Book_7> books=new ArrayList<Book_7>();
  public void addBook(Book_7 b){
    books.add(b);
    System.out.println("New Book Added Successfully");
  }
  public void priceOfAllBooks(){
    double totalPrice=0;
    boolean b=books.isEmpty();
    if(b==false){
      for(Book_7 book:books){
        totalPrice=totalPrice+book.getPrice();
      }
      System.out.println("Price Of All Books: "+totalPrice);
    }
    else{
      System.out.println("The Store is Empty");
    }
  }
  public void removeWithId(int id){
    boolean b=books.isEmpty();
    int c=0;
    if(b==false){
      for(Book_7 book:books){
        if(book.getId()==id){
          System.out.println("Book Id: "+book.getId());
          System.out.println("Book Title: "+book.getTitle());
          System.out.println("Book Author: "+book.getAuthor());
          System.out.println("Book Price: "+book.getPrice());
          books.remove(book);
          c++;
        }
      }
      if(c==0){
        System.out.println("Book is not found with Id: "+id);
      }
    }
    else{
      System.out.println("Store is Empty");
    }
  }
  public void updatePriceWithId(int id){
    boolean b=books.isEmpty();
    int c=0;
    if(b==false){
      for(Book_7 book:books){
        if(book.getId()==id){
          System.out.print("Enter New Price: ");
          double price1=sc.nextDouble();
          book.setPrice(price1);
          System.out.println("Updated Price Successfully");
          c++;
        }
      }
      if(c==0){
        System.out.println("Book is not found with Id: "+id);
      }
    }
    else{
      System.out.println("Store is Empty");
    }
  }
  public void searchWithAuthor(String author){
    boolean b=books.isEmpty();
    int c=0;
    if(b==false){
      for(Book_7 book:books){
        if(book.getAuthor().equalsIgnoreCase(author)){
          System.out.println("Book Id: "+book.getId());
          System.out.println("Book Title: "+book.getTitle());
          System.out.println("Book Author: "+book.getAuthor());
          System.out.println("Book Price: "+book.getPrice());
          c++;
        }
      }
      if(c==0){
        try{
          throw new BookNotFoundException("BookNotFoundException");
        }
        catch(BookNotFoundException e){
          System.out.println("Exception: "+e.getMessage());
        }
      }
    }
    else{
      System.out.println("Store is Empty");
    }
  }
}
class BookNotFoundException extends Exception{
  public BookNotFoundException(String str){
    super(str);
  }
}
public class BookStoreMain{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    Store_7 s=new Store_7();
    while(true){
      System.out.println();
      System.out.println("1. Add books\n2. Calculate total price of all books\n3. Remove a book by book_id\n4. Update book price by book_id\n5. Search books by author\n6. Quit the program\nSelect One Option");
      int choice=sc.nextInt();
      switch(choice){
        case 1:
          System.out.println();
          sc.nextLine();
          System.out.print("Enter Title: ");
          String title=sc.nextLine();
          System.out.print("Author Name: ");
          String author=sc.nextLine();
          System.out.print("Price Of Book: ");
          double price=sc.nextDouble();
          Book_7 book=new Book_7(title,author,price);
          s.addBook(book);
          break;
        case 2:
          s.priceOfAllBooks();
          break;
        case 3:
          System.out.print("Enter The Book Id: ");
          int bid1=sc.nextInt();
          s.removeWithId(bid1);
          break;
        case 4:
          System.out.print("Enter the Book Id: ");
          int bid2=sc.nextInt();
          s.updatePriceWithId(bid2);
          break;
        case 5:
          System.out.print("Enter the Author Name: ");
          sc.nextLine();
          String author1=sc.nextLine();
          s.searchWithAuthor(author1);
          break;
        case 6:
          System.out.println("Shut Down........");
          System.exit(0);
      }
    }
  }
}