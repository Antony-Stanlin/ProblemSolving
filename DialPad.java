
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DialPad {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer,Character> map=new HashMap();
        map.put(4,'H');
        map.put(3,'E');
        map.put(5,'L');
        map.put(7,'P');
        String result="";
        for(int i=0;i<4;i++){
            int n=sc.nextInt();
            if(map.containsKey(n))
                result+=map.get(n);

        }
        if(result.length()==4)
            System.out.println(result);
        else 
            System.out.println("invalid");
    }
}
