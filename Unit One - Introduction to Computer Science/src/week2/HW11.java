package week2;

public class HW11{
    public static void main(String[] args) {
        double x = 5.5, y = 3.0;//, z = -2.0;
        int i = 5, j = 4, k = 3;
        //a
        int a = i - j;
        int a1 = i - a;
        int a2 = i - a1;
        int a3 = i - a2;
        System.out.println("The answer is: " + a3);
        //c
        double c = x - y;
        double c1 = y - x;
        double cFinal = (c - c1 - c - c1);
        System.out.println("The answer is: " + cFinal);
        //f
        int f = i * j;
        int f1 = f/k;
        int f2 = f1 + i;
        int fFinal = f2  - j;
        System.out.println("The answer is " + fFinal);
        //h
        int h = j/k;
        double hFinal = (double)i + h;
        System.out.println("The answer is: " + hFinal);
        //i
        int i1 = (int)x/k;
        double i2 = x/k;
        double iFinal = i1 - i2;
        System.out.println("The answer is: " + iFinal);
        //j
        double j1= (double)i/j;
        double j2 = (double)(i/j);
        double jFinal = j1 - j2;
        System.out.println("The answer is: " + jFinal);
    }
}