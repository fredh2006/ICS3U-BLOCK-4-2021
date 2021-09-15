package week2;
//Write program that can calculate the area of circle. You will need to create variables for the radius and the area.

public class HW5 {
  public static void main(String[] args) {
      double pi = Math.PI;
      double radius = 5;
      double radiusSquared = radius * radius;

      double area = pi * radiusSquared;
      System.out.println("The area of the circle is: " + area);
  }  
}
