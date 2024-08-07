// https://leetcode.com/problems/two-sum

class TwoSum {
    public int[] twoSum(int []nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        for (int i = 0; i <= nums.length-1; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (pairMap.containsKey(moreNeeded)) {
                ans[0] = pairMap.get(moreNeeded);
                ans[1] = i;
                return ans;
            }
            pairMap.put(nums[i], i);
        }
        return ans;
    }

}