class Solution {
    public int majorityElement(int[] nums) {

    //Optimal Solution
    int balance = 0;
    int candidate = 0;

    for(int value : nums){

        if(balance==0){
            candidate = value;
        }

        if(value==candidate){
            balance++;
        }else{
            balance--;
        }

    }
    return candidate;
    
    
    
    
    //Better Approach
    //  int threshold = nums.length/2;
    //  HashMap<Integer,Integer> frequencies = new HashMap<>();


    //  for(int value: nums){
    //     int updateFrequency = frequencies.getOrDefault(value,0)+1;
    //     frequencies.put(value,updateFrequency);

    //     if(updateFrequency > threshold){
    //         return value;
    //     }
    //  }
    //  return -1;


    //Brute Force
    //   int threshold = nums.length/2;

    //   for(int candidate: nums){
    //     int frequency = 0;

    //     for(int value: nums){
    //         if(value==candidate){
    //             frequency++;
    //         }
    //     }
    //     if(frequency>threshold){
    //         return candidate;
    //     }
    //   }

    //   return -1;
    }

}