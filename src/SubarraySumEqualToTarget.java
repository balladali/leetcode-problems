import java.util.Arrays;
import java.util.Scanner;

public class SubarraySumEqualToTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(",");
        int target = Integer.parseInt(scanner.nextLine());
        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = Integer.parseInt(a[i]);
        }
        findSubArray(array, target);
    }

    private static void findSubArray(int[] a, int target) {
        int currentSum = a[0];
        int start = 0;
        for (int i = 1; i < a.length; i++) {
            while (currentSum > target && start < i - 1) {
                currentSum -= a[start];
                start++;
            }
            if (currentSum == target) {
                System.out.println("start=" + start + ", end=" + (i - 1));
                return;
            }
            currentSum += a[i];
        }
        System.out.println("Not found");
    }
}
