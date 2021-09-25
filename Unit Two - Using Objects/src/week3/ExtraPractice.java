package week3;


public class ExtraPractice {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
    }

    public static void exampleOne(){
        int r = (int)(Math.random()*100) + 1;
        System.out.println(r);
    }
    public static void exampleTwo(){
        int x = (int)(Math.random()*101)-50;
        System.out.println(x);
    }
    public static int exampleThree(){
        int y = (int)(Math.random()*6)+1;
        return y;
    }
    public static int exampleFour(int smaller, int bigger){
        int random = (int)(Math.random()*(bigger-smaller)+1) + smaller;
        return random;
    }
    public static String exampleFive(String str){
        int index = str.indexOf('e');
        String front = str.substring(0,index);
        String back = str.substring(index+1);
        return(front+back);
    }
    public static String exampleSix(String str1, int ss, int ss1){
        String j = str1.substring(0, ss);
        String j1 = str1.substring(ss1);
        System.out.println(j+j1);
        return(j+j1);
    }
    public static int exampleSeven(String n, String m){
        int end = (n.length()+m.length());
        return(end);
    }
    public static String exampleEight(int x1, int y1, int x2, int y2){
        int yChange = y2 - y1;
        int xChange = x2 - x1;
        return(yChange + "/" + xChange);
    }
    public static double exampleNine(int radius, int height){
        double volume = Math.PI*((double)radius)*radius*height;
        System.out.println(volume);
        return volume;
    } 
    public static void exampleTen(String str4){
        int rand = (int)(Math.random()*str4.length());
        String start = str4.substring(0,rand);
        String end = str4.substring(rand + 1);
    }


}