
import java.util.Scanner;

public class UniqPairSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("string1: ");
        String s1 = sc.nextLine();
        System.out.print("string2: ");
        String s2 = sc.nextLine();
        boolean count = false;
        int length = s1.length();
        if (length < 1) {
            System.out.println("No matches");
            sc.close();
            return;
        }
        while (s1.length() != s2.length()) {
            System.out.println("please enter same size of String");
            System.out.print("String 1: ");
            s1 = sc.nextLine();
            length = s1.length();
            System.out.print("String 2: ");
            s2 = sc.nextLine();
        }
        int start;
        int end;

        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count = true;
                start = i;
                i++;
                while (i < length && s1.charAt(i) != s2.charAt(i)) {
                    i++;
                }
                end = i;
                subString(s1, start, end);
                System.out.print(",");
                subString(s2, start, end);
                System.out.println();
            }
        }
        if (!count) {
            System.out.println("No matches");
        }
        sc.close();
    }

    private static void subString(String s, int start, int end) {
        for (int i = start; i < end; i++)
            System.out.print(s.charAt(i));
    }
}

/*
 * find the pair of substrings which are not match with each others
 * 
 * 
 * input:
 * String1: ArrayONE
 * String2: ArrayTEN
 * output:
 * ONE,TEN
 * 
 * input:
 * String1: sdfghj
 * String2: dsfgkj
 * output:
 * sd,ds
 * h,k
 * 
 * input:
 * String1: hello
 * String2: hello
 * output:
 * No matches
 * 
 * constrain:
 * s1.length()==s2.length()
 * 1<=s1.length(),s2.length()<=10^31
 * 
 */
