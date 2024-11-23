import java.util.Scanner;

public class atm{
    int pin;
    double balance;

    // Constructor to initialize pin and balance
    public atm(int pin, double balance){
        this.pin = pin;
        this.balance = balance;
    }

    // Method to verify the PIN
    public boolean verifyPin(Scanner s){
        System.out.println("Enter the pin: ");
        int userPin = s.nextInt();
        return userPin == pin;
    }

    // Method to display the menu
    public void displayMenu(Scanner s){
        int choice;
        do{
        System.out.println("1. Account Balance\n2. Money Deposit\n3. Money Withdrawal\n4. Change Pin\n5. Exit");
        System.out.print("Enter your choice: ");
        choice = s.nextInt();

        switch(choice){
            case 1: 
                accountBalance();
                break;
            case 2: 
                deposit(s);
                break;
            case 3: 
                withdrawal(s);
                break;
            case 4: 
                changePin(s);
                break;
            case 5: 
                end();
                break;
            default: 
                System.out.println("Invalid choice, please enter a valid choice.");
            }
        }while(choice!=5);
    }

    // Method to display account balance
    public void accountBalance(){
        System.out.println("Your Account Balance is: " + balance);
    }

    // Method to deposit money
    public void deposit(Scanner s){
        System.out.print("Enter the amount to deposit: ");
        double amt = s.nextDouble();
        balance += amt;
        System.out.println("Successfully deposited: " + amt);
        accountBalance();
    }

    // Method to withdraw money
    public void withdrawal(Scanner s){
        System.out.print("Enter the amount for withdrawal: ");
        double amt = s.nextDouble();
        if(amt > 0 && amt <= balance){
            balance -= amt;
            System.out.println("Successfully withdrew: " + amt);
            accountBalance();
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }

    }

    // Method to change PIN
    public void changePin(Scanner s){
        System.out.print("Enter your current pin: ");
        int currentPin = s.nextInt();
        if(currentPin == pin){
            System.out.print("Enter new pin: ");
            int newPin = s.nextInt();
            pin = newPin;
            System.out.println("Pin successfully changed.");
        } else {
            System.out.println("Invalid pin.");
        }
    }

    // Method to end the session
    public void end(){
        System.out.println("Thank you for using ATM. Have a good day!");
    }

    // Main method to run the ATM
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        atm a = new atm(1111, 10500);  // Creating ATM object with initial PIN and balance (10500)

        if(a.verifyPin(s)){
            a.displayMenu(s);  // Show menu after successful PIN verification
        } else {
            System.out.println("Invalid pin. Access Denied.");
        }

        s.close();
    }
}
