public interface AccountState {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void suspend(Account account);
    void activate(Account account);
    void close(Account account);
}