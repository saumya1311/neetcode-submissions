class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //bucket creation
        Map<Integer,Integer> count=new HashMap<>(); //value
        List<Integer>[] freq=new List[nums.length+1]; //index

        for (int i=0;i<freq.length;i++){
            freq[i]=new ArrayList<>();
        }

        for(int n:nums){ // this would add the no. of ele added how mny times
        // if arr=[1,1,1,2,2,,2,2,,3,3,4,5] 
        //then count would be{1={4,5},2={3,1},4=2} i.e. 4,5 occured one time
            count.put(n,count.getOrDefault(n,0)+1);
        }


        //adding the count in entry as set form
        //then adding the entry set values in freq w key and values
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] pr = new int[k];
        int idx = 0;

        for (int i = freq.length - 1; i > 0 && idx < k; i--) {
            for (int n : freq[i]) {
                pr[idx++] = n;
                if (idx == k) return pr;
            }
        }

        return pr;
        
    }
}
