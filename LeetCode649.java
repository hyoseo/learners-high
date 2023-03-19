import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode649 {
    private static String predictPartyVictory(String senate) {
        // I will use Deque for solving this
        // when the senate is input to deque at last, increase prevent point
        // so another party's senate can't input until the point reaches zero
        // I repeat this until the deque is filled with only one party

        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : senate.toCharArray()) {
            deque.addLast(c);
        }
        // DRRDDRR
        // DRDR

        int r = 0, d = 0;
        while (true) {        
            Deque<Character> newDeque = new ArrayDeque<>();
            for (Character c : deque) {
                if (c == 'R') {
                    if (d > 0) {
                        --d;
                    } else {
                        ++r;
                        newDeque.addLast(c);
                    }
                } else if (c == 'D') {
                    if (r > 0) {
                        --r;
                    } else {
                        ++d;
                        newDeque.addLast(c);
                    }
                }
            }

            if (newDeque.size() <= d) {
                return "Dire";
            } else if (newDeque.size() <= r) {
                return "Radiant";
            }

            deque = newDeque;
        }
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRD"));
    }
}


