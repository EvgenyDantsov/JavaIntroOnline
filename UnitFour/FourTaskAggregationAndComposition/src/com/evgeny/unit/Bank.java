package com.evgeny.unit;

import java.util.*;

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
        }
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
                    System.out.print("Add a new client?\n1. Yes\n2. No.");
                    while (true) {
                        int valueOne = scanner.nextInt();
                        if(valueOne == 1) {
                           clientList.add(Client.getClient(scanner, idGeneratorClient()));
                            break;
                        }
                        if(valueOne == 2){
                            System.out.print("Add a new account to an existing client?\n1. Yes\n2. No.");
                            while (true) {
                                int valueTwo = scanner.nextInt();
                                if(valueTwo == 1) {
                                    String name, surname;
                                    System.out.print("Enter name to an existing client:");
                                    name = scanner.next();
                                    System.out.print("Enter surname to an existing client:");
                                    surname = scanner.next();
                                    Optional<Client> resultSearch = clientList.stream()
                                            .filter(value -> (value.getName().equals(name) && value.getSurname().equals(surname)))
                                            .findAny();
                                    if(!resultSearch.isPresent())
                                    clientList.add(Client.getClient(scanner, idGeneratorClient()));
                                    break;
                                }
                                if(valueTwo == 2){
                                    break;
                                }
                                System.out.print("The item you entered is incorrect, please reenter.");
                            }
                            break;
                        }
                        System.out.print("The item you entered is incorrect, please reenter.");
                    }
                    break;
//                case 2:
//                    System.out.print("Введите автора: ");
//                    in.nextLine();
//                    String nameAuthor = in.nextLine();
//                    printAuthor(nameAuthor);
//                    break;
//                case 3:
//                    System.out.print("Введите издательство: ");
//                    String namePublishingHouse = in.next();
//                    printPublishingHouse(namePublishingHouse);
//                    break;
//                case 4:
//                    System.out.print("Введите год: ");
//                    int yearOfPublication = in.nextInt();
//                    printYearOfPublication(yearOfPublication);
//                    break;
            }
        }
    }
}
