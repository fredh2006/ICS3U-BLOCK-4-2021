package week2;
//Write a program that can calculate the volume of a sphere.

public class HW6 {
    public static void main(String[] args) {
        double pi = Math.PI;
        double radius = 5;
        double radiusSquared = radius * radius * radius;
        double volume = (double)4/3*(pi*radiusSquared);
        System.out.println("The volume is: " + volume);
    }
}
