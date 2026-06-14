class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                answer.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}