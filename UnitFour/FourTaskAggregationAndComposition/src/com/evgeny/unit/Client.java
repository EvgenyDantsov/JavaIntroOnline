package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private int idClient;
    private int idGeneratorAccount;
    private List<Account> accountList = new ArrayList<>();
    private String name, surname, email;

    public Client(int idClient, String name, String surname, String email, List<Account> accountList) {
        this.idClient = idClient;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.accountList = accountList;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public int idGeneratorAccount() {
        if (getAccountList().size() > 0) {
            idGeneratorAccount++;
        } else idGeneratorAccount = 1;
        return idGeneratorAccount;
    }

    public static Client getClient(Scanner scanner, int idGeneratorClient) {
        Client client = new Client(idGeneratorClient, "", "", "", new ArrayList<>());
        System.out.print("Enter name client: ");
        client.name = scanner.next();
        System.out.print("Enter surname client: ");
        client.surname = scanner.next();
        System.out.print("Enter email client: ");
        client.email = scanner.next();
        client.accountList.add(client.addAccount());
        return client;
    }

    public void addAccount(boolean newAccount) {
        accountList.add(Account.getAccount(Bank.scanner, idGeneratorAccount()));
    }

    public Account addAccount() {
        return Account.getAccount(Bank.scanner, idGeneratorAccount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient &&
                Objects.equals(accountList, client.accountList) &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(idClient, accountList, name, surname, email);
    }

    @Override
    public String toString() {
        return idClient + "." +
                " name: " + name +
                " surname: " + surname +
                " email: " + email +
                " accountList=" + accountList;
    }
}
