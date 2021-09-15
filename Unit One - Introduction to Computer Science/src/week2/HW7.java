package week2;
//Create a program that can solve the equation y = ax^2+bx+c given a, b, c and x.

public class HW7 {
   public static void main(String[] args) {
       double a = 21;
       double b = 3;
       double c = 8;
       double x = 11;
       double xSquared = x * x;

       double y = a*xSquared + b * x + c;
       System.out.println("The answer is: " + y);
   } 
}
