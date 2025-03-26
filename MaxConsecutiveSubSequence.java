
import java.util.Scanner;

public class MaxConsecutiveSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size: ");
        int size = sc.nextInt();
        int nums[] = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int currentLength = 1;
        int maxLength = 0;
        for (int i = 1; i < size; i++) {
            if (nums[i] != nums[i - 1]) {
                maxLength = (maxLength < currentLength) ? currentLength : maxLength;
                currentLength = 0;
            }
            currentLength++;
        }
        if (maxLength < 2 && currentLength < 2) {
            System.out.println("No subarray found");
        } else {
            System.out.println((maxLength < currentLength) ? currentLength : maxLength);
        }
        sc.close();
    }
}

/*
 * find the length of longest consecutive subsequence in a given array
 * input:
 * 1 0 1 1 0 0 1 1 1 1
 * output:
 * 4
 * 
 * input:
 * 1 1 1 0 1 0 0
 * output:
 * 3
 * 
 * input:
 * 0 0 0 0 0
 * output:
 * 5
 */
