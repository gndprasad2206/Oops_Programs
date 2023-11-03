/*You are creating a program to keep track of a list of tasks for a project. Each task has a unique ID, a name, a description, a due date, and a status (e.g. "in progress", "completed", "overdue"). You decide to use a HashSet to store the task IDs, and you need to implement some functionality for adding and removing tasks from the list, as well as updating the status of a task. Write a Java program that implements the following: 

1. Add Task 

2. Remove Task 

3. Update status of Task 

4. Display all the Tasks 

5. Display "in progress" Tasks 

6. Display "completed" tasks 

7. Display "overdue" tasks */
import java.util.*;
import java.text.*;
class Task_7{
  private static int nextid=1;
  private int id;
  private String name;
  private String description;
  private Date dueDate;
  private String status;
  public Task_7(String name,String description,Date dueDate,String status){
    this.id=nextid++;
    this.name=name;
    this.description=description;
    this.dueDate=dueDate;
    this.status=status;
  }
  public static int getNextid() {
  	return nextid;
  }
  public int getId() {
  	return id;
  }
  public String getName() {
  	return name;
  }
  public String getDescription() {
  	return description;
  }
  public Date getDueDate() {
	 return dueDate;
  }
  public String getStatus() {
  	return status;
  }
  public void setStatus(String status) {
	 this.status = status;
  } 
}
class TaskPerform{
  HashSet<Task_7> tasks=new HashSet<Task_7>();
  public void addTask(Task_7 task){
    tasks.add(task);
    System.out.println("Adeed New Task Successfully");
  }
  public void removeTask(int id){
    boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        if(t.getId()==id){
          System.out.println("Task Id: "+t.getId());
          tasks.remove(t);
          System.out.println("Task Removed Successfully");
          c++;
        }
      }
      if(c==0){
        System.out.println("Id not Foound");
      }
    }
  }
  public void updateStatusOfTask(int id,String update){
    boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        if(t.getId()==id){
          t.setStatus(update);
          System.out.println("Task Updated Successfully");
          c++;
        }
      }
      if(c==0){
        System.out.println("Id not Foound");
      }
    }
  }
  public void display(Task_7 t){
    System.out.println();
    System.out.println("ID Of Task: "+t.getId());
    System.out.println("Name Of Task: "+t.getName());
    System.out.println("Description: "+t.getDescription());
    System.out.println("DueDate: "+t.getDueDate());
    System.out.println("Status: "+t.getStatus());
  }
  public void displayAll(){
    boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        display(t);
    }
  }
}
  public void displayInProgress(String status){
     boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        if(t.getStatus().equalsIgnoreCase(status)){
          display(t);
          c++;
        }
      }
      if(c==0){
        System.out.println("There is No Tasks With "+status+" Status");
      }
    }
  }
  public void displayCompleted(String status){
     boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        if(t.getStatus().equalsIgnoreCase(status)){
          display(t);
          c++;
        }
      }
      if(c==0){
        System.out.println("There is No Tasks With "+status+" Status");
      }
    }
  }
  public void overDue(Date today){
    boolean b=tasks.isEmpty();
    int c=0;
    if(b){
      System.out.println("Set is empty");
    }
    else{
      for(Task_7 t:tasks){
        if(t.getDueDate().before(today)){
          display(t);
          c++;
        }
      }
      if(c==0){
        System.out.println("There is No Tasks With Due Date "+today);
      }
    }
  }
}
public class TaskProgram{
  public static void main(String[] args) throws Exception{
    TaskPerform t=new TaskPerform();
    Scanner sc=new Scanner(System.in);
    DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
    while(true){
      System.out.println();
      System.out.println("1. Add Task\n2. Remove Task\n3. Update status of Task\n4. Display all the Tasks\n5. Display in progress Tasks\n6. Display completed tasks\n7. Display overdue tasks\nSelect One Option");
      int choice=sc.nextInt();
      switch(choice){
        case 1:
          System.out.println();
          sc.nextLine();
          System.out.print("Enter Name: ");
          String name=sc.nextLine();
          System.out.println("write description");
          String description=sc.nextLine();
          System.out.print("Enter Date: ");
          String date=sc.nextLine();
          
          Date d=df.parse(date);
          System.out.print("Enter the Status: ");
          String status=sc.nextLine();
          Task_7 task=new Task_7(name,description,d,status);
          t.addTask(task);
          break;
        case 2:
          System.out.print("Entre Id Of task: ");
          int id=sc.nextInt();
          t.removeTask(id);
          break;
        case 3:
          System.out.print("Enter the Id Of task: ");
          int id1=sc.nextInt();
          System.out.println("Update Progress: ");
          String update=sc.nextLine();
          t.updateStatusOfTask(id1,update);
          break;
        case 4:
          t.displayAll();
          break;
        case 5:
          //System.out.print("Enter the Status: ");
          //String status1=sc.nextLine();
          t.displayInProgress("in progress");
          break;
        case 6:
          //System.out.print("Enter The status: ");
          //String status2=sc.nextLine();
          t.displayCompleted("Completed");
          break;
        case 7:
          System.out.println("Enter The Today Date: ");
          sc.nextLine();
          String todayDate=sc.nextLine();
         // DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
          Date today=df.parse(todayDate);
          t.overDue(today);
      }
    }
  }
}