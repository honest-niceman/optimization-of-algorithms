package honest.niceman.university.exam;

import java.util.*;

//Дан массив уникальных строк.
// Выяснить сколько строк являются окончанием любой другой строки.
public class Main {
    public static void main(String[] args) {
        String[] arr = removeDuplicates(generateStrings(100, 3));
        System.out.println(withImprovements(arr));
        System.out.println(straightSolution(arr));
        System.out.println(valera(arr));
        System.out.println(genius(arr));
    }

    public static String[] generateStrings(int arraySize, int wordsMaxLength) {
        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
        int rightLimit = 99; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        String[] res = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int targetStringLength = random.nextInt(wordsMaxLength) + 1;
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            res[i] = buffer.toString();
            buffer.setLength(0);
        }
        return res;
    }

    public static String[] removeDuplicates(String[] array) {
        return new HashSet<>(Arrays.asList(array)).toArray(new String[0]);
    }

    public static int valera(String[] arr) {
        System.out.println("Valera:"+Arrays.toString(arr));
        Map<String, Integer> map = new HashMap<>();
        for (String  s : arr) {
            int length = s.toCharArray().length;
            for (int i = 1; i <= length; i++) {
                String key = s.substring(length - 1, length);
                Integer value = map.get(key);
                map.put(key, value == null ? 0 : ++value);
            }
        }
        return map.values().stream().mapToInt(x -> x).sum();
    }

    public static int straightSolution(String[] arr) {
        System.out.println("Straight:"+Arrays.toString(arr));
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i].endsWith(arr[j])) {
//                    System.out.println(i + " --- " + j);
                    set.add(arr[j]);
                    break;
                }
            }
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s : set) {
            res[i++] = s;
        }
        Arrays.sort(res);
//        System.out.println(Arrays.toString(res));
        return set.size();
    }

    //
    public static int withImprovements(String[] arr) {
        System.out.println("Impr:"+Arrays.toString(arr));
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
//                        System.out.println("Short:" + shortWords.get(k) + "; Long:" + longWords.get(l));
                        //так как мы развернули слова, то теперь проверяем что они не заканчиваются, а начинаются на ...
                        if (longWords.get(l).startsWith(shortWords.get(k))) {
                            result.add(shortWords.get(k));
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println(map);


        String[] res = new String[result.size()];
        int i = 0;
        for (String s : result) {
            res[i++] = s;
        }
        Arrays.sort(res);
//        System.out.println(Arrays.toString(res));
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


    private static class Node {
        private Map<Character, Node> children = new HashMap<>();

        public Map<Character, Node> getChildren() {
            return children;
        }
    }

    public static int genius(String[] arr) {
        System.out.println("Genius:"+Arrays.toString(arr));
        Node root = new Node();
        for (String s : arr) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            Node node = root;
            for (int j = 0; j < sb.length(); j++) {
                node = addNode(node, sb.charAt(j));
            }
        }
        int count = 0;
        for (String s : arr) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            Node node = root;
            for (int j = 0; j < sb.length(); j++) {
                node = node.getChildren().get(sb.charAt(j));
            }
            if(!node.getChildren().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static Node addNode(Node current, char value) {
        boolean flag = current.getChildren().containsKey(value);
        if (!flag) {
            Node node = new Node();
            current.getChildren().put(value, node);
            return node;
        } else return current.getChildren().get(value);
    }

}
