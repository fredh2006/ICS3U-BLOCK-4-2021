package week2;
//Write a program that given the number of pennies, nickles, dimes, quarters, loonies and toonies calculates how much money the user has.

public class HW9 {
    public static void main(String[] args) {
        int pennies = 15;
        int nickles = 25;
        int dimes = 40;
        int quarters = 37;
        int loonies = 10;
        int toonies = 2;

        double total = (double)((pennies * 0.01) + (nickles * 0.05) + (dimes * 0.10) + (quarters * 0.25) + (loonies * 1) + toonies * 2);
        System.out.println("You have: $" + total);
        
    }
}
