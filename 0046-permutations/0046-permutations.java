import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // store a copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used numbers

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(result, current, nums, used);

            // un-choose (backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.permute(new int[]{1,2,3}));
        System.out.println(sol.permute(new int[]{0,1}));
        System.out.println(sol.permute(new int[]{1}));
    }
}
