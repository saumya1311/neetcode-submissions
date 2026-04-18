class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        Stack<Integer> stck=new Stack<>();


        int n = heights.length;
        for(int i=0;i<=n;i++){
            int cht=(i==n)?0:heights[i];
            
            while(!stck.isEmpty() && cht<heights[stck.peek()]){
                int l=heights[stck.pop()];
                int w=stck.isEmpty()?i:i-stck.peek()-1;
                maxarea=Math.max(maxarea,l*w);
            }
            stck.push(i);
        }
        return maxarea;
    }
}
