package week2;
//Math.sqrt(x), where x is a value can be used to calculate the square root. Given an equation in the format from question 7.  Obtain the two roots. Given a, b, and c.

public class HW10 {
    public static void main(String[] args) {
        double a = 3;
        int b = 21;
        int bSquared = b * b;
        double c = 8;
        
        double x = (-b + Math.sqrt(bSquared - 4*(a)*(c)))/(2 * a);
        double x2 = (-b - Math.sqrt(bSquared - 4*(a)*(c)))/(2 * a);
        System.out.println("One of the roots is: " + x);
        System.out.println("The other root is: " + x2);
    }
    
}
