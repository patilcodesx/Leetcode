class Bank {
    Map<Integer,Long> map = new HashMap<>();
    public Bank(long[] balance) {
      
        for(int i=0;i<balance.length;i++){
            map.put(i+1,balance[i]);
        }
        for(Map.Entry<Integer,Long> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
    
    public boolean transfer(int account1, int account2, long money) {
        if( account1>map.size() || account2>map.size() || map.get(account1)<money){
            return false;
        }
        map.put(account1,map.get(account1)-money);
        map.put(account2,map.get(account2)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>map.size()){
            return false;
        }
       map.put(account,map.get(account)+money);
       return true;
    }
    
    public boolean withdraw(int account, long money) {
        System.out.println(map.size());
        if(account>map.size() || map.get(account)<money){
            return false;
        }
        System.out.println(account);
        map.put(account,map.get(account)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */