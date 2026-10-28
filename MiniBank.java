import java.util.Scanner;

public class MiniBank
{
    record BankInfo(String name,String Branch){};
     enum MenuOption
      {
        OPEN_ACCOUNT,DEPOSIT,WITHDRAW,TRANSFER,EXIT;
      };

        static class Account
        {
                private static int nextAccountNumber = 1001;
                private final int accountNumber;
                private final String ownerName;
                private double balance;

                Account(String ownerName)
                {
                        this(ownerName, 0);
                }

                Account(String ownerName, double balance)
                {
                        this.accountNumber = nextAccountNumber++;
                        this.ownerName = ownerName;
                        this.balance = balance;
                }

                void deposit(double amount)
                {
                        if (amount > 0) balance += amount;
                }

                void withdraw(double amount)
                {
                        if (amount > 0 && amount <= balance) balance -= amount;
                }

                int getAccountNumber()
                {
                        return accountNumber;
                }

                String getOwnerName()
                {
                        return ownerName;
                }

                double getBalance()
                {
                        return balance;
                }
        }

    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter the bank name");
        String BankName=sc.nextLine();
        System.out.println("Enter the branch of the bank");
        String BankBranch=sc.next();
        BankInfo bank = new BankInfo(BankName,BankBranch);
        System.out.println("================================");
        System.out.println("Welcome to " + bank.name());
        System.out.println("Branch : " + bank.Branch());
        System.out.println("================================");

        Account[] accounts = new Account[3];

        accounts[0] = new Account("Rahul", 5000);
        accounts[1] = new Account("Priya", 10000);
        accounts[2] = new Account("Amit");

        accounts[0].deposit(2000);
        accounts[1].deposit(3000);
        accounts[2].deposit(5000);

        accounts[0].withdraw(1000);
        accounts[1].withdraw(2000);
        accounts[2].withdraw(500);

        System.out.println("\n===== ACCOUNT BALANCES =====");
       for (Account account : accounts) {
            System.out.println(
                    account.getAccountNumber()
                    + " | "
                    + account.getOwnerName()
                    + " | Balance: ₹"
                    + account.getBalance()
            );
        }

     
      int choice=0;
     do
      {
      System.out.println("1. Open Account");
      System.out.println("2. Deposit Money");
      System.out.println("3. Withdraw Money");
      System.out.println("4. Transfer Money");
      System.out.println("5. Exit MiniBank");
      System.out.println("Enter your choice");
      choice=sc.nextInt();
       switch (choice) {
                case 1 -> System.out.println(MenuOption.OPEN_ACCOUNT +
                        " - To be implemented in a later lab");

                case 2 -> System.out.println(MenuOption.DEPOSIT +
                        " - To be implemented in a later lab");

                case 3 -> System.out.println(MenuOption.WITHDRAW +
                        " - To be implemented in a later lab");

                case 4 -> System.out.println(MenuOption.TRANSFER +
                        " - To be implemented in a later lab");
                 case 5 -> System.out.println("Thank you for using MiniBank!");

                default -> System.out.println("Invalid choice. Please try again.");
       }
       System.out.println("================================");
      } while(choice!=5);
       
      sc.close();

      }
    
    }