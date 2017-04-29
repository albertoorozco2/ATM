class Account {
       private int balance = 5000;

       public boolean debit(int a) {
              if((balance-a) > 0) {
                     balance = balance -a;
                     return true;//debit successful
              }
              else {
                     return false;//insufficient funds
              }
       }

       public boolean credit(int a) {
        
                balance = balance +a;
                return true;//credit successful
         
  }
       
       public int getBalance() {
              return  balance;
       }
}