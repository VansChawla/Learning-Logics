public class ReplaceElementswithGreatestElementonRight {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentElement = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, currentElement);
        }
        return arr;
    }
}
