package honest.niceman.university.lab5;

//Напишите методы, реализующие операции вычитания, умножения и деления
//целых чисел с использованием только операции сложения.
public class Main {
    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }
        int sum = 0;
        for (int i = abs(b); i > 0; i--) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    public int divide(int a, int b)
    throws java.lang.ArithmeticException {
        if ( b == 0) {
            throw new java.lang.ArithmeticException("ERROR");
        }
        int aModule = abs(a);
        int bModule = abs(b);

        int product = 0;
        int x = 0;
        while (product + bModule <= aModule) {
            product += bModule;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += d;
            a += d;
        }
        return neg;
    }

    public static int abs(int a) {
        return a >= 0 ? a : negate(a);
    }
}
