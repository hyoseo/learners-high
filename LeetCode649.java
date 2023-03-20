import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode649 {
    private static String predictPartyVictory(String senate) {
        // I will use Deque for solving this
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> rq = new ArrayDeque<>();
        final int n = senate.length();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'D') {
                dq.addLast(i);
            } else {
                rq.addLast(i);
            }
        }

        while (true) {
            if(dq.isEmpty()) {
                return "Radiant";
            } else if(rq.isEmpty()) {
                return "Dire";
            }

            Integer di = dq.removeFirst();
            Integer ri = rq.removeFirst();

            if (di < ri) {
                dq.addLast(n + di);
            } else {
                rq.addLast(n + ri);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRD"));
    }
}


