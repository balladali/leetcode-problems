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
        System.out.println(Arrays.toString(findSubArray(array, target)));
    }

    private static int[] findSubArray(int[] a, int target) {
        int l = 0;
        int r = 0;
        int sum = a[l];
        while (r < a.length) {
            sum += a[r];
            if (sum == target) {
                return new int[] {l, r};
            }
            if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return new int[] {-1, -1};
    }
}
