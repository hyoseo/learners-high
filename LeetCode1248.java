import java.util.HashMap;
import java.util.Map;

public class LeetCode1248 {
    public static void main(String[] args) {
        // Hashing > Counting
        // https://leetcode.com/problems/count-number-of-nice-subarrays/
        /*
            Given an array of positive integers nums and an integer k.
            Find the number of subarrays with exactly k odd numbers in them.
            
            For example, given nums = [1, 1, 2, 1, 1], k = 3, the answer is 2.
            The subarrays with 3 odd numbers in them are [1, 1, 2, 1, 1] and [1, 1, 2, 1, 1].

            Constraints:
            1 <= nums.length <= 50000
            1 <= nums[i] <= 10^5
            1 <= k <= nums.length
        */

        int[] nums = new int[] {1, 2, 1, 2, 1};
        // if k == 2
        // 0 1
        // 1 1
        // 1 2
        // 2 1 -> ans 1, If we minus k from curr value and get the value by the leftover in hashmap, the result will be the subarray count(except curr)
        //               1 + [1, 2, 1]
        // 2 2 -> ans 2
        //               1 + [1, 2, 1, 2]
        // 3 1 -> ans 4
        //               2 + [1, 2, 1]

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        int curr = 0, ans = 0;
        int k = 2;
        for (int num : nums) {
            curr += num % 2;
            ans += countMap.getOrDefault(curr - k, 0);
            System.out.printf("curr %d, k %d, ans %d\n", curr, k, ans);
            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
        }

        System.out.println(ans);
    }
}