package honest.niceman.yandex.contest;

import java.io.*;

public class WhiteAndBlackBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        print(generateMatrix(n), writer);

        reader.close();
        writer.close();
    }

    private static int[][] generateMatrix(int n) {
        int size = 2 * n + 1;
        int[][] result = new int[size][size];
        fillInValues(result);
        return result;
    }

    private static void print(int[][] matrix, BufferedWriter writer) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                writer.write(String.valueOf(matrix[i][j]));
                writer.write(" ");
            }
            writer.newLine();
        }
    }

    private static void fillInValues(int[][] result) {
        int negativeNumber = 0;
        int positiveNumber = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) {
                    result[i][j] = 0;
                    continue;
                }
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    result[j][i] = --negativeNumber;
                } else {
                    result[i][j] = ++positiveNumber;
                }
            }
        }
    }
}
