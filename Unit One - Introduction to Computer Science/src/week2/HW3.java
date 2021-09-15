package week2;
//Write a program that uses a five digit number and calculates the product of the 2nd and 4th digit. Use the modulus and and division operators.

public class HW3 {
    public static void main(String[] args) {
        int num = 56724;
        int num4 = num / 1000 % 10;
        int num2 = num/10 % 10;
        int ans = (num4 * num2);
        System.out.println(ans);
    }
    
}
