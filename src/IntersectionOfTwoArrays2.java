import java.util.*;

/*
    Link: https://leetcode.com/problems/intersection-of-two-arrays-ii
    Algorithm: Two pointers
*/
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int it1 = 0;
        int it2 = 0;
        List<Integer> list = new ArrayList<>();
        while (it1 < nums1.length && it2 < nums2.length) {
            if (nums1[it1] == nums2[it2]) {
                list.add(nums1[it1]);
                it1++;
                it2++;
                continue;
            }
            if (nums1[it1] < nums2[it2]) {
                it1++;
            } else {
                it2++;
            }
        }
        int[] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }

    // ---------- HashMap -----------

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int count = map.getOrDefault(nums1[i], 0) + 1;
            map.put(nums1[i], count);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                int count = map.get(nums2[i]) - 1;
                if (count == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], count);
                }
            }
        }
        int[] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }
}
