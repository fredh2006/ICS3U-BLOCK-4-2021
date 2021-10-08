package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //makes new object from the Scanner class 

        //calls processRunner three times, giving it the paramter of the object just created "in"
        processRunner(in); 
        processRunner(in);
        processRunner(in);
        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        //requests the users to input info, stores info into respective variables
        System.out.print("Please input your first name: ");
        firstName = in.nextLine();
        System.out.print("PLease input your last name: ");
        lastName = in.nextLine();
        System.out.print("Please input your first mile time: ");
        mileOne = in.nextLine();
        System.out.print("Please input your second mile time: ");
        mileTwo = in.nextLine();
        System.out.print("Please input your finish time: ");
        finish = in.nextLine();

        //calls substractTimes twice,  giving it the paramters mileTwo, mileOne, and finish, mileTwo respectively
        splitTwo = subtractTimes(mileTwo, mileOne);
        splitThree = subtractTimes(finish, mileTwo);

        //prints out the summary of the info
        System.out.println("Summary:");
        System.out.println("Name: " + firstName + " " + lastName );
        System.out.println("First Mile: " + mileOne);
        System.out.println("Split Two: " + splitTwo);
        System.out.println("Split Three: " + splitThree);
        System.out.println("Finish Time: " + finish);
    }

    //function to subtract the times, giving the values of splitTwo, and splitThree
    private static String subtractTimes(String endTime, String startTime) {
        //calls convertToSeconds twice, giving it the paramters "endTime" and "startTime" respectively
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

        //calculates the difference in time in SECONDS
        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;
        //returns the time in (minutes: seconds. milliseconds), by calling convertToTime, and giving it the paramter diffInSeconds
        return convertToTime(diffInSeconds);

    }
    //function to convert the time in seconds, to time in the correct form
    private static String convertToTime(double timeInSeconds) {
        int minutes = (int)(timeInSeconds/60); //gets minutes by /60, and casting it to an int
        double seconds = timeInSeconds%60; //gets seconds by %60
        return String.format("%d:%06.3f", minutes, seconds);
    }

    //function to convert the time to SECONDS
    private static double convertToSeconds(String time) {
        int index = time.indexOf(":"); //gets the index of where the colon is
        String front = time.substring(0, index); //gets the minutes
        String back = time.substring(index +1); //gets the seconds
        double frontSeconds = Double.parseDouble(front); //turns the string that the minutes is in, into a double
        frontSeconds *= 60; //multiplies the variable the minutes is in by 60, to get minutes in seconds
        double backSeconds = Double.parseDouble(back); //turns the string that the seconds are in, into a double
        return frontSeconds + backSeconds; //returns the sum of the minutes in seconds, and the seconds

    }
}