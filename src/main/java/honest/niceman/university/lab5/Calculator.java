package honest.niceman.university.lab5;

public class Calculator {
    public static int subtract(int a, int b) {
        return a + flipSign(b);
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
            sum = flipSign(sum);
        }
        return sum;
    }

    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Division by zero");
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
            return flipSign(x);
        }
    }

    private static int flipSign(int a) {
        int flipped = 0;
        int d = a < 0 ? 1 : -1;
        while (a != 0) {
            flipped += d;
            a += d;
        }
        return flipped;
    }

    private static int abs(int a) {
        return a >= 0 ? a : flipSign(a);
    }
}
