package com.evgeny.unit;

import java.util.*;

public class Bank {
    private List<Client> clientList = new ArrayList<>();
    private int idGeneratorClient;
    static Scanner scanner = new Scanner(System.in);

    public List<Client> getListClient() {
        return clientList;
    }

    public int idGeneratorClient() { //генерация id клиентов
        if (getListClient().size() > 0) {
            idGeneratorClient++;
        } else idGeneratorClient = 1;
        return idGeneratorClient;
    }

    public void menu() {
        while (true) {
            System.out.print(
                    "Select the menu option:\n" +
                            "0. Exit\n" +
                            "1. Add new client and new account(or add account existing client)\n" +
                            "2. Block your account\n" +
                            "3. Search and sort the account client\n" +
                            "4. Calculation of total sum accounts\n" +
                            "5. Calculation of the sum for all accounts," +
                            "having positive and negative balances separately \n" +
                            "Enter the menu item number: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 6) {
                System.out.println("The item you entered is incorrect, please reenter.");
                continue;
            }
            switch (choice) {
                case 1: // Добавление нового клиента или добавление нового счета существующего клиента в базе
                    System.out.print("1. Add a new client?\n2. Add a new account to an existing client?\nSelect: ");
                    while (true) {
                        int valueOne = scanner.nextInt();
                        if (valueOne == 1) {
                            clientList.add(Client.getClient(scanner, idGeneratorClient()));
                            break;
                        }
                        if (valueOne == 2) {
                            String email;
                            System.out.print("Enter email to an existing client: ");
                            email = scanner.next();
                            Optional<Client> resultSearch = clientList.stream()
                                    .filter(value -> (value.getEmail().equals(email)))
                                    .findAny();// ищем есть ли совпадения с веденным email
                            if (resultSearch.isPresent()) {//проверяем существует ли данный клиент с таким email
                                clientList.stream().filter(value -> (value.getEmail().equals(email)))
                                        .forEach(Client::addAccounts);
                            } else System.out.print("Client with such email doesn't exist.");
                            break;
                        }
                        System.out.print("The item you entered is incorrect, please reenter.");
                    }
                    break;
                case 2: // проводим блокировку счета
                    System.out.print("Do you want to block the account?\n" +
                            "1. Yes\n" +
                            "2. No\n" +
                            "Select: ");
                    while (true) {
                        int valueOne = scanner.nextInt();
                        if (valueOne == 1) {
                            int numberAccountBlock;
                            String email;
                            System.out.print("Enter email to an existing client: ");
                            email = scanner.next();
                            for (Client client : clientList) {
                                if (client.getEmail().equals(email)) {
                                    System.out.println("List of accounts: ");
                                    for (Account account : client.getAccountList()) {
                                        System.out.println(account.toString());
                                    }
                                    System.out.print("Select the account number you want to block: ");
                                    numberAccountBlock = scanner.nextInt();
                                    for (Account account : client.getAccountList()) {
                                        if (account.getIdAccount() == numberAccountBlock) {
                                            account.setBlockAccount(true);
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        if (valueOne == 2) {
                            break;
                        }
                        System.out.print("The item you entered is incorrect, please reenter.");
                    }
                    break;
                case 3: // ищем выбранного клиента и сортируем его счета по сумме на каждом счете
                    String email;
                    System.out.print("Enter email to an existing client: ");
                    email = scanner.next();
                    clientList.stream()
                            .filter(value -> value.getEmail().equals(email))
                            .forEach(value -> value.getAccountList()
                                    .sort((o1, o2) -> Double.compare(o2.getAmountInTheAccount(), o1.getAmountInTheAccount())));
                    for (Client client : clientList) {
                        client.getAccountList()
                                .stream()
                                .filter(account -> client.getEmail().equals(email))
                                .forEach(account -> System.out.println(account.toString()));
                    }
                    break;
                case 4: //находим общую сумму по счетам клиента
                    double sum = 0;
                    System.out.print("Enter email to an existing client: ");
                    email = scanner.next();
                    for (Client client : clientList) {
                        if (client.getEmail().equals(email)) {
                            for (Account account : client.getAccountList()) {
                                sum += account.getAmountInTheAccount();
                            }
                        }
                    }
                    System.out.println("Total sum: " + sum);
                    break;
                case 5: // находим сумму по всем счетам имеющих положительный и отрицательные балансы отдельно
                    double sumPositive = 0, sumNegative = 0;
                    System.out.print("Enter email to an existing client: ");
                    email = scanner.next();
                    for (Client client : clientList) {
                        if (client.getEmail().equals(email)) {
                            for (Account account : client.getAccountList()) {
                                if (account.getAmountInTheAccount() > 0) {
                                    sumPositive += account.getAmountInTheAccount();
                                } else sumNegative += account.getAmountInTheAccount();
                            }
                        }
                    }
                    System.out.println("Total sumPositive: " + sumPositive + "\nTotal sumNegative: " + sumNegative);
                    break;
            }
        }
    }
}
