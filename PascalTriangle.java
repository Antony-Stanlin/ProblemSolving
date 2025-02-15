import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.print("Input : ");
        int n=sc.nextInt();
        
        System.out.println("Output : "+new PascalTriangle().formTriangle(n));
    }

    public List<List<Integer>> formTriangle(int n){
        List<List<Integer>> triangle=new ArrayList();

        if(n>0)   triangle.add(new ArrayList<>(List.of(1)));

        for(int i=1;i<n;i++){
            triangle.add(new ArrayList<>());
            triangle.get(i).add(1);
            for(int j=1;j<i;j++){
                int val=triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j);
                triangle.get(i).add(val);
            }
            triangle.get(i).add(1);
        }

        return  triangle;
    }
}
