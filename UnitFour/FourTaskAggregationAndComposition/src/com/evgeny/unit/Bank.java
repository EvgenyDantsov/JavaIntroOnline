package com.evgeny.unit;

import java.util.*;
import java.util.stream.Stream;

public class Bank {
    private List<Client> clientList = new ArrayList<>();
    private int idGeneratorClient;
    static Scanner scanner = new Scanner(System.in);

    public List<Client> getListClient() {
        return clientList;
    }

    public int idGeneratorClient (){
        if(getListClient().size() > 0) {
            idGeneratorClient++;
        }else idGeneratorClient = 1;
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
                case 1:
                    System.out.print("1. Add a new client?\n2. Add a new account to an existing client?\nSelect: ");
                    while (true) {
                        int valueOne = scanner.nextInt();
                        if(valueOne == 1) {
                           clientList.add(Client.getClient(scanner, idGeneratorClient()));
                            break;
                        }
                        if(valueOne == 2){
                                    String email;
                                    System.out.print("Enter email to an existing client: ");
                                    email = scanner.next();
                                    Optional<Client> resultSearch = clientList.stream()
                                            .filter(value -> (value.getEmail().equals(email)))
                                            .findAny();
                                    if (resultSearch.isPresent()) {
                                            clientList.stream().filter(value -> (value.getEmail().equals(email)))
                                                    .forEach(value ->value.addAccount(true));
                                    }else System.out.print("Client with such email doesn't exist.");
                                    break;
                                }
                        System.out.print("The item you entered is incorrect, please reenter.");
                        }
                    break;
                case 2:
                    System.out.print("Do you want to block the account?\n" +
                            "1. Yes\n" +
                            "2. No\n" +
                            "Select: ");
                    while (true) {
                        List<Client> exitingClientList = new ArrayList<>();
                        int valueOne = scanner.nextInt();
                        if(valueOne == 1) {
                            String email;
                            System.out.print("Enter email to an existing client: ");
                            email = scanner.next();
                            exitingClientList.add((Client) clientList.stream().filter(value -> (value.getEmail().equals(email))));
                            for(int i=0;i<;i++){
                                System.out.println(exitingClientList.get(i));
                            }
//                            clientList.stream().filter(value -> (value.getEmail().equals(email)))
//                                    .forEach(value ->value.getAccountList())
                            break;
                        }
                        if(valueOne == 2){
                            break;
                        }
                        System.out.print("The item you entered is incorrect, please reenter.");
                    }
                    break;
               case 3:
                   clientList.stream().forEach(client -> System.out.println(client.toString()));
//                    System.out.print("Введите издательство: ");
//                    String namePublishingHouse = in.next();
//                    printPublishingHouse(namePublishingHouse);
                    break;
//                case 4:
//                    System.out.print("Введите год: ");
//                    int yearOfPublication = in.nextInt();
//                    printYearOfPublication(yearOfPublication);
//                    break;
            }
        }
    }
}
