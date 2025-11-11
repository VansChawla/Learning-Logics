class Train {
    private int availableSeats;

    // Constructor
    public Train(int initialSeats) {
        this.availableSeats = initialSeats;
        System.out.println("Train created with " + initialSeats + " available seats.");
    }

    public synchronized boolean bookTicket(int seatToBook, String userName){
        if(seatToBook <= availableSeats){
            System.out.println("Success: "+userName+" successfully booked "+seatToBook+" seats.");
            availableSeats -= seatToBook;
            return true;
        }
        else {
            System.out.println("Error: "+userName+"failed to book. Only "+availableSeats+" seats left.");
            return false;   
        }
    }

    // Getter to check the final count
    int getAvailableSeats() {
        return availableSeats;
    }
}