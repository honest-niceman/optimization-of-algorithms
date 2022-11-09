package honest.niceman.university.lecture;

public class PuzzleExample {
    public static void main(String[] args) {
        long n = 512;
        int k = 2;

        int[] digits = new int[19];
        int idx = 0;
        while (n > 0) {
            digits[idx++] = (int) (n % 10);
            n /= 10;
        }

        long count = calc(digits, k, idx);
        count--;
        System.out.println(count);
    }

    private static long calc(int[] digits, int k, int idx) {
        long count = (digits[idx - 1] - 1) / k + 1;
        for (int j = idx - 2; j >= 0; j--) {
            count *= 9 / k + 1;
        }
        if (digits[idx - 1] % k == 0) {
            if (idx > 1) {
                count += calc(digits, k, idx - 1);
            } else {
                count++;
            }
        }
        return count;
    }
}