/*
    Link: https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int elem = matrix[mid / n][mid % n];
            if (elem == target) {
                return true;
            }
            if (elem > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
