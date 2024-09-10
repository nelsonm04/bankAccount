import javax.crypto.KEMSpi;

public class DebitAccount extends Account {

    DebitAccount(){
        super(); //calling default constructor from the parent class
    }
    DebitAccount(double promo){
        setBalance(promo);
    }

    @Override
    public boolean deposit(double _amount) {
        if (_amount <= 0) {
            System.out.println("Must deposit more than $0");
            return false;
        }
        setBalance(getBalance()+_amount);
        /*
            Same as
            double _balance = getBalance();
            _balance = _balance + _amount;
            setBalance (_balance);
        */
        return true;
    }

    @Override
    public boolean withdraw(double _amount) {

        if(_amount > getBalance()){
            System.out.println("Insufficient funds");
            return false;
        }
        if (_amount <= 0){
            System.out.println("You have to deposit more than $0");
            return false;
        }
        double _balance = getBalance();
        _balance = _balance - _amount;
        setBalance(_balance);

        return true;
    }

    @Override
    public String toString() {
        String content = "The current Balance = " + getBalance() + "\n";
        return content;
    }
}
