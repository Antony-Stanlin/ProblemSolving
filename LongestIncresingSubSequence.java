public class LongestIncresingSubSequence {
    public static void main(String[] args) {
        int nums[]={1,2,4,6,7,8,9,10,1,2,3,1,6,7};
        int maxLength=0;
        int currentLength=1;
        int pos=0;
        boolean hasChange=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                if(!hasChange){
                    currentLength++;
                    hasChange=true;
                    pos=i-1;
                    continue;
                }
                maxLength=Math.max(currentLength,maxLength);
                currentLength=i-1-pos;
                pos=i-1;
            }
            currentLength++;
        }
        System.out.println(Math.max(maxLength, currentLength));
    }
}
