package honest.niceman.university.exam;

import java.util.*;

//Дан массив уникальных строк.
// Выяснить сколько строк являются окончанием любой другой строки.
public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"abc", "ba", "ab", "bc", "cd", "c", "adas", "cdb"};
        System.out.println(withImprovements(arr));
        System.out.println(straightSolution(arr));
    }

    public static int straightSolution(String[] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i].endsWith(arr[j])) {
                    set.add(arr[i]);
                    break;
                }
            }
        }
        return set.size();
    }

    public static int withImprovements(String[] arr) {
        Map<Integer, List<String>> map = getMap(arr);
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Set<String> result = new HashSet<>();

        //сначала идут списки с короткими словами
        for(int i = 0; i < keyList.size(); i++) {
            Integer keyI = keyList.get(i);
            List<String> shortWords = map.get(keyI);

            //нет смысла проверять что слова большие по длине, являются окончанием коротких слов. Это невозможно
            //поэтому сравниваем только со след идущими списками, а не со всеми
            for (int j = i + 1; j < keyList.size(); j++) {
                Integer keyJ = keyList.get(j);
                List<String> longWords = map.get(keyJ);

                for (int k = 0; k < shortWords.size(); k++) {
                    for (int l = 0; l < longWords.size(); l++) {

                        //мы развернули слова и упорядочиили их по алфавиту, теперь можно спокойно проверять, что если
                        //первая буква стала больше у короткого слова, то это точно не окончание слова
                        if (shortWords.get(k).charAt(0) < longWords.get(l).charAt(0)) {
                            break;
                        }
                        System.out.println("Short:" + shortWords.get(k) + "; Long:" + longWords.get(l));
                        //так как мы развернули слова, то теперь проверяем что они не заканчиваются, а начинаются на ...
                        if (longWords.get(l).startsWith(shortWords.get(k))) {
                            result.add(shortWords.get(k));
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(map);
        return result.size();
    }

    //получаем мапу, в которой ключ – количество элементов.
    private static Map<Integer, List<String>> getMap(String[] arr) {
        //TreeMap имеет натуральный порядок сортировки по ключу
        //То есть у нас сначала будут entries с наименьшей длиной строк
        Map<Integer, List<String>> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            List<String> strings = map.get(arr[i].length());
            if (strings == null) {
                strings = new ArrayList<>();
            }
            //разворачиваем строки, чтобы потом можно было отсекать по первому символу
            strings.add(sb.append(arr[i]).reverse().toString());
            sb.setLength(0);
            map.put(arr[i].length(), strings);
        }
        //чтобы отсекать, нам надо быть уверенными, что строки отсортированы по алфавиту
        sortLists(map);
        return map;
    }

    //сортируем строки в мапе по алфавиту для каждого ключа
    private static void sortLists(Map<Integer, List<String>> map) {
        for (Integer key : map.keySet()) {
            List<String> strings = map.get(key);
            Collections.sort(strings);
            map.replace(key, strings);
        }
    }
}
