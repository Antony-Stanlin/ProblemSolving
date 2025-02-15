
import java.util.Scanner;
import java.util.Stack;

public class DecodeSequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Input : ");
        String message=sc.nextLine();

        System.out.println("output : "+new DecodeSequence().decode(message));
    }
    public String decode(String s){
        Stack<Integer> stack=new Stack<>();
        String result="";

        int len=s.length();

        for(int i=0;i<len+1;i++){
            stack.push(i+1);

            if(i==len || s.charAt(i)=='I'){
                while(!stack.isEmpty()){
                    result+=stack.pop();
                }
            }
        }

        return result;
    }
}
