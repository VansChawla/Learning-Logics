class H2O {
    private int hCount = 0;
    private int oCount = 0;

    public H2O() {
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		while (hCount == 2) {
            wait();
        }
        
        hCount++;
        releaseHydrogen.run();
        
        if (hCount == 2 && oCount == 1) {
            hCount = 0;
            oCount = 0;
        }
        
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (oCount == 1) {
            wait();
        }
        
        oCount++;
        releaseOxygen.run();
        
        if (hCount == 2 && oCount == 1) {
            hCount = 0;
            oCount = 0;
        }
        
        notifyAll();
    }
}
