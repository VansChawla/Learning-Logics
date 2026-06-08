class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for(int right=0; right<fruits.length; right++){
            int currentFruit = fruits[right];
            baskets.put(currentFruit, baskets.getOrDefault(currentFruit,0)+1);

            while(baskets.size() > 2){
                int leftFruit = fruits[left];

                baskets.put(leftFruit, baskets.get(leftFruit) - 1);
                if(baskets.get(leftFruit) == 0){
                    baskets.remove(leftFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
        }

        return maxFruits;
    }
}