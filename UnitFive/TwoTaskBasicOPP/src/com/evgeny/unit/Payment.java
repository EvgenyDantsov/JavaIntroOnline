package com.evgeny.unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Payment {
    Scanner in = new Scanner(System.in);
    private double totalDue;
    private Map<String, Double> mapProducts = new HashMap<>();
    private StringBuilder stringBuilders = new StringBuilder();
    private int idPosition;

    public enum Dairy {
        Milk("Milk"), Cheese("Cheese"), Butter("Butter"), Yogurt("Yogurt");
        private final String stringDairy;

        Dairy(final String s) {
            stringDairy = s;
        }

        public String toString() {
            return stringDairy;
        }
    }

    public enum Bakery {
        Bread("Bread"), Cookies("Cookies"), Cake("Cake");
        private final String stringBakery;

        Bakery(final String s) {
            stringBakery = s;
        }

        public String toString() {
            return stringBakery;
        }
    }

    public enum FishAndMeat {
        Salmon("Salmon"), Carp("Carp"), Shrimp("Shrimp"),
        Pork("Pork"), Beef("Beef"), Chicken("Chicken");
        private final String stringFishAndMeat;

        FishAndMeat(final String s) {
            stringFishAndMeat = s;
        }

        public String toString() {
            return stringFishAndMeat;
        }
    }

    public enum FruitsAndVegetables {
        Apple("Apple"), Orange("Orange"), Banana("Banana"),
        Potatoes("Potatoes"), Carrots("Carrots"), Onions("Onions");
        private final String stringFruitsAndVegetables;

        FruitsAndVegetables(final String s) {
            stringFruitsAndVegetables = s;
        }

        public String toString() {
            return stringFruitsAndVegetables;
        }
    }

    Payment() {
        this.mapProducts.put("Milk", 2.1);
        this.mapProducts.put("Cheese", 13.5);
        this.mapProducts.put("Butter", 3.5);
        this.mapProducts.put("Yogurt", 1.69);
        this.mapProducts.put("Bread", 1.43);
        this.mapProducts.put("Cookies", 5.4);
        this.mapProducts.put("Cake", 18.99);
        this.mapProducts.put("Salmon", 25.74);
        this.mapProducts.put("Carp", 12.45);
        this.mapProducts.put("Shrimp", 18.53);
        this.mapProducts.put("Pork", 15.8);
        this.mapProducts.put("Beef", 12.5);
        this.mapProducts.put("Chicken", 11.25);
        this.mapProducts.put("Apple", 2.5);
        this.mapProducts.put("Orange", 4.5);
        this.mapProducts.put("Banana", 2.1);
        this.mapProducts.put("Potatoes", 2.23);
        this.mapProducts.put("Carrots", 3.15);
        this.mapProducts.put("Onions", 2.54);
        this.totalDue = 0;
        this.stringBuilders.append("");
        this.idPosition = 1;
    }

    public class Market {
        Market() {
        }

        public void menu() {
            boolean isSelect = true;
            int choice, number = 1;
            Dairy[] nameDairy = Dairy.values();
            Bakery[] nameBakery = Bakery.values();
            FishAndMeat[] nameFishAndMeat = FishAndMeat.values();
            FruitsAndVegetables[] nameFruitsAndVegetables = FruitsAndVegetables.values();
            while (isSelect) {
                System.out.print("Select an action:" +
                        "\n0. Exit" +
                        "\n1. Buy dairy products" +
                        "\n2. Buy bakery products" +
                        "\n3. Buy FishAndMeat products" +
                        "\n4. Buy FruitsAndVegetables products" +
                        "\n5. Total due" +
                        "\nSelect: ");
                choice = in.nextInt();
                if (choice == 0) {
                    break;
                }
                if (choice < 1 || choice > 6) {
                    System.out.println("Incorrect menu item selected, reenter.");
                    continue;
                }
                switch (choice) {
                    case 1:
                        totalDue = selectDairy(nameDairy, totalDue, number);
                        break;
                    case 2:
                        totalDue = selectBakery(nameBakery, totalDue, number);
                        break;
                    case 3:
                        totalDue = selectFishAndMeat(nameFishAndMeat, totalDue, number);
                        break;
                    case 4:
                        totalDue = selectFruitsAndVegetables(nameFruitsAndVegetables, totalDue, number);
                        break;
                    case 5:
                        System.out.println("\nCheck:");
                        System.out.print(stringBuilders);
                        System.out.println("--------------------");
                        System.out.println("Total: " + totalDue);
                        isSelect = false;
                        break;
                }
            }
        }

        public double selectDairy(Dairy[] nameDairy, double totalDue, int number) {
            double quantityOrWeight;
            int chooseValue;
            while (true) {
                System.out.println("Choose type dairy: ");
                System.out.print("0. Exit\n");
                for (Dairy dairy : nameDairy) {
                    System.out.println(number + ". " + dairy.name());
                    number++;
                }
                number = 1;
                System.out.print("Select: ");
                chooseValue = in.nextInt();
                if (chooseValue == 0) {
                    break;
                }
                for (Dairy dairy : nameDairy) {
                    if ((chooseValue - 1) == dairy.ordinal()) {
                        System.out.print("Enter the quantity or weight of the item: ");
                        quantityOrWeight = in.nextDouble();
                        stringBuilders.append(idPosition)
                                .append(". ")
                                .append(dairy.name())
                                .append(": ")
                                .append(mapProducts.get(dairy.name()))
                                .append(" * ")
                                .append(quantityOrWeight)
                                .append(" = ")
                                .append(mapProducts.get(dairy.name()) * quantityOrWeight)
                                .append("\n");
                        idPosition++;
                        totalDue += mapProducts.get(dairy.name()) * quantityOrWeight;
                    }
                }
            }
            return totalDue;
        }

        public double selectBakery(Bakery[] nameBakery, double totalDue, int number) {
            double quantityOrWeight;
            int chooseValue;
            while (true) {
                System.out.println("Choose type dairy: ");
                System.out.print("0. Exit\n");
                for (Bakery bakery : nameBakery) {
                    System.out.println(number + ". " + bakery.name());
                    number++;
                }
                number = 1;
                System.out.print("Select: ");
                chooseValue = in.nextInt();
                if (chooseValue == 0) {
                    break;
                }
                for (Bakery bakery : nameBakery) {
                    if ((chooseValue - 1) == bakery.ordinal()) {
                        System.out.print("Enter the quantity or weight of the item: ");
                        quantityOrWeight = in.nextDouble();
                        stringBuilders.append(idPosition)
                                .append(". ")
                                .append(bakery.name())
                                .append(": ")
                                .append(mapProducts.get(bakery.name()))
                                .append(" * ")
                                .append(quantityOrWeight)
                                .append(" = ")
                                .append(mapProducts.get(bakery.name()) * quantityOrWeight)
                                .append("\n");
                        idPosition++;
                        totalDue += mapProducts.get(bakery.name()) * quantityOrWeight;
                    }
                }
            }
            return totalDue;
        }

        public double selectFishAndMeat(FishAndMeat[] nameFishAndMeat, double totalDue, int number) {
            double quantityOrWeight;
            int chooseValue;
            while (true) {
                System.out.println("Choose type dairy: ");
                System.out.print("0. Exit\n");
                for (FishAndMeat fishAndMeat : nameFishAndMeat) {
                    System.out.println(number + ". " + fishAndMeat.name());
                    number++;
                }
                number = 1;
                System.out.print("Select: ");
                chooseValue = in.nextInt();
                if (chooseValue == 0) {
                    break;
                }
                for (FishAndMeat fishAndMeat : nameFishAndMeat) {
                    if ((chooseValue - 1) == fishAndMeat.ordinal()) {
                        System.out.print("Enter the quantity or weight of the item: ");
                        quantityOrWeight = in.nextDouble();
                        stringBuilders.append(idPosition)
                                .append(". ")
                                .append(fishAndMeat.name())
                                .append(": ")
                                .append(mapProducts.get(fishAndMeat.name()))
                                .append(" * ")
                                .append(quantityOrWeight)
                                .append(" = ")
                                .append(mapProducts.get(fishAndMeat.name()) * quantityOrWeight)
                                .append("\n");
                        idPosition++;
                        totalDue += mapProducts.get(fishAndMeat.name()) * quantityOrWeight;
                    }
                }
            }
            return totalDue;
        }

        public double selectFruitsAndVegetables(FruitsAndVegetables[] nameFruitsAndVegetables, double totalDue, int number) {
            double quantityOrWeight;
            int chooseValue;
            while (true) {
                System.out.println("Choose type dairy: ");
                System.out.print("0. Exit\n");
                for (FruitsAndVegetables fruitsAndVegetables : nameFruitsAndVegetables) {
                    System.out.println(number + ". " + fruitsAndVegetables.name());
                    number++;
                }
                number = 1;
                System.out.print("Select: ");
                chooseValue = in.nextInt();
                if (chooseValue == 0) {
                    break;
                }
                for (FruitsAndVegetables fruitsAndVegetables : nameFruitsAndVegetables) {
                    if ((chooseValue - 1) == fruitsAndVegetables.ordinal()) {
                        System.out.print("Enter the quantity or weight of the item: ");
                        quantityOrWeight = in.nextDouble();
                        stringBuilders.append(idPosition)
                                .append(". ")
                                .append(fruitsAndVegetables.name())
                                .append(": ")
                                .append(mapProducts.get(fruitsAndVegetables.name()))
                                .append(" * ")
                                .append(quantityOrWeight)
                                .append(" = ")
                                .append(mapProducts.get(fruitsAndVegetables.name()) * quantityOrWeight)
                                .append("\n");
                        idPosition++;
                        totalDue += mapProducts.get(fruitsAndVegetables.name()) * quantityOrWeight;
                    }
                }
            }
            return totalDue;
        }
    }
}
