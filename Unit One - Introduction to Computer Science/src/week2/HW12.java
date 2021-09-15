package week2;
//save
public class HW12 {
    public static void main(String[] args) {
        double x = 5.5, y = 3.0, z = -2.0;
        int i = 5, j = 4, k = 3;

        x+=y; //x = 8.5 (5.5 + 3.0)
        y+=y; //y = 6.0 (3.0 + 3.0)
        z+=x-y; //z = 0.5 (-2 + (8.5 - 6.0))
        i*=j+k; //i = 35 (5 * (4 + 3))
        j/=k; //j = 1 (4/3)
        System.out.println (x + "," + y + "," + z + "," + i + "," + j); //should display 8.5,6.0,0.5,35,1
    }
}
