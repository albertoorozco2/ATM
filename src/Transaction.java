
public class Transaction {
  
   String type;
   int amount;
   String others;

  public Transaction(String type, int amount, String others){
    this.type = type;
    this.others = others; 
    this.amount = amount;
    
 }
      
  public void print(){
   System.out.println("\n--------------------------------------------------------\n RECEIPT \n");
    
    
    if(others==null){
      System.out.println("your Transaction of \n" +type+ " for amount $"+amount+" was successfull");
    }else{
      System.out.println("your Transaction of " +type+ " was successfull");
 
    }
    System.out.println("\n--------------------------------------------------------\n");
  
    
  }
  
      
     
}
