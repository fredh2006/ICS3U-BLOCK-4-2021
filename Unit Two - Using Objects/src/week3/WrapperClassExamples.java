package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.4);

        Integer num = 7;
        int x = new Integer(7);

        int z = num.intvalue();
        int z = num;

        double f = d;
        f = d.doubleValue();

        System.out.println(Integer.MAX_VALUE, Integer.MIN_VALUE); 
    }
    
}
