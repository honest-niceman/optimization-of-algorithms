package honest.niceman.university.lab7;

import java.util.ArrayList;
import java.util.List;

//4. Напишите метод возвращающий все подмножества заданного множества
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.subsets(new int[] {1, 2, 3, 4}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int subSetSize = 0; subSetSize < nums.length + 1; subSetSize++) {
            backtrack(result, 0, new ArrayList<>(), nums, subSetSize);
        }
        return result;
    }

    public void backtrack(List<List<Integer>> result,
                          int firstToCheck,
                          ArrayList<Integer> currentList,
                          int[] nums,
                          int subSetSize) {
        if (currentList.size() == subSetSize) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = firstToCheck; i < nums.length; ++i) {
            currentList.add(nums[i]);
            backtrack(result, i + 1, currentList, nums, subSetSize);
            currentList.remove(currentList.size() - 1);
        }
    }
}
