import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.*;
import java.util.Map.Entry;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        if (!phoneBook.containsKey(name)) {
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);
            System.out.println("Добавили нового пользователя и его телефон");
        } else {
            numbers = phoneBook.get(name);
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);
            System.out.println("Добавили существующему пользователю еще один номер телефона");
        }
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        return temp;
    }

    public void remove(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            if (phoneBook.get(name).contains(phoneNum)) {
                phoneBook.get(name).remove(phoneNum);
                System.out.println("Удалили у пользователя : " + name + " телефонный номер - " + phoneNum);
            }
        }
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        SortedSet<Map.Entry<String, ArrayList<Integer>>> sortedset = new TreeSet<Map.Entry<String, ArrayList<Integer>>>(
                new Comparator<Entry<String, ArrayList<Integer>>>() {

                    @Override
                    public int compare(Entry<String, ArrayList<Integer>> arg0,
                            Entry<String, ArrayList<Integer>> arg1) {
                        if (arg0.getValue().size() > arg1.getValue().size())
                            return -1;
                        else if (arg0.getValue().size() < arg1.getValue().size())
                            return 1;
                        else
                            return 1;
                    }
                });
        sortedset.addAll(phoneBook.entrySet());
        for (Map.Entry<String, ArrayList<Integer>> em : sortedset) {
            System.out.println(
                    em.getKey() + " : " + em.getValue() + "\n"

            );
        }
        return phoneBook;
    }
}

public class program {
    public static void main(String[] args) {
        String[] names = new String[]{"Ivanov", "Petrov", "Sidorov", "Korovin"};
        int[] numbers = new int[]{123456, 654321, 543122, 321321, 999485, 549313, 194376};

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(names[0], numbers[0]);
        myPhoneBook.add(names[0], numbers[1]);
        myPhoneBook.add(names[1], numbers[1]);
        myPhoneBook.add(names[2], numbers[2]);
        myPhoneBook.add(names[3], numbers[3]);
        myPhoneBook.add(names[3], numbers[4]);
        myPhoneBook.add(names[3], numbers[5]);
        myPhoneBook.add(names[2], numbers[6]);

        System.out.println("Номера телефонов по имени " + names[0] + " : " + myPhoneBook.find(names[0]) + "\n");
        PhoneBook.getPhoneBook();
        myPhoneBook.remove("Ivanov", 123456);
        // PhoneBook.getPhoneBook();
    }
}