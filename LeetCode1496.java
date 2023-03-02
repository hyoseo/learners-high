import java.util.HashSet;
import java.util.Set;

public class LeetCode1496 {
    public static void main(String[] args) {
        // Hashing > Checking for existence
        // https://leetcode.com/problems/path-crossing/
        
        // I need two variable y, x
        // When I move to north, ++y. south, --y
        // east ++x, west --x
        // I should save the current position to hashSet every time
        // the constraint path is below 100,000
        // so I can save the position as integer by { y * 100000 + x }

        String path = "NES";

        int y = 0, x = 0;
        Set<Integer> visited = new HashSet<>();
        boolean result = false;

        visited.add(0);
        for (Character way : path.toCharArray()) {
            if (way == 'N') {
                ++y;
            } else if (way == 'S') {
                --y;
            } else if (way == 'E') {
                ++x;
            } else if (way == 'W') {
                --x;
            }

            int pos = y * 100000 + x;
            if (visited.contains(pos)) {
                result = true;
            }
            visited.add(pos);
        }
        result = false;
    }
}


