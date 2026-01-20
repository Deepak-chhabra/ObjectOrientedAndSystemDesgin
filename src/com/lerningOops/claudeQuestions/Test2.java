package com.lerningOops.claudeQuestions;

/*
   *2.    Getters and Setters
   *      Create a BankAccount class with private attributes: accountNumber, balance.
   *      Implement getters and setters with validation (balance cannot be negative).
   *
 */

import java.util.Objects;

class BankAccount{
    static final double MINI_BALANCE = 999.0 ;
    private final String accountNumber ;
    private double balance ;

    BankAccount(String accountNumber , double balance ){
        validateAccountNumber(accountNumber);
        validateBalance(balance);
        this.accountNumber = accountNumber.trim();
        this.balance = balance;
    }
    // ==================Validators======================================
    private static void validateAccountNumber(String accountNumber){
        if(accountNumber == null || !(accountNumber.matches("\\d{10,15}")))
            throw new IllegalArgumentException("Account number should be appropriate length");
    }
    private static void validateBalance(double balance){
        if(balance < MINI_BALANCE ){
            throw new IllegalArgumentException("Insufficient initial funds");
        }
    }

    // ========== Getters and setters ===========================

    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

    // ========== OPERATIONS ===================

    public void withdraw(double amount){
        if(amount <=0){
            throw new IllegalArgumentException("Amount should be positive");
        }

        if(this.balance - amount < MINI_BALANCE ){
            throw new IllegalArgumentException("Insufficient Funds!");
        }

        balance = balance - amount;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount should be  positive");
        }
        balance += amount;
    }

    public String toString(){
        return String.format("Account Number: %s\n" +
                             "Balance: %.2f", accountNumber , balance);
    }

    // =========== Hashcode and equals override =====================

    public boolean equals(Object account){

        if(account == this ) return false ;

        if(!(account instanceof BankAccount)) return false ;

        BankAccount a  = (BankAccount) account ;
        return accountNumber.equals(a.accountNumber);
    }

    public int  hashCode(){
        return Objects.hashCode(accountNumber);
    }
}
public class Test2 {

    public static void main(String[] args) {
        BankAccount  account1 = new BankAccount("2021218207", 40953.23);
        System.out.println(account1);
        double amount = 5623;
        account1.deposit(amount);
        System.out.println("Amount deposited :" + amount);
        System.out.println(account1);
        account1.withdraw(amount);

        System.out.println("Amount withdraw :" + amount);
        System.out.println(account1);


    }
}
