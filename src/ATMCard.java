class ATMCard{
       private boolean locked = false;
      private int pin = 1234;
              
       public boolean pinOK(int p){
              if(p == pin){
                     return true;
              }
              return false;
       }
       
       public void lockCard(){
              locked = true;
       }
       
       public boolean isLocked(){
              return locked;
       }
       
       public void setPin(int pin) {
         this.pin = pin;
       }
  }