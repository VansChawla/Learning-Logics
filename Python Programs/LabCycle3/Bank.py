class OverdraftError(ValueError): pass

class BankAccount:
    def __init__(self, owner, balance=0):
        self.owner = owner
        self._balance = balance

    @property
    def balance(self):
        return self._balance

    def deposit(self, amount):
        if amount > 0:
            self._balance += amount
            print(f"[{self.owner}] Deposited {amount}")

    def withdraw(self, amount):
        if amount > self._balance:
            raise OverdraftError(f"Insufficient funds for {self.owner}. Balance: {self._balance}")
        self._balance -= amount
        print(f"[{self.owner}] Withdrew {amount}")

    def __str__(self):
        return f"Account: {self.owner} | Balance: ${self._balance}"

# --- Simulation ---
try:
    # 1. Create 3 objects
    a1 = BankAccount("Alice", 100)
    a2 = BankAccount("Bob", 50)
    a3 = BankAccount("Charlie")

    # 2. Simulate transactions
    a1.deposit(50)      # Alice: 150
    a2.withdraw(30)     # Bob: 20
    print(a1)
    
    # 3. Trigger Overdraft
    a2.withdraw(100)    # Bob tries to withdraw 100 (has 20)

except OverdraftError as e:
    print(f"Error: {e}")