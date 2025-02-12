public class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account("1234", 10000.0); // set account to active state
        myAccount.activate(); // displays "Account is already activated!"

        // Suspend the account
        myAccount.suspend(); // displays "Account is suspended!"

        // Activate the account
        myAccount.activate(); // displays "Account is activated!"

        // Deposit into the account
        myAccount.deposit(1000.0); // updates balance and displays account number and balance

        // Withdraw from the account
        myAccount.withdraw(100.0); // updates balance and displays account number and balance

        // Close the account
        myAccount.close(); // displays "Account is closed!"

        // Try activating the closed account
        myAccount.activate(); // displays "You cannot activate a closed account!"

        // Try suspending the closed account
        myAccount.suspend(); // displays "You cannot suspend a closed account!"

        // Try withdrawing from the closed account
        myAccount.withdraw(500.0); // displays "You cannot withdraw on a closed account!"

        // Try depositing into the closed account
        myAccount.deposit(1000.0); // displays "You cannot deposit on a closed account!"
    }
}