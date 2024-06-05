import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Link: https://leetcode.com/problems/intersection-of-two-arrays
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arrToSet;
        int[] arr;
        if (nums1.length > nums2.length) {
            arrToSet = nums2;
            arr = nums1;
        } else {
            arrToSet = nums1;
            arr = nums2;
        }
        Set<Integer> set = new HashSet<>();
        for (int i: arrToSet) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i: arr) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
