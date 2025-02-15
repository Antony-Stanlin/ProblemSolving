
import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter the size of the array:");
        int n=sc.nextInt();
        sc.nextLine();
        int min=Integer.MAX_VALUE;

        String s[]=new String[n];

        for(int i=0;i<n;i++){
            s[i]=sc.nextLine();
            min=Math.min(min,s[i].length());
        }

        System.out.println(LCP(s,min));


    }

    public static String LCP(String[] args,int min) {
        if(args==null || args.length==0)
            return "";

        String result=args[0].substring(0,min);

        for(int i=1;i<args.length;i++){
            while(!result.equals(args[i].substring(0,min))){
                min--;
                result=result.substring(0,min);
            }
        }
        return result;
    }
}
