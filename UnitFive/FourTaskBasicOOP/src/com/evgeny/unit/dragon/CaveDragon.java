package com.evgeny.unit.dragon;

import com.evgeny.unit.treasure.Treasure;
import com.evgeny.unit.treasure.TreasureIron;
import com.evgeny.unit.treasure.TreasureGold;
import com.evgeny.unit.treasure.TreasureCrystal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CaveDragon {
    //private Treasure treasure;
    private List<Treasure> treasureList;
    private int idGenerator;

    public enum TreasureType {COIN, CUP, SCEPTER, SWORD, BOOT, GLOVE, ARMOR, RING, CAP, AMULET, SHIELD, ARTIFACT}
    //public enum TreasureName {GOBLIN, ORC, SNAKE, CRAB, DRAGON, ELF, DIVINE, WOLF, BEAR, PHANTOM} // использовалось для заполнения имени вещи

    public CaveDragon() {
        treasureList = new ArrayList<>();
        this.idGenerator = 1;
        // generatorTreasure(); //использовалось для рандомного заполнения списка сокровищ, которые потом записались в файл
    }

    public List<Treasure> getTreasureList() {
        return treasureList;
    }

    public void setTreasureList(List<Treasure> treasureList) {
        this.treasureList = treasureList;
    }

    public void showTreasure() {
        treasureList.forEach(System.out::println);
    }

    public void greatestTreasure() { //вывод самого дорого сокровища дракона
        double tempCost = 0;
        for (Treasure treasure : treasureList) {
            if (tempCost < treasure.getCost()) {
                tempCost = treasure.getCost();
            }
        }
        for (Treasure treasure : treasureList) {
            if (tempCost == treasure.getCost()) {
                System.out.println(treasure);
            }
        }
    }

    public void chooseTreasuresAmount(Double sum) { //вывод сокровищ на заданную сумму
        List<Treasure> treasureSum = new ArrayList<>();
        treasureList.sort((o1, o2) -> Double.compare(o2.getCost(), o1.getCost()));
        for (Treasure treasure : treasureList) {
            if (treasure.getCost() <= sum) {
                sum -= treasure.getCost();
                treasureSum.add(treasure);
            }
            if (sum == 0) {
                break;
            }
        }
        treasureSum.forEach(System.out::println);
    }
}

//    private void generatorTreasure() { // использовалось для заполнения списка сокровищ, которые потом были записаны в файл
//        Random random = new Random();
//        TreasureType treasureType;
//        TreasureType[] treasureTypes = TreasureType.values();
//        TreasureName[] treasureNames = TreasureName.values();
//        for (int i = 0; i < 100; i++) {
//            treasureType = randomType(treasureTypes);
//            String name = treasureType.name() + " " + randomName(treasureNames);
//            if (i % 2 == 0) {
//                treasureList.add(new TreasureIron(idGenerator, treasureType, name, random.nextInt(1000)));
//            } else if (i % 3 == 0) {
//                treasureList.add(new TreasureCrystal(idGenerator, treasureType, name, random.nextInt(1000)));
//            } else {
//                treasureList.add( new TreasureGold(idGenerator,treasureType, name, random.nextInt(1000)));
//            }
//            idGenerator ++;
//        }
//    }
//    public TreasureName randomName (TreasureName[] treasureNames){ // заполнение рандомными именами сокровищ
//        Random random = new Random();
//        TreasureName treasureN = TreasureName.DRAGON;
//        int x = random.nextInt(treasureNames.length);
//        for(TreasureName treasure : treasureNames) {
//            if (x == treasure.ordinal()){
//                treasureN = TreasureName.valueOf(treasure.name());
//            }
//        }
//        return treasureN;
//    }
//    public TreasureType randomType (TreasureType[] treasureType) { // заполнение рандомными типами сокровищ
//        Random random = new Random();
//        TreasureType treasureT = TreasureType.ARMOR;
//        int x = random.nextInt(treasureType.length);
//        for(TreasureType treasure : treasureType) {
//            if (x == treasure.ordinal()){
//                treasureT = TreasureType.valueOf(treasure.name());
//            }
//        }
//        return treasureT;
//    }