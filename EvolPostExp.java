import java.util.Scanner;
import java.util.Stack;

public class EvolPostExp {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String:");
        String s=sc.nextLine();
        int length=s.length();
        int result=0;
        
        Stack<Integer> valStack=new Stack<>();
        Stack<String> expStack=new Stack<>();

        for(int i=0;i<length;i++){

            char currChar=s.charAt(i);

            if(Character.isDigit(currChar)){
                if(i>0 && !Character.isDigit(s.charAt(i-1))){
                    expStack.push("["+expStack.pop()+"]");
                }
                valStack.push(currChar-'0');
                expStack.push(currChar+"");
            }

            else{
                if(valStack.size()<2){
                    System.out.println("Unsupported operater");
                    sc.close();
                    return;
                }

                int val2=valStack.pop();
                int val1=valStack.pop();

                String exp2=expStack.pop();
                String exp1=expStack.pop();

                switch (currChar) {
                    case '+' -> result=val1+val2;
                    case '-' -> result=val1-val2;
                    case '*' -> result=val1*val2;
                    case '/' -> {
                        if(val2==0){
                            System.out.println("Zero can't divide any number");
                            sc.close();
                            return;
                        }
                        result=val1/val2;
                    }
                    default -> System.out.println("Invalid Expression");
                }
                
                expStack.push(exp1+currChar+exp2);
                valStack.push(result);
            }
        }

        if(valStack.size()!=1 || expStack.size()!=1){
            System.out.println("Invalid post Expression");
            sc.close();
            return;
        }

        System.out.println(valStack.pop()+""+expStack);
        sc.close();
    }
}
