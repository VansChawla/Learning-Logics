class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find the maximum pile to set our upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int minSpeed = right; // Store the best valid speed we've found
        
        // Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2; // 'mid' is our guessed speed 'k'
            
            if (canFinish(piles, mid, h)) {
                // If she can finish at this speed, record it!
                minSpeed = mid; 
                // Then try to see if she can eat even slower
                right = mid - 1; 
            } else {
                // If she can't finish, she MUST eat faster
                left = mid + 1; 
            }
        }
        
        return minSpeed;
    }
    
    // Helper method to check if a speed 'k' is valid
    private boolean canFinish(int[] piles, int k, int h) {
        long totalHours = 0; // Use long to prevent integer overflow on massive arrays
        
        for (int pile : piles) {
            // This is a fast integer math way to do Math.ceil(pile / k)
            totalHours += pile / k;
            if (pile % k != 0) {
                totalHours++;
            }
        }
        
        return totalHours <= h;
    }
}