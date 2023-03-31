/*
    Link: https://leetcode.com/problems/first-bad-version
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
