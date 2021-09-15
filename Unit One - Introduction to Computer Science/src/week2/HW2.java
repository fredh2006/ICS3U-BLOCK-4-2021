package week2;
//Create a program that obtains two integers, one for the amount a test is out of and another indicating what a student received. Display what percentage the student received on the test.
//save

public class HW2 {
    public static void main(String[] args) {
        double testMax = 60; 
        double mark = 50;

        double avg = (mark/testMax) * 100;

        System.out.println("The student average is: " + avg + "%");
    }
    
}
