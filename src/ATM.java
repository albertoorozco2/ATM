import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
  ATMCard card = new ATMCard();
  Scanner scanner = new Scanner(System.in);
  Account account = new Account();
  ArrayList<Transaction> obj = new ArrayList<>();


  String type;
  int amount;
  String others;

  public ATM() {

    welcome();
    checkCard();
    checkPIN();
    menu();

  }

  public void welcome() {

    System.out.println(
        "\n\n          BANK OF IRELAND \n \n   Welcome to Bank of Ireland ATM \n         Please insert your card \n                     .....  ");

    try {
      Thread.sleep(1000);
      for (int x = 0; x < 4; x++) {
        System.out.println("\n");
      }

      System.out.println("    Thank you we are reading your card\n\n\n");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public void checkCard() {

    if (card.isLocked() == true) {
      System.out.println("\n\n you card is lock please contact to BOI staff12\n\n");
      System.exit(0);
    }

  }

  public void checkPIN() {

    System.out.println("\n\n           Please type your PIN");
    int pin = scanner.nextInt();
    card.pinOK(pin);
    if (card.pinOK(pin) == true) {
      System.out.println("thanks \n\n");
      return;
    } else if (card.pinOK(pin) == false) {
      System.out.println("\n\nWrong PIN! second attemp please try again. \ntype your PIN");
      int pin2 = scanner.nextInt();
      if (card.pinOK(pin2) == true) {
        System.out.println("thanks \n\n");
        return;
      } else if (card.pinOK(pin) == false) {
        System.out.println("\n\nWrong PIN! third attemp please try again. \ntype your PIN");
        int pin3 = scanner.nextInt();
        if (card.pinOK(pin3) == true) {
          System.out.println("thanks \n\n\n");
          return;
        } else if (card.pinOK(pin) == false) {
          card.lockCard();
          System.out.println("\n\nWrong PIN! for 3 times your card is blocked");
          System.out.println("\nyou card is lock please contact to BOI staff\n\n\n");
          System.exit(0);

        }
      }
    }
  }

  public void menu() {
    System.out.println(
        "-----------------\nBANK OF IRELAND\n---------------\n   Main Menu \n1-Withdraw cash \n2-Deposit cash \n3-Check Balance \n4-Change PIN \n5-Exit \nPlease choose an option");

    int option = scanner.nextInt();
    switch (option) {
      case 1:
        System.out.println("\n\n\n\n\n          Withdraw\n\nPlease type the Withdraw amount\n\n\n\n");
        int withdraw = scanner.nextInt();
        if (account.getBalance() >= withdraw) {
          account.debit(withdraw);

          System.out.println(
              "\nWithdraw Successfull \n take your cash\n new balance  $" + account.getBalance());
          type = "withdraw";
          amount = withdraw;
          obj.add(new Transaction(type, amount, others));
          backMainMenu();
        } else {
          while (account.getBalance() < withdraw) {
            System.out.println(
                "\nInsufficient funds would like to try another amount \n 1 - Yes \n 2 - Exit");
            int yon = scanner.nextInt();
            if (yon == 1) {
              System.out.println("\ntry another amount \n type new amount");
              withdraw = scanner.nextInt();
              if (account.getBalance() >= withdraw) {
                account.debit(withdraw);
                System.out.println("\nWithdraw Successfull \n take your cash\n your new balance $"
                    + account.getBalance());
                type = "withdraw";
                amount = withdraw;
                obj.add(new Transaction(type, amount, others));
                backMainMenu();
              }
            } else if (yon == 2) {
              backMainMenu();
            }
          }
        }
        break;
      case 2:
        System.out.println("\n Deposit amount \n\nPlease type the Deposit amount");
        int deposit = scanner.nextInt();
        account.credit(deposit);
        System.out.println("\n Deposit successfull your new Balance $" + account.getBalance());
        type = "deposit";
        amount = deposit;
        obj.add(new Transaction(type, amount, others));

        backMainMenu();
        break;
      case 3:
        System.out.println("\nBalance");
        System.out.println("\n\n Your Balance is $" + account.getBalance());
        type = "balance";
        amount = account.getBalance();
        obj.add(new Transaction(type, amount, others));

        backMainMenu();
        break;
      case 4:
        System.out.println("\nNew PIN \n\n Please type your new PIN");
        int newPIN = scanner.nextInt();
        card.setPin(newPIN);
        System.out.println("\nNew PIN set succesfully");
        type = "new PIN";
        others = "new PIN";
        obj.add(new Transaction(type, amount, others));

        backMainMenu();
        break;
      case 5:
        backMainMenu();
        break;
      default:
        System.out.println("\nplease choose an option");
        break;
    }


  }

  public void backMainMenu() {
    System.out.println("\nPress 1 for main menu or 2 to exit \nand print your receipt");
    int main = scanner.nextInt();
    if (main == 1) {
      menu();
    } else if (main == 2) {
      System.out.println("\nExit");
      System.out
          .println("\nThank you for use Bank of Ireland ATM\nPlease take your receipt and card");

      for (int i = 0; i < obj.size(); i++) {
        obj.get(i).print();;
      }

      System.exit(0);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    new ATM();
  }

}
