public class ReservationSystem {

    public static void main(String[] args) {
        System.out.println("Starting reservation system...");

        // 1. Create ONE shared Train object
        Train javaExpress = new Train(17);

        // 2. Define the task for each agent
        int ticketsPerAgent = 5;

        // 3. Create the Runnable tasks
        BookingAgent agentA = new BookingAgent(javaExpress, "User-A", ticketsPerAgent);
        BookingAgent agentB = new BookingAgent(javaExpress, "User-B", ticketsPerAgent);
        BookingAgent agentC = new BookingAgent(javaExpress, "User-C", ticketsPerAgent);
        BookingAgent agentD = new BookingAgent(javaExpress, "User-D", ticketsPerAgent);

        // 4. Create the Threads and assign tasks to them
        Thread t1 = new Thread(agentA);
        Thread t2 = new Thread(agentB);
        Thread t3 = new Thread(agentC);
        Thread t4 = new Thread(agentD);

        // 5. Start all threads (they will now run concurrently)
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 6. Wait for all threads to finish their job
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // 7. All threads are done. Print the final result.
        System.out.println("All bookings complete.");
        System.out.println("Final number of seats remaining: " + javaExpress.getAvailableSeats());
    }
}
