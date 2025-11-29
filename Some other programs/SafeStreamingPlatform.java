class ViewerCounter {
    private int count = 0;

    public synchronized void userJoined() {
        count++;
    }

    public int getViewerCount() {
        return count;
    }

}

public class SafeStreamingPlatform {
    public static void main(String[] args) {

        // Create the single shared counter
        ViewerCounter counter = new ViewerCounter();

        int numberOfUsers = 500;
        Thread[] threads = new Thread[numberOfUsers];

        // --- PHASE 1: Create and Start Threads ---
        System.out.println("Simulating " + numberOfUsers + " users joining...");

        for (int i = 0; i < numberOfUsers; i++) {
            threads[i] = new Thread(() -> {
                // The thread tries to increment the counter
                // Because of 'synchronized', it might have to wait its turn
                counter.userJoined();
            });
            threads[i].start();
        }

        // --- PHASE 2: Wait for Threads to Finish ---
        // We must wait for all 500 threads to complete their work
        // before we print the final total.
        try {
            for (int i = 0; i < numberOfUsers; i++) {
                threads[i].join(); // Main thread pauses here until thread[i] is dead
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // --- PHASE 3: Verify Result ---
        System.out.println("All threads finished.");
        System.out.println("Expected Count: 500");
        System.out.println("Actual Count:   " + counter.getViewerCount());

        if (counter.getViewerCount() == 500) {
            System.out.println("Result: SUCCESS! Count is accurate.");
        } else {
            System.out.println("Result: FAILURE! Race condition detected.");
        }
    }
}