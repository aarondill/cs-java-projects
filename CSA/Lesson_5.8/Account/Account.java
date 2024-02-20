/**
 * Primary java class: Account
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/11/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a class named Account that will describe a checking
 * account for a customer of a bank
 */
public class Account {
  private String first; // represents the first name of the account holder.
  private String last; // represents the last name of the account holder.
  private int acctNum; //  the account number.
  private double balance; // stores the current balance in the account.

  public Account() {
    this.first = "";
    this.last = "";
    this.acctNum = (int) (Math.random() * 999 + 1);
  }

  public Account(String first, String last, double balance) {
    this.first = first;
    this.last = last;
    this.balance = balance;
    this.acctNum = (int) (Math.random() * 999 + 1);
  }

  public Account(Account other) {
    this.first = other.first;
    this.last = other.last;
    this.balance = other.balance;
    this.acctNum = (int) (Math.random() * 999 + 1);
  }

  public String getFirst() {
    return first;
  }

  public String getLast() {
    return last;
  }

  public int getAcctNum() {
    return acctNum;
  }

  public double getBalance() {
    return balance;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  public boolean withdrawal(double amount) {
    if (this.balance < amount) return false;
    this.balance -= amount;
    return true;
  }

  @Override
  public String toString() {
    String temp = ""; // I hate this. let me use String.join()!
    temp += "Customer Name: " + String.join(" ", this.first, this.last) + "\n";
    temp += "Account #: " + this.acctNum + "\n";
    temp += "Current Balance: " + this.balance + "\n";
    return temp;
  }

}
