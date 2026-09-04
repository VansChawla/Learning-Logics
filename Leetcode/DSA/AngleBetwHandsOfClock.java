class Solution {
    public double angleClock(int hour, int minutes) {
        // Minute hand moves 6 degrees per minute (360 / 60)
        double minuteAngle = minutes * 6.0;
        
        // Hour hand moves 30 degrees per hour (360 / 12) + 0.5 degrees per minute (30 / 60)
        // Using (hour % 12) safely converts 12 o'clock to 0
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        
        double diff = Math.abs(hourAngle - minuteAngle);
        
        return Math.min(diff, 360.0 - diff);
    }
}