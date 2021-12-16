package com.evgeny.unit;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    public  enum Type {CreditAccount, DepositAccount, }
    private int idAccount, idClient;
    private boolean blockAccount;
    private double amountInTheAccount;
    private Type typeAccount;

    public Account(int idAccount, boolean blockAccount, double amountInTheAccount, Type typeAccount){
        this.idAccount = idAccount;
        this.blockAccount = blockAccount;
        this.amountInTheAccount = amountInTheAccount;
        this.typeAccount = typeAccount;
    }

    public static Account getAccount(Scanner scanner, int idGeneratorAccount, int idClient){
        Account account = new Account(idGeneratorAccount, false, 0, Type.DepositAccount);
        System.out.print("Select the account type:\n1 - " + Type.DepositAccount + "\n2 - " +Type.CreditAccount +"\nSelect: ");
        while (true) {
            int value = scanner.nextInt();
            if(value == 1) {
                account.typeAccount = Type.DepositAccount;
                account.amountInTheAccount = randomAccountAmount(value);
                break;
            }
            if(value == 2){
                account.typeAccount = Type.CreditAccount;
                account.amountInTheAccount = randomAccountAmount(value);
                break;
            }
            System.out.print("The item you entered is incorrect, please reenter.");
        }
        return account;
    }

    public boolean isBlockAccount() {
        return blockAccount;
    }

    public void setBlockAccount(boolean blockAccount) {
        this.blockAccount = blockAccount;
    }

    public double getAmountInTheAccount() {
        return amountInTheAccount;
    }

    public void setAmountInTheAccount(double amountInTheAccount) {
        this.amountInTheAccount += amountInTheAccount;
    }

    public Type getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(Type typeAccount) {
        this.typeAccount = typeAccount;
    }

    public int getIdClient() {
        return idClient;
    }

    public static double randomAccountAmount(int value){
        double amountAccount=0;
        DecimalFormat df = new DecimalFormat("#.00");
        if(value == 1){
            amountAccount = Math.round((Math.random() * 5000) * 100);
            amountAccount/=100;
        } else if(value == 2){
            amountAccount = Math.round(((Math.random() * 10000) - 5000)*100);
            amountAccount/=100;
        }
        return amountAccount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", blockAccount=" + blockAccount +
                ", amountInTheAccount=" + amountInTheAccount +
                ", typeAccount=" + typeAccount +
                '}';
    }
}
