public class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account("1234", 10000.0); // Set account to active state
        myAccount.activate(); // Displays "Account is already activated!"

        // Suspend the account
        myAccount.suspend(); // Displays "Account is suspended!"

        // Activate the account
        myAccount.activate(); // Displays "Account is activated!"

        // Deposit into the account
        myAccount.deposit(1000.0); // Updates balance and displays account number and balance

        // Withdraw from the account
        myAccount.withdraw(100.0); // Updates balance and displays account number and balance

        // Close the account
        myAccount.close(); // Displays "Account is closed!"

        // Try activating the closed account
        myAccount.activate(); // Displays "You cannot activate a closed account!"

        // Try suspending the closed account
        myAccount.suspend(); // Displays "You cannot suspend a closed account!"

        // Try withdrawing from the closed account
        myAccount.withdraw(500.0); // Displays "You cannot withdraw on a closed account!"

        // Try depositing into the closed account
        myAccount.deposit(1000.0); // Displays "You cannot deposit on a closed account!"
    }
}
