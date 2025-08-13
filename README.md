# Bank Account State Management System

A Java implementation of the **State Design Pattern** for managing bank account states with different behavioral rules and restrictions.

## 📋 Overview

This project demonstrates how to implement the State pattern to manage different states of bank accounts (Active, Suspended, and Closed) without using conditional statements. Each state has specific rules regarding allowed operations, making the system more maintainable and extensible.

## 🏗️ Architecture

The system uses the **State Design Pattern** to encapsulate state-specific behavior in separate classes, eliminating the need for complex conditional logic in the main `Account` class.

### Core Components

- **`Account`** - The context class that maintains a reference to the current state
- **`AccountState`** - Interface defining the contract for all state implementations
- **`ActiveState`** - Handles behavior when account is active
- **`SuspendedState`** - Handles behavior when account is suspended  
- **`ClosedState`** - Handles behavior when account is closed

## 🎯 Features

### Account States & Permissions

| State | Deposit | Withdraw | Activate | Suspend | Close | View Info |
|-------|---------|----------|----------|---------|-------|-----------|
| **Active** | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ |
| **Suspended** | ❌ | ❌ | ✅ | ❌ | ✅ | ✅ |
| **Closed** | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ |

### State Transitions

```
Active ←→ Suspended
   ↓        ↓
Closed ←→ Closed
```

- **Active → Suspended**: Account can be suspended
- **Suspended → Active**: Account can be reactivated
- **Active/Suspended → Closed**: Account can be closed
- **Closed**: Terminal state (no further transitions allowed)

## 📁 Project Structure

```
bank-account-state-pattern/
├── src/
│   ├── Account.java             # Main account class
│   ├── AccountState.java        # State interface
│   ├── ActiveState.java         # Active state implementation
│   ├── SuspendedState.java      # Suspended state implementation
│   ├── ClosedState.java         # Closed state implementation
│   └── AccountTest.java         # Test class with examples
└── README.md                    # Project documentation
```

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application

1. **Compile the source files:**
   ```bash
   javac src/*.java
   ```

2. **Run the test class:**
   ```bash
   java -cp src AccountTest
   ```

### Expected Output

```
Account is already activated!
Account is suspended!
Account is activated!

Deposited 1000.0
Account Number: 1234
Balance: 11000.0

Withdrew 100.0. 
Account Number: 1234
Balance: 10900.0

Account is closed!
You cannot activate a closed account!
You cannot suspend a closed account!
You cannot withdraw on a closed account.
Account Number: 1234
Balance: 10900.0

You cannot deposit on a closed account.
Account Number: 1234
Balance: 10900.0
```

## 💻 Code Examples

### Creating and Using an Account

```java
// Create a new account (starts in Active state)
Account account = new Account("1234", 10000.0);

// Perform transactions (allowed in Active state)
account.deposit(1000.0);
account.withdraw(500.0);

// Change account state
account.suspend();  // Active → Suspended
account.activate(); // Suspended → Active
account.close();    // Active → Closed
```

### State-Specific Behavior

```java
// Active state allows all transactions
account.deposit(1000.0);  // ✅ Success
account.withdraw(500.0);  // ✅ Success

// Suspended state blocks transactions
account.suspend();
account.deposit(1000.0);  // ❌ "You cannot deposit on a suspended account"
account.withdraw(500.0);  // ❌ "You cannot withdraw on a suspended account"

// Closed state blocks everything
account.close();
account.activate();       // ❌ "You cannot activate a closed account"
account.deposit(1000.0);  // ❌ "You cannot deposit on a closed account"
```

## 🔧 Implementation Details

### Account Class

```java
public class Account {
    private String accountNumber;
    private double balance;
    private AccountState accountState;  // Current state reference
    
    // Methods delegate to current state
    public void deposit(double amount) {
        accountState.deposit(this, amount);
    }
    
    public void withdraw(double amount) {
        accountState.withdraw(this, amount);
    }
    // ... other methods
}
```

### State Interface

```java
public interface AccountState {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void suspend(Account account);
    void activate(Account account);
    void close(Account account);
}
```

## 🎨 Design Pattern Benefits

### ✅ Advantages

- **Eliminates conditional statements**: No if-else or switch statements needed
- **Single Responsibility**: Each state class handles only its specific behavior
- **Open/Closed Principle**: Easy to add new states without modifying existing code
- **Maintainability**: State-specific logic is isolated and easy to modify
- **Extensibility**: New states can be added without changing the Account class

### 🔄 State Transitions

State transitions are handled within each state implementation:

```java
// In ActiveState
public void suspend(Account account) {
    account.setAccountState(new SuspendedState());
    System.out.println("Account is suspended!");
}
```

## 🧪 Testing

The `AccountTest` class provides comprehensive testing of:

- ✅ State transitions (Active ↔ Suspended → Closed)
- ✅ Transaction permissions in each state
- ✅ Error handling for invalid operations
- ✅ Account information display

## 🤝 Contributing

Feel free to contribute to this project by:

1. Forking the repository
2. Creating a feature branch
3. Making your changes
4. Adding tests for new functionality
5. Submitting a pull request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The State pattern is particularly useful when an object's behavior depends on its state and the number of states is large or frequently changing.
