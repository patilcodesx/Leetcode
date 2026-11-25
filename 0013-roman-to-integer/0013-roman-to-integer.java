class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
     
        int sum=0;

        for(int i=0;i<s.length();i++){
         int current = map.get(s.charAt(i));

          if(i+1<s.length() && current <map.get(s.charAt(i+1))){
            sum -= current;
            
          }else{
            sum += current;

          }
        }
       
       return sum;
      
    }
}