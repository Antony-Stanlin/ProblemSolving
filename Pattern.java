import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int diff = i;
            for (int j = 0; j < i; j++) {
                System.out.print(diff + " ");
                diff = diff + (n - 1 - j);
            }
            System.out.println();
        }
        sc.close();
    }
}

/*
 * input: n=4
 * output:
 * 1
 * 2 5
 * 3 6 8
 * 4 7 9 10
 * 
 * input: n=5
 * output:
 * 1
 * 2 6
 * 3 7 10
 * 4 8 11 13
 * 5 9 12 14 15
 */
