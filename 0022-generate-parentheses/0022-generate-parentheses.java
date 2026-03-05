class Solution {
    List<String> result = new ArrayList<>();

    private void backtrack(int open,int close,int n,String current){
        if(current.length() == 2*n){
            result.add(current);
            return;
        }

       if(open<n){
         backtrack(open+1,close,n,current + "(");
       }


       if(close<open){
        backtrack(open,close+1,n,current+")");
       }

       

    }
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,"");
        return result;
    }
}