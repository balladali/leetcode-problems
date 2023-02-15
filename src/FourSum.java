import java.util.*;

/*
    Link: https://leetcode.com/problems/4sum
    Algorithm: https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int x = nums[i] + nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    long sum = nums[l] + nums[r];
                    if (sum + x == target) {
                        result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum + x > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
