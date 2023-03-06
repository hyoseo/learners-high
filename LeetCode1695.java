import java.util.HashSet;
import java.util.Set;

public class LeetCode1695 {
    public static void main(String[] args) {
        // Hashing > Counting
        // https://leetcode.com/problems/maximum-erasure-value/
        
        // use sliding window method
        // move right and add one element to set and plus the value to total
        // if the added element exist already, move left until the element is removed and minus the value from total
        // when set's size is equal to unique count, update max erase value
        // end the loop when rightt reach end of nums

        int[] nums = new int[] {4, 2, 4, 5, 6};

        int total = 0, ret = 0;
        Set<Integer> uniques = new HashSet<>();
        
        for (int left = 0, right = 0; right < nums.length; ++right) {
            total += nums[right];
            if (uniques.add(nums[right]) == false) {
                while (nums[left] != nums[right]) {
                    total -= nums[left];
                    uniques.remove(nums[left]);
                    ++left;
                }
                total -= nums[left];
                ++left;
            }
            
            ret = Math.max(ret, total);
        }

        System.out.println(ret);
    }
}


