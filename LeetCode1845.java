import java.util.PriorityQueue;

public class LeetCode1845 {

    class SeatManager {
        PriorityQueue<Integer> unreservedQueue = new PriorityQueue<>();
    
        public SeatManager(int n) {
            for (int i = 1; i <= n; ++i) {
                unreservedQueue.add(i);
            }
        }
        
        public int reserve() {
            return unreservedQueue.remove();
        }
        
        public void unreserve(int seatNumber) {
            unreservedQueue.add(seatNumber);
        }
    }
    
    /**
     * Your SeatManager object will be instantiated and called as such:
     * SeatManager obj = new SeatManager(n);
     * int param_1 = obj.reserve();
     * obj.unreserve(seatNumber);
     */
}


