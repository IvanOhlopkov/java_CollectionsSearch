package practice;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        List<String> listNumbers = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        long startBruteForceSearch = System.nanoTime();
        String searchMessage = "номер не найден";
        String coolNumber = "А777НС66";
        if (CoolNumbers.bruteForceSearchInList(listNumbers, coolNumber)) {
            searchMessage = "номер найден";
        }
        long endBruteForceSearch = System.nanoTime();
        System.out.println("Поиск перебором: " + searchMessage + ", поиск занял "
                + (endBruteForceSearch - startBruteForceSearch) + "нс");

        Collections.sort(listNumbers);
        long startBinarySearch = System.nanoTime();
        if (CoolNumbers.binarySearchInList(listNumbers, coolNumber)) {
            searchMessage = "номер найден";
        }
        long endBinarySearch = System.nanoTime();
        System.out.println("Бинарный поиск: " + searchMessage + ", поиск занял "
                + (endBinarySearch - startBinarySearch) + "нс");

        HashSet<String> hashSet = new HashSet<>(listNumbers);
        long startHashSetSearch = System.nanoTime();
        if (CoolNumbers.searchInHashSet(hashSet, coolNumber)) {
            searchMessage = "номер найден";
        }
        long endHashSetSearch = System.nanoTime();
        System.out.println("Поиск в HashSet: " + searchMessage + ", поиск занял "
                + (endHashSetSearch - startHashSetSearch) + "нс");

        TreeSet<String> treeSet = new TreeSet<>(listNumbers);
        long startTreeSetSearch = System.nanoTime();
        if (CoolNumbers.searchInTreeSet(treeSet, coolNumber)) {
            searchMessage = "номер найден";
        }
        long endTreeSetSearch = System.nanoTime();
        System.out.println("Поиск в TreeSet: " + searchMessage + ", поиск занял "
                + (endTreeSetSearch - startTreeSetSearch) + "нс");
    }
}
