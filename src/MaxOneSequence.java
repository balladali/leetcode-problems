import java.util.Scanner;

// [1,1,0]
// [0,0,1,1,0,1,1,0]

public class MaxOneSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(",");
        System.out.println(getMaxLength(a));
    }

    private static int getMaxLength(String[] a) {
        int maxCount = 0;
        int count = 0;
        boolean alreadySkipped = false;

        for (int i = 0; i < a.length; i++) {
            if ("1".equals(a[i])) {
                count++;
            } else {
                if (i - 1 >= 0 && "1".equals(a[i - 1]) && !alreadySkipped) {
                    alreadySkipped = true;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                    alreadySkipped = false;
                }
            }
        }
        return Math.max(maxCount, count);
    }
}
