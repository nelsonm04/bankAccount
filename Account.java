//private classes require getters and setters
//constructors: default, copy,
public abstract class Account {
    private double balance;



    public Account(){
        this.balance = 0;

    }
    public Account(double _balance){
        this.balance = _balance;
    }
    public Account(Account act){
        this.balance = act.balance;
    }
    // "This" self reference so we know whether or not we are interacting with the parent class or the variable
    public double getBalance(){ //accessor(getter)
        return this.balance;
    }
    public void setBalance(double _balance){ // setter
        this.balance = _balance;
    }

    public abstract boolean deposit(double _amount); //methods
    public abstract boolean withdraw(double _amount);

}
