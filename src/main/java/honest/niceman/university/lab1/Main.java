package honest.niceman.university.lab1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static final int SIZE = 1_000_000;

    public static void main(String[] args) {
        int[] arr1 = new int[SIZE];
        int[] arr2 = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
            arr2[i] = random.nextInt();
        }
        Main main = new Main();
        long t1 = System.currentTimeMillis();
        int[] result1 = main.findIntersection(arr1, arr2);
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + ", " + result1.length);
        t1 = System.currentTimeMillis();
        int[] result2 = main.findIntersectionMySet(arr1, arr2);
        t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + ", " + result2.length);
    }

    public void swapDigits(int a, int b) {
        // via additional variable
        int temp = a;
        a = b;
        b = temp;

        // without additional variable
        a -= b;
        b += a;
        a = b - a;
    }

    public int[] findIntersection(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findIntersection(arr2, arr1);
        }
        Set<Integer> set = new HashSet<>();
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                result[j++] = arr2[i];
            }
        }
        return Arrays.copyOf(result, j);
    }

    /*
    Java uses HashMap to implement HashSet. Seems to be not the best optimized solution.
    Try to implement your own HashSet for the above task. And compare the execution speed.
    */

    public int[] findIntersectionMySet(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findIntersection(arr2, arr1);
        }
        MySet<Integer> set = new MySet<>(arr1.length);
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                result[j++] = arr2[i];
            }
        }
        return Arrays.copyOf(result, j);
    }
}
