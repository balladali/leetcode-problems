import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
 */
public class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxPosition = Math.max(findMax(seats), findMax(students));
        int[] diff = new int[maxPosition];
        for (int seat: seats) {
            diff[seat - 1]++;
        }
        for (int student: students) {
            diff[student - 1]--;
        }
        int moves = 0;
        int unmatched = 0;
        for (int d: diff) {
            moves += Math.abs(unmatched);
            unmatched += d;
        }
        return moves;
    }

    int findMax(int[] arr) {
        int max = 0;
        for (int elem: arr) {
            max = Math.max(max, elem);
        }
        return max;
    }

    // ----------------------------------------

    public int minMovesToSeat2(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
