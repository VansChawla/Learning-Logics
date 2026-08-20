class NearestAvailableDrone {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDist = Integer.MAX_VALUE;
        int index = -1;
        
        for(int i=0; i<drones.length; i++){
            int manhDist = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            int range = drones[i][2];
            if(manhDist <= range){
                if(manhDist < minDist){
                    minDist = manhDist;
                    index = i;
                }
            }
        }

        return index;
    }
}