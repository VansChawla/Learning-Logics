import java.util.Arrays;

public class MinimumCostforCuttingCakeI_ChocolaProblem {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        for (int i = 0; i < horizontalCut.length / 2; i++) {
            int temp = horizontalCut[i];
            horizontalCut[i] = horizontalCut[horizontalCut.length - 1 - i];
            horizontalCut[horizontalCut.length - 1 - i] = temp;
        }
        for (int i = 0; i < verticalCut.length / 2; i++) {
            int temp = verticalCut[i];
            verticalCut[i] = verticalCut[verticalCut.length - 1 - i];
            verticalCut[verticalCut.length - 1 - i] = temp;
        }

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < horizontalCut.length && v < verticalCut.length){
            if(verticalCut[v] <= horizontalCut[h]){
                cost += (horizontalCut[h] * vp);
                hp++; h++;
            } else {
                cost += (verticalCut[v] * hp);
                vp++; v++;
            }
        }

        while(h < horizontalCut.length){
            cost += (horizontalCut[h] * vp);
            hp++; h++;
        }

        while(v < verticalCut.length){
            cost += (verticalCut[v] * hp);
            vp++; v++;
        }

        return cost;
    }
}