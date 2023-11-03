
/*Challenge 5:
You are working on a project that involves analyzing an array of integers. The task is to count the number of elements in the array that have specific properties, such as being divisible by a given number, having a digit sum greater than a certain value, being a perfect number, or having a repeating digit. You decide to create a program to automate this counting process.
Task: Write a Java program to count the number of elements in an array that have specific properties. The program should prompt the user to enter the size of the array and then input the elements of the array dynamically. After inputting the array elements, the program should count the number of elements that have each specific property and display the results.
 Input:
Welcome to the Array Analysis Program!
Enter the size of the array: 6
Enter element 1: 25
Enter element 2: 12
Enter element 3: 49
Enter element 4: 28
Enter element 5: 136
Enter element 6: 333

Enter the number by which the elements should be divisible: 5
Enter the digit sum threshold: 10

Output:
Number of elements divisible by 5: 1
Number of elements with digit sum greater than 10: 2
Number of perfect Number elements: 1
Number of elements with repeating digits: 1
  */
import java.util.Scanner;

class ArrayAnalysis {
    public int division(int arr[], int div) {
        int divCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % div == 0)
                divCount++;
        }
        return divCount;
    }

    public int digitSum(int arr[], int threshold) {
        int digitCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int sum = 0, digit = 0;
            while (val > 0) {
                digit = val % 10;
                sum = sum + digit;
                val /= 10;
            }

            if (sum > threshold) {
                digitCount++;
            }
        }
        return digitCount;
    }

    public int isPerfect(int arr[]) {
        int perCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 1; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    sum = sum + j;
                }
            }
            if (sum == arr[i]) {
                perCount++;
            }
        }
        return perCount;
    }

    public int repeating(int arr[]) {
        int repCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int digit = 0, rep = 0;
            int number = arr[i];
            while (number > 0) {
                digit = arr[i] % 10;
                number /= 10;
                if (digit == rep) {
                    repCount++;
                    break;
                } else {
                    rep = digit;
                }
            }
            break;
        }
        return repCount;
    }
}

public class Scenario5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Array Analysis Program!");
        System.out.println("Enter the size of Array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter Element " + (1 + i) + ": ");
            arr[i] = sc.nextInt();
        }
        int div, threshold;
        System.out.println("Enter the number by which the elements should be divisible: ");
        div = sc.nextInt();
        System.out.println("Enter the digit sum threshold: ");
        threshold = sc.nextInt();
        ArrayAnalysis call = new ArrayAnalysis();
        int divValue = call.division(arr, div);
        int sumValue = call.digitSum(arr, threshold);
        int perfect = call.isPerfect(arr);
        int repeating = call.repeating(arr);
        System.out.println("Number of elements divisible by " + div + ": " + divValue);
        System.out.println("Number of elements with digit sum greater than " + threshold + ": " + sumValue);
        System.out.println("Number of perfect Number elements: " + perfect);
        System.out.println("Number of elements with repeating digits: " + repeating);
    }
}
