class BookingAgent implements Runnable {
    String userName;
    Train train;
    int seatsToBook;

    // CORRECT ORDER
    BookingAgent(Train train, String userName, int seatsToBook) {
        this.train = train;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        //this code excuted by threads
        train.bookTicket(this.seatsToBook, this.userName);
    }
}