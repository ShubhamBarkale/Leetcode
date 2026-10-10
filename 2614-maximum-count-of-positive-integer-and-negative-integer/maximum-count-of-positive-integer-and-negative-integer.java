
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int s = 0, e = n;

        while(s<e){
            int mid =(s+e)/2;
            if(nums[mid]<0){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        int neg =s;
          s = 0;
        e = n;

        while (s<e){
            int mid =(s+e)/2;
            if(nums[mid]<=0){
                s=mid+1;

            }
            else{
                e=mid;
            }
        }
       

            int pos = n-s;
              return Math.max(pos,neg);


      
    
    }
}