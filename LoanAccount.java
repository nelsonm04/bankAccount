public class LoanAccount extends Account {
    private double interestRate;
    private double interestPaid;
    private double totalPayments;
    private double principlePaid;

    // Default constructor
    public LoanAccount() {
        super();
        this.interestRate = 0;
        this.interestPaid = 0;
        this.totalPayments = 0;
        this.principlePaid = 0;
    }

    // Constructor with balance and interest rate
    public LoanAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
        this.interestPaid = 0;
        this.totalPayments = 0;
        this.principlePaid = 0;
    }

    // Calculate interest on the current balance
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    // Apply a payment to the account
    public boolean makePayment(double amount) {
        if (amount > 0) {
            double interest = calculateInterest();
            double principalPayment = amount - interest;

            // If the principal payment is more than the balance, adjust it
            if (principalPayment > getBalance()) {
                principalPayment = getBalance();
                amount = principalPayment + interest; // Adjust total payment
            }

            // Update balance
            setBalance(getBalance() - principalPayment);

            // Update totals
            principlePaid += principalPayment;
            interestPaid += interest;
            totalPayments += amount;

            return true; // Payment was successful
        }
        return false; // Invalid payment amount
    }

    // Override withdraw method from Account
    @Override
    public boolean withdraw(double amount) {
        double totalAmount = amount + calculateInterest();
        if (totalAmount <= getBalance() && amount > 0) {
            setBalance(getBalance() - totalAmount);
            principlePaid += amount;
            interestPaid += calculateInterest();
            totalPayments += totalAmount;
            return true; // Withdrawal successful
        }
        return false; // Invalid withdrawal amount or insufficient balance
    }

    // Override deposit method from Account
    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            totalPayments += amount;
            return true; // Deposit successful
        }
        return false; // Invalid deposit amount
    }

    // Getters for totals
    public double getPrinciplePaid() {
        return principlePaid;
    }

    public double getInterestPaid() {
        return interestPaid;
    }

    public double getTotalPayments() {
        return totalPayments;
    }
}
