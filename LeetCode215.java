import java.util.PriorityQueue;

public class LeetCode215 {

    public static void main(String[] args) {
        // I wanna use min heap and the size is k
        // whenever the size is over k, I remove element from it
        // when I finish the loop, the min heap contains elements larger than removed elements
        // I return the element of min heap by remove

        // Time Complexity is O(Nlogk), Space Complexity is O(k)

        int nums[] = {3,2,1,5,6,4};
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        System.out.println(pq.remove());
    }
}


