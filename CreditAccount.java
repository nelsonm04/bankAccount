public class CreditAccount extends Account{
    private double creditlimit;
    CreditAccount(){
        super(); //calling default constructor from the parent class
        this.creditlimit = 0;
    }
   public CreditAccount(double balance, double creditlimit){
        super(balance);
        this.creditlimit = creditlimit;
   }

   public CreditAccount(CreditAccount other){
        super(other);
        this.creditlimit = other.creditlimit;
   }
   public double getCreditlimit(){
        return creditlimit;
   }

    public void setCreditlimit(double creditlimit) {
        this.creditlimit = creditlimit;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > 0){
            double newBalance = getBalance() + amount;
            setBalance(newBalance);
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && (getBalance() - amount) >= -creditlimit){
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            return true;
        }
        return false;
    }
    public String toString(){
        return "CreditAccount { Balance: "+ getBalance() + ", Credit Limit: " + creditlimit + " }";
    }
}
