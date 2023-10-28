import java.util.Arrays;
import java.util.Scanner;

public class NearestSumToTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(",");
        int target = Integer.parseInt(scanner.nextLine());
        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = Integer.parseInt(a[i]);
        }
        System.out.println(Arrays.toString(findNearestSum(array, target)));
    }

    private static int[] findNearestSum(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        int diff = Integer.MAX_VALUE;
        int[] result = new int[] {-1, -1};
        while (l < r) {
            int currentDiff = Math.abs(target - a[r] - a[l]);
            if (currentDiff <= diff) {
                diff = currentDiff;
                result = new int[] {l, r};
            }
            if (a[r] + a[l] > target) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
