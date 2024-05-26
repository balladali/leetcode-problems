/*
    Link: https://leetcode.com/problems/student-attendance-record-i/
*/
public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int currentLate = 0;
        for (char c: s.toCharArray()) {
            if (c == 'A') {
                if (++absentCount == 2) {
                    return false;
                }
            }
            if (c == 'L') {
                if (++currentLate == 3) {
                    return false;
                }
                continue;
            }
            currentLate = 0;
        }
        return true;
    }
}
