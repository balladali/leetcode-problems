import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// [1,1,0]
// [0,0,1,1,0,1,1,0]
// [1,1,1,0,1,1,0,1,1,1,1,1,1]

public class MaxOneSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(",");
        System.out.println(getMaxLength(a));
    }

    private static int getMaxLengthWithList(String[] a) {
        int maxCount = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (String s : a) {
            if ("1".equals(s)) {
                count++;
            } else if (count > 0) {
                list.add(count);
                count = 0;
            }
        }
        list.add(count);

        for (int i = 1; i < list.size(); i++) {
            maxCount = Math.max(maxCount, list.get(i) + list.get(i - 1));
        }
        return maxCount;
    }

    private static int getMaxLength(String[] a) {
        int maxCount = 0;
        int count = 0;
        int previous = 0;

        for (String s : a) {
            if ("1".equals(s)) {
                count++;
            } else if (count > 0) {
                maxCount = Math.max(maxCount, previous + count);
                previous = count;
                count = 0;
            }
        }
        return Math.max(maxCount, previous + count);
    }
}
