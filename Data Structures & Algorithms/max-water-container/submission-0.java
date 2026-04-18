class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int l=0;
        int r=heights.length-1;

        while(l<r){
            int width=r-l;
            int area=Math.min(heights[l],heights[r])*width;

            max=Math.max(max,area);

            if(heights[l]>heights[r]){
                r--;
            } else{l++;};
        }
        return max;
    }
}
