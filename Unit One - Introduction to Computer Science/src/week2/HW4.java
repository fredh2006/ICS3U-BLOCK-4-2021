package week2;
//Create a program that can be used to calculate the final velocity of a car given the initial velocity, the acceleration of the car and the time that has elapsed using the following equation:
//save
public class HW4 {
    public static void main(String[] args) {
        double velocityInitial = 69;
        double acceleration = 60;
        double time = 420;

        double velocityFinal = velocityInitial + acceleration * time;
        System.out.println("The final velocity is: " + velocityFinal);
    }
}
