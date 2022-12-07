package honest.niceman.university.lab5;

//Напишите методы, реализующие операции вычитания, умножения и деления
//целых чисел с использованием только операции сложения.
public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.multiply(1, 1));
        System.out.println(Calculator.divide(1, 1));
        System.out.println(Calculator.subtract(1, 1));

        System.out.println("-------");

        System.out.println(Calculator.multiply(1, 0));
        System.out.println(Calculator.divide(0, 1));
        System.out.println(Calculator.subtract(0, 1));

        System.out.println("-------");

//        System.out.println(Calculator.divide(0, 0));

        System.out.println("-------");

        System.out.println(Calculator.multiply(2, 7));
        System.out.println(Calculator.divide(10, 2));
        System.out.println(Calculator.subtract(342, 2));

        System.out.println("-------");

        System.out.println(Calculator.multiply(0, -7));
        System.out.println(Calculator.divide(10, -2));
        System.out.println(Calculator.subtract(342, -2));
    }
}
