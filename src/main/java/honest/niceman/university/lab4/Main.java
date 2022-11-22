package honest.niceman.university.lab4;

//Напишите функцию, определяющую количество битов, которые
//необходимо изменить, чтобы из целого числа А получить целое число В.
//Пример:
//Ввод: 29 (или 11101), 15 (или 01111)
//Вывод: 2

public class Main {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        int c = a ^ b;
        while (c != 0) {
            count += c & 1;
            c >>>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int a, b;

        a = 15;
        b = 29;
        System.out.println(a + ": " + Integer.toBinaryString(a));
        System.out.println(b + ": " + Integer.toBinaryString(b));
        System.out.println("XOR: " + (Integer.toBinaryString(a ^ b)));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));

        a = 4;
        b = 77;
        System.out.println(a + ": " + Integer.toBinaryString(a));
        System.out.println(b + ": " + Integer.toBinaryString(b));
        System.out.println("XOR: " + (Integer.toBinaryString(a ^ b)));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));

        a = 0;
        b = 511;
        System.out.println(a + ": " + Integer.toBinaryString(a));
        System.out.println(b + ": " + Integer.toBinaryString(b));
        System.out.println("XOR: " + (Integer.toBinaryString(a ^ b)));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));
    }
}