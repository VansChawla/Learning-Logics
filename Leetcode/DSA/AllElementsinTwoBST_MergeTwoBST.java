class AllElementsinTwoBST_MergeTwoBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int i=0, j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        return finalArr;
    }

    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}