package honest.niceman.university.lecture;

import java.util.*;

public class BitsExample {
    private static class Column {
        private String name;
        private long max;
        private int size;
        private int shift;

        private Column(String name) {
            this.name = name;
        }
    }

    private static Column[] columns = new Column[]{
            new Column("a"),
            new Column("b"),
            new Column("c"),
            new Column("d")
    };

    public static void main(String[] args) {
        Random r = new Random();
        List<Map<String, Long>> items = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            Map<String, Long> item = new HashMap<>();
            item.put("a", (long) r.nextInt(10));
            item.put("b", (long) r.nextInt(100));
            item.put("c", (long) r.nextInt(1000));
            item.put("d", (long) r.nextInt(10000));
            items.add(item);
        }

        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < columns.length; j++) {
                columns[j].max = Math.max(columns[j].max, items.get(i).get(columns[j].name));
            }
        }

        int shift = 0;
        for (int i = 0; i < columns.length; i++) {
            long value = columns[i].max;
            int size = 1;
            while ((value = value >> 1) > 0) {
                size++;
            }
            columns[i].size = size;
            columns[i].shift = shift;
            shift += size;
            System.out.println(columns[i].name + ": " + columns[i].max + ", " + columns[i].size + ", " + columns[i].shift);
        }

        long[] zippedValues = new long[items.size()];
        for (int j = 0; j < items.size(); j++) {
            long zippedVal = 0;
            for (int i = 0; i < columns.length; i++) {
                long l = items.get(j).get(columns[i].name) << columns[i].shift;
                zippedVal += l;
            }
            zippedValues[j] = zippedVal;
        }
        System.out.println(Arrays.toString(zippedValues));

        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < columns.length; j++) {
                int mask = (1 << columns[j].size) - 1;
                long originalValue = items.get(i).get(columns[j].name);
                long restoredValue = (zippedValues[i] >> columns[j].shift) & mask;
                System.out.println(columns[j].name + ": " + originalValue + " " + restoredValue);
            }
            System.out.println();
        }
    }
}
