/**
 * Primary java class: Bank
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/11/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Bank to test Account
 *
 */
public class Bank {
  public static void main(String[] args) {
    Account acct1 = new Account();
    Account acct2 = new Account("Sara", "Sanchez", 60.00);
    Account acct3 = new Account(acct2);
    acct1.setFirst("James");
    acct1.setLast("Bossert");
    acct1.deposit(155.25);
    acct2.deposit(20.00);
    if (!acct2.withdrawal(30.00)) System.out.println("Insufficient Funds\n");
    if (!acct2.withdrawal(100.00)) System.out.println("Insufficient Funds\n");
    acct3.setLast("Wilson");
    acct3.deposit(15.00);
    System.out.println("Customer Name: " + acct3.getFirst() + " " + acct3.getLast());
    System.out.println("Account #: " + acct3.getAcctNum());
    System.out.println("Current Balance: " + acct3.getBalance());
    System.out.println();
    System.out.println(acct1);
    System.out.println(acct2);
    System.out.println(acct3);
  }
}
