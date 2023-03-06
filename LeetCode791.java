import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode791 {
    public static void main(String[] args) {
        // Hashing > General
        // https://leetcode.com/problems/custom-sort-string/
        
        // order = cbafg, s = abcd
        // first, I traverse the order and make hashMap
        // like c : 1, b : 2, a : 3, f : 4, g : 5
        // and I pick every character in the 's' to the number If it matched in the hashMap and change it to the number and add to number list
        // and sort the number list
        // and change each number to the character in the hashmap
        // Combine everything

        String order = "cba";
        String s = "abcd";

        Map<Character, Integer> chToNum = new HashMap<>();
        Map<Integer, Character> numToCh = new HashMap<>();

        int n = 0;
        for (Character ch : order.toCharArray()) {
            numToCh.put(n, ch);
            chToNum.put(ch, n);
            ++n;
        }

        StringBuffer sb = new StringBuffer();
        List<Integer> nums = new ArrayList<>();
        for (Character ch : s.toCharArray()) {
            Integer num = chToNum.get(ch);
            if (num != null) {
                nums.add(num);
            } else {
                sb.append(ch);
            }
        }

        Collections.sort(nums);
        for (Integer num : nums) {
            sb.append(numToCh.get(num));
        }

        System.out.println(sb.toString());
    }
}


