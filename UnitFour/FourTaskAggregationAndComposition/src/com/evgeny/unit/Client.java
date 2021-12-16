package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static int idClient;
    private static int idGeneratorAccount;
    private static List<Account> accountList = new ArrayList<>();
    private String name, surname, email;

    public Client(int idClient, String name, String surname, String email){
        Client.idClient = idClient;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static int getIdClient() {
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

    public static List<Account> getAccountList() {
        return accountList;
    }

    public static int idGeneratorAccount(){
        if(getAccountList().size() > 0) {
            idGeneratorAccount++;
        }else idGeneratorAccount = 0;
        return idGeneratorAccount;
    }

    public static Client getClient(Scanner scanner, int idGeneratorClient) {
        Client client = new Client(idGeneratorClient, "", "", "");
        System.out.print("Enter name client: ");
        client.name = scanner.next();
        System.out.print("Enter surname client: ");
        client.surname = scanner.next();
        System.out.print("Enter email client: ");
        client.surname = scanner.next();
        accountList.add(addAccount());
        return client;
    }

    public static Account addAccount(){
        return Account.getAccount(Bank.scanner, idGeneratorAccount(), getIdClient());
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
