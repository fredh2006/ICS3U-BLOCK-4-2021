package week2;

public class StudentExample {

    public static void main(String[] args) {  
Student fred = new Student("Fred", "654321", 10);
Student max = new Student("Max", "123456", 10);
Student muriel = fred;
muriel.increaseGrade();

fred = null;
//fred.displayName();

max.addTest(87);
max.addTest(94);
max.addTest(98);
max.addTest(67);

double maxAverage = max.getAverage();
System.out.println(max.getName() + " has an average of " + max.getAverage());

Student david = new Student("David", "565858");

String str = "0";

str += str + 0 + 8;

System.out.println(str);



    }

}

