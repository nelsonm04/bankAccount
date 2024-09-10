import java.util.*;

    public class Main {

        public static void main(String[] args) {
        //creating objects

            DebitAccount dbt1 = new DebitAccount();
            DebitAccount dbt2 = new DebitAccount(25);

            dbt1.deposit(100);
            dbt1.withdraw(25);

            dbt2.deposit(10);

            System.out.println(dbt1.toString());
            System.out.println(dbt2.toString());

            //Credit Account

            CreditAccount crd1 = new CreditAccount(100,500);
            CreditAccount crd2 = new CreditAccount(0,3000);



            crd2.deposit(1000); //expenditure
            crd2.withdraw(10); // payment

            System.out.println(crd2);

            System.out.println(crd1.toString());
            System.out.println();

            LoanAccount loanAcc1 = new LoanAccount(1000, 5);
            System.out.println("Initial Balance: " + loanAcc1.getBalance());

            // Deposit 500 into the account
            loanAcc1.deposit(500);
            System.out.println("After Deposit of 500, Balance: " + loanAcc1.getBalance());

            // Make a payment of 200
            loanAcc1.makePayment(200);
            System.out.println("After Payment of 200, Balance: " + loanAcc1.getBalance());

            // Make another payment of 300
            loanAcc1.makePayment(300);
            System.out.println("After Payment of 300, Balance: " + loanAcc1.getBalance());

            // Withdraw 150
            boolean withdrawSuccess = loanAcc1.withdraw(150);
            System.out.println("Withdraw 150 Successful: " + withdrawSuccess);
            System.out.println("After Withdrawal, Balance: " + loanAcc1.getBalance());

            // Display totals
            System.out.println("Total Principal Paid: " + loanAcc1.getPrinciplePaid());
            System.out.println("Total Interest Paid: " + loanAcc1.getInterestPaid());
            System.out.println("Total Payments Made: " + loanAcc1.getTotalPayments());


        }
    }

