package honest.niceman.selfstudy.fibonaccinumber509;

public class Solution {
    //https://leetcode.com/problems/fibonacci-number/
    public int fib(int n) {
        int left;
        int mid = 0, right = 1; // fib(0), fib(1)
        for (int i = 0; i < n; i++) {
            left = mid;
            mid = right;
            right = left + mid;
        }
        return mid;
    }
}
