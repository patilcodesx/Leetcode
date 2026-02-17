class Solution {
    public int compress(char[] chars) {
    int write=0;
   
    int i=0;
    int n = chars.length;

    while(i<n){
       char current = chars[i];
       int count =0;
        
        while(i<n && chars[i]==current){
            i++;
            count++;
        }

        chars[write++]= current;

        if(count>1){
            String countstr = String.valueOf(count);
            for(char ch : countstr.toCharArray()){
                chars[write++] = ch;
            }
        } 

    }
    return write;
    }
}