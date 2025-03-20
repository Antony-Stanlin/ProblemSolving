public class SpiralPrinting {
    public static void main(String[] args) {
        int nums[][]={{1,2,3,4,5},
                    {12,13,14,15,6},
                    {11,10,9,8,7}};
        int top=0,bottom=nums.length-1,left=0,right=nums[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                System.out.print(nums[top][i]+" ");
            }
            top++;
            for(int i=top;i<=bottom;i++){
                System.out.print(nums[i][right]+" ");
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    System.out.print(nums[bottom][i]+" ");
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(nums[i][left]+" ");
                }
                left++;
            }
        }   
    }
    
}
