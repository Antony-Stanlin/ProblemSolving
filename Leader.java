import java.util.Scanner;

public class Leader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        int size = sc.nextInt();
        int nums[] = new int[size];
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        sc.close();

        findLeader(nums, nums.length - 1, nums[nums.length - 1]);
        System.out.println();
        findLeader(nums);
        sc.close();

    }

    private static void findLeader(int nums[]) {
        int max = nums[nums.length - 1];
        int start = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (max < nums[i]) {
                nums[--start] = nums[i];
                max = nums[i];
            }
        }

        for (int i = start; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void findLeader(int nums[], int index, int max) {
        if (index < 0)
            return;
        if (index == nums.length - 1 || nums[index] > max) {
            findLeader(nums, index - 1, nums[index]);
            System.out.print(nums[index] + " ");
        } else {
            findLeader(nums, index - 1, max);
        }
    }
}

/*
 * Given an array arr[] of size n, the task is to find all the Leaders in the
 * array. An element is a Leader if it is greater than or equal to all the
 * elements to its right side.
 * 
 * Note: The rightmost element is always a leader.
 * 
 * Examples:
 * 
 * Input: arr[] = [16, 17, 4, 3, 5, 2]
 * Output: [17,5,2]
 * Explanation: 17 is greater than all the elements to its right i.e., [4, 3, 5,
 * 2], therefore 17 is a leader. 5 is greater than all the elements to its right
 * i.e., [2], therefore 5 is a leader. 2 has no element to its right, therefore
 * 2 is a leader.
 * 
 * 
 * Input: arr[] = [1, 2, 3, 4, 5, 2]
 * Output: [5,2]
 * Explanation: 5 is greater than all the elements to its right i.e., [2],
 * therefore 5 is a leader. 2 has no element to its right, therefore 2 is a
 * leader.
 */
