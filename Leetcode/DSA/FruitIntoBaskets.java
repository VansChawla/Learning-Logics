import java.util.HashMap;
import java.util.Map;

class FruitIntoBaskets {
    // Sliding window approach
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;

        for(int r=0; r<fruits.length; r++){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }

            maxFruits = Math.max(maxFruits, r-l+1);
        }

        return maxFruits;
    }
    // Old Approach
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