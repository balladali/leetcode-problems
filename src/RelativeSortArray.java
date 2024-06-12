/*
    Link: https://leetcode.com/problems/relative-sort-array
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for (int num: arr1) {
            map[num]++;
        }
        int[] result = new int[arr1.length];
        int i = 0;
        int j = 0;
        while (i < arr2.length) {
            while (map[arr2[i]]-- > 0) {
                result[j++] = arr2[i];
            }
            i++;
        }
        for (int k = 0; k < 1001; k++) {
            while (map[k]-- > 0) {
                result[j++] = k;
            }
        }
        return result;
    }
}
