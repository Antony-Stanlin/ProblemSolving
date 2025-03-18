import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[][] = new int[n][n];
        int start = n / 2;
        nums[0][start] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (j > 0)
                        nums[i][j] += nums[i - 1][j - 1];
                    if (j < n - 1)
                        nums[i][j] += nums[i - 1][j + 1];
                }
                if (j >= start && j < n - start)
                    System.out.print(nums[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
            if (i < n / 2)
                start--;
            else
                start++;
        }
    }
}