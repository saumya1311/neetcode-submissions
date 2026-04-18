class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m= nums1.length;
        int n= nums2.length;

        int start=0;
        int end=m;

        while(start<=end){
            int partX= (start+end)/2;
            int partY = (m+n+1)/2-partX;

            int xl= partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            int xr = partX==m ? Integer.MAX_VALUE : nums1[partX];

            int yl= partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            int yr= partY==n ? Integer.MAX_VALUE : nums2[partY];

            if (xl<=yr && yl <= xr){
                if((m+n)%2==0){
                    return ((double) Math.max(xl,yl) + Math.min(xr,yr))/2.0;
                }else{
                    return Math.max(xl, yl);
                }
            }else if (xl>yr){
                end=partX-1;
            }else{
                start=partX+1;
            }
        }
        return 0;
    }
}