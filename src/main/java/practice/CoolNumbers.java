package practice;

import java.util.*;
import java.util.stream.Collectors;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> listNumbers= new ArrayList<>();
        String symbols = "АВЕКМНОРСТУХ";
        Random r = new Random();
        String[] numbers = {"111", "222", "333", "444", "555", "666", "777", "888", "999"};
        for (int i = 0; i <=2_100_544; i++){
            String number = r.ints(1,0, symbols.length())
                    .mapToObj(symbols::charAt).map(Object::toString).collect(Collectors.joining())
                    + numbers[r.nextInt(9)]
                    + r.ints(2,0, symbols.length())
                    .mapToObj(symbols::charAt).map(Object::toString).collect(Collectors.joining())
                    +r.nextInt(0,2) + r.nextInt(100);
            listNumbers.add(number);
        }
        return listNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String s : list) {
            if (s.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList, number);
        return index >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
