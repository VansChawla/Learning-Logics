import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        int[] answer = new int[deck.length];

        int ptr = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (!queue.isEmpty()) {
                queue.offer(queue.poll()); // Remove next element and send to back of the queue
            }
            answer[index] = deck[ptr];
            ptr++;
        }

        return answer;
    }
}
