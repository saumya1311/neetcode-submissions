class Solution {
    public int characterReplacement(String s, int k) {
       int[] occur=new int[26];
       int l=0;//r=0;
       int ans=0;
       int max=0;

       for(int r=0;r<s.length();r++){
        max=Math.max(max,++occur[s.charAt(r)-'A']);
        if(r-l+1-max>k){
            occur[s.charAt(l)-'A']--;
            l++;
        }
        ans=Math.max(ans,r-l+1);
       } 
       return ans;
    }
}
