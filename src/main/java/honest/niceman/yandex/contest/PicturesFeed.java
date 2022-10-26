package honest.niceman.yandex.contest;

import java.io.*;
import java.util.*;

/*
#Пример 1
##Ввод
2000
5 3
1000x1000
1000x1500
640x930
640x1500
3000x1000

##Вывод
5574
10595


#Пример 2
##Ввод
1000
5 5
1404x1386
1132x1110
1061x1801
1022x1519
1529x1003

##Вывод
5810
5810

#Пример 3
##Ввод
4096
2 1
640x4096
4096x640

##Вывод
640
26215
 */
public class PicturesFeed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        double w = Double.parseDouble(reader.readLine());
        String[] parts = reader.readLine().split(" ");
        int allPicturesNumber = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        List<Map.Entry<Double, Double>> sizes = new ArrayList<>();
        for (int i = 0; i < allPicturesNumber; i++) {
            String[] pair = reader.readLine().split("x");
            double weight = Double.parseDouble(pair[0]);
            double height = Double.parseDouble(pair[1]);
            sizes.add(new AbstractMap.SimpleEntry<>(weight, height));
        }

        int max = findHeight(sizes, w, k, true);
        int min = findHeight(sizes, w, k, false);

        writer.write(String.valueOf(min));
        writer.newLine();
        writer.write(String.valueOf(max));

        reader.close();
        writer.close();
    }

    private static int findHeight(List<Map.Entry<Double, Double>> sizes,
                           double w,
                           int k,
                           boolean isMax) {
        List<Integer> calculatedHeights = calculateAllHeights(sizes, w);
        if (isMax) {
            calculatedHeights.sort(Collections.reverseOrder());
        } else {
            calculatedHeights.sort(Comparator.naturalOrder());
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += calculatedHeights.get(i);
        }
        return result;
    }

    private static List<Integer> calculateAllHeights(List<Map.Entry<Double, Double>> sizes,
                                              double w) {
        List<Integer> calculatedHeights = new ArrayList<>();
        for (Map.Entry<Double, Double> size : sizes) {
            calculatedHeights.add(calculateOneHeight(size, w));
        }
        return calculatedHeights;
    }

    private static int calculateOneHeight(Map.Entry<Double, Double> entry,
                                   double w) {
        double vv = entry.getValue() * w / entry.getKey();
        return (int) Math.ceil(vv);
    }
}
