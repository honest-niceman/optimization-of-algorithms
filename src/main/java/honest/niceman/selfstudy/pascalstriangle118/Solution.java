package honest.niceman.selfstudy.pascalstriangle118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> rowAbove = triangle.get(i - 1);
                    Integer left = rowAbove.get(j - 1);
                    Integer right = rowAbove.get(j);
                    list.add(left + right);
                }
            }
            triangle.add(list);
        }
        return triangle;
    }
}
