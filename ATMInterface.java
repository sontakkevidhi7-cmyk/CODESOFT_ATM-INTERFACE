import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Rs " + amount + " deposited successfully.");
    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }

        else if (amount <= 0) {
            System.out.println("Invalid Amount!");
        }

        else {
            balance = balance - amount;
            System.out.println("Rs " + amount + " withdrawn successfully.");
        }
    }

    // Check Balance Method
    public void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
}

// ATM Class
class ATM {

    private BankAccount account;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    // ATM Menu Method
    public void showMenu() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.checkBalance();
                    break;

                case 2:

                    System.out.print("Enter amount to deposit: Rs ");
                    double depositAmount = sc.nextDouble();

                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid Deposit Amount!");
                    }

                    break;

                case 3:

                    System.out.print("Enter amount to withdraw: Rs ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);

                    break;

                case 4:
                    System.out.println("Thank You for using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

// Main Class
public class ATMInterface {

    public static void main(String[] args) {

        // Create Bank Account
        BankAccount userAccount = new BankAccount(10000);

        // Create ATM Object
        ATM atm = new ATM(userAccount);

        // Start ATM Menu
        atm.showMenu();
    }
}