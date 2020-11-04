package Lesson5;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class mapTest {

    TaskMap map = new TaskMap();

    @Test
    @Tag("Example")
    void shoppingListCost() {
        HashMap<String, Double> itemCosts = new HashMap<>();
        {
            itemCosts.put("Хлеб", 50.0);
            itemCosts.put("Молоко", 100.0);
        }
        ArrayList<String> actualList = new ArrayList<>();

        actualList.add("Хлеб");
        actualList.add("Молоко");
        assertEquals(150.0, map.shoppingListCost(actualList, itemCosts));

        actualList.add("Кефир");
        assertEquals(150.0, map.shoppingListCost(actualList, itemCosts));

        itemCosts.clear();
        assertEquals(0.0, map.shoppingListCost(actualList, itemCosts));
    }

    @Test
    @Tag("Example")
    void filterByCountryCode() {
        HashMap<String, String> phoneBook = new HashMap<>();
        {
            phoneBook.put("Quagmire", "+1-800-555-0143");
            phoneBook.put("Adam's Ribs", "+82-000-555-2960");
            phoneBook.put("Pharmakon Industries", "+1-800-555-6321");
        }
        HashMap<String, String> testMap = new HashMap<>();
        {
            testMap.put("Quagmire", "+1-800-555-0143");
            testMap.put("Pharmakon Industries", "+1-800-555-6321");
        }

        assertEquals(testMap, map.filterByCountryCode(phoneBook, "+1"));

        testMap.clear();
        testMap.put("Adam's Ribs", "+82-000-555-2960");
        phoneBook.put("Adam's Ribs", "+82-000-555-2960");
        assertEquals(testMap, map.filterByCountryCode(phoneBook, "+82"));

        testMap.clear();
        phoneBook.put("Quagmire", "+1-800-555-0143");
        phoneBook.put("Pharmakon Industries", "+1-800-555-6321");
        assertEquals(testMap, map.filterByCountryCode(phoneBook, "+991"));
    }

    @Test
    @Tag("Example")
    void removeFillerWords() {

        ArrayList<String> actualList = new ArrayList<>(Arrays.asList("Я как-то люблю Котлин".split(" ")));
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("Я люблю Котлин".split(" ")));

        assertEquals(testList, map.removeFillerWords(actualList, "как-то"));

        actualList.clear();
        actualList.addAll(Arrays.asList("Я как-то люблю таки Котлин".split(" ")));
        assertEquals(testList, map.removeFillerWords(actualList, "как-то", "таки"));

        assertEquals(testList, map.removeFillerWords(actualList, "как-то", "таки"));

    }

    @Test
    @Tag("Example")
    void buildWordSet() {
        ArrayList<String> actualList = new ArrayList<>(Arrays.asList("Я люблю Котлин".split(" ")));
        HashSet<String> testSet = new HashSet<>();
        {
            testSet.add("Я");
            testSet.add("люблю");
            testSet.add("Котлин");
        }

        assertEquals(testSet, map.buildWordSet(actualList));

        actualList.add(1, "люблю");
        assertEquals(testSet, map.buildWordSet(actualList));

        actualList.clear();
        testSet.clear();
        assertEquals(testSet, map.buildWordSet(actualList));
    }

    @Test
    @Tag("Easy")
    void buildGrades() {
        HashMap<Integer, ArrayList<String>> testMap = new HashMap<>();
        HashMap<String, Integer> actualMap = new HashMap<>();

        assertEquals(testMap, map.buildGrades(actualMap));


        testMap.put(5, new ArrayList<>(Arrays.asList("Михаил", "Семен")));
        testMap.put(3, new ArrayList<>(Collections.singletonList("Марат")));
        actualMap.put("Марат", 3);
        actualMap.put("Семен", 5);
        actualMap.put("Михаил", 5);
        assertEquals(testMap, map.buildGrades(actualMap));

        testMap.clear();
        testMap.put(3, new ArrayList<>(Arrays.asList("Михаил", "Семен", "Марат")));
        actualMap.clear();
        actualMap.put("Марат", 3);
        actualMap.put("Михаил", 3);
        actualMap.put("Семен", 3);
        assertEquals(testMap, map.buildGrades(actualMap));

        testMap.clear();
        testMap.put(2, new ArrayList<>(Arrays.asList("Михаил", "Семен", "Марат")));
        actualMap.clear();
        actualMap.put("Марат", 2);
        actualMap.put("Михаил", 2);
        actualMap.put("Семен", 2);
        assertEquals(testMap, map.buildGrades(actualMap));

        testMap.clear();
        testMap.put(4, new ArrayList<>(Arrays.asList("Михаил", "Семен", "Марат")));
        actualMap.clear();
        actualMap.put("Марат", 4);
        actualMap.put("Михаил", 4);
        actualMap.put("Семен", 4);
        assertEquals(testMap, map.buildGrades(actualMap));

    }

    @Test
    @Tag("Easy")
    void containsIn() {
        HashMap<String, String> testMap = new HashMap<>();
        HashMap<String, String> actualMap = new HashMap<>();

        actualMap.put("a", "z");
        testMap.put("a", "z");
        testMap.put("b", "sweet");
        assertTrue(map.containsIn(actualMap, testMap));

        testMap.put("a", "zee");
        assertFalse(map.containsIn(actualMap, testMap));

        assertFalse(map.containsIn(testMap, actualMap));
    }

    @Test
    @Tag("Easy")
    void subtractOf() {
        HashMap<String, String> testMap = new HashMap<>();
        HashMap<String, String> actualMap = new HashMap<>();
        HashMap<String, String> helpMap = new HashMap<>();

        testMap.put("a", "z");
        testMap.put("b", "c");
        assertEquals(testMap, map.subtractOf(testMap, actualMap));

        actualMap.put("a", "z");
        helpMap.put("a", "c");
        testMap.remove("b");
        assertEquals(testMap, map.subtractOf(actualMap, helpMap));

        helpMap.clear();
        helpMap.put("a", "z");
        testMap.remove("a");
        assertEquals(testMap, map.subtractOf(actualMap, helpMap));

        actualMap.clear();
        helpMap.put("a", "z");
        helpMap.put("b", "c");
        actualMap.put("a", "z");
        assertEquals(testMap, map.subtractOf(actualMap, helpMap));

    }

    @Test
    @Tag("Easy")
    void whoAreInBoth() {
        assertEquals(new ArrayList<String>(), map.whoAreInBoth(new ArrayList<>(), new ArrayList<>()));

        assertEquals(new ArrayList<>(Collections.singletonList("Марат")), map.whoAreInBoth(new ArrayList<>(Arrays.asList("Марат", "Михаил")), new ArrayList<>(Arrays.asList("Марат", "Кирилл"))));

        assertEquals(new ArrayList<String>(), map.whoAreInBoth(new ArrayList<>(Arrays.asList("Марат", "Михаил")), new ArrayList<>(Arrays.asList("Света", "Кирилл"))));

        assertEquals(new ArrayList<>(Collections.singletonList("Марат")), map.whoAreInBoth(new ArrayList<>(Arrays.asList("Марат", "Михаил", "Алексей", "Света")), new ArrayList<>(Arrays.asList("Марат", "Кирилл"))));

        assertEquals(new ArrayList<String>(), map.whoAreInBoth(new ArrayList<>(Arrays.asList("Михаил", "Алексей", "Света")), new ArrayList<>(Arrays.asList("Марат", "Кирилл"))));

        assertEquals(new ArrayList<String>(), map.whoAreInBoth(new ArrayList<>(Arrays.asList("Марат", "Михаил")), new ArrayList<>(Arrays.asList("Света", "Кирилл", "Алексей"))));
    }

    @Test
    @Tag("Normal")
    void mergePhoneBooks() {
        HashMap<String, String> testMap = new HashMap<>();
        HashMap<String, String> actualMap = new HashMap<>();
        HashMap<String, String> helpMap = new HashMap<>();

        testMap.put("Emergency", "112");
        actualMap.put("Emergency", "112");
        helpMap.put("Emergency", "112");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        testMap.put("Police", "02");
        helpMap.put("Police", "02");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        testMap.clear();
        testMap.put("Emergency", "112, 911");
        testMap.put("Police", "02");
        helpMap.put("Emergency", "911");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        testMap.put("Fire department", "01");
        actualMap.put("Fire department", "01");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        actualMap.remove("Fire department");
        helpMap.put("Fire department", "01");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        testMap.put("Info", "001");
        helpMap.remove("Fire department");
        actualMap.put("Fire department", "01");
        actualMap.put("Info", "001");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));

        testMap.clear();
        helpMap.clear();
        actualMap.clear();
        testMap.put("Emergency", "112");
        actualMap.put("Emergency", "112");
        helpMap.put("Emergency", "112");
        testMap.put("Police", "02");
        actualMap.put("Police", "02");
        assertEquals(testMap, map.mergePhoneBooks(actualMap, helpMap));
    }

    @Test
    @Tag("Normal")
    void averageStockPrice() {
        HashMap<String, Double> testMap = new HashMap<>();
        Multimap<String, Double> actualList = ArrayListMultimap.create();

        assertEquals(testMap, map.averageStockPrice(actualList));

        testMap.put("MSFT", 100.0);
        testMap.put("NFLX", 40.0);
        actualList.put("MSFT", 100.0);
        actualList.put("NFLX", 40.0);
        assertEquals(testMap, map.averageStockPrice(actualList));

        testMap.clear();
        actualList.clear();
        testMap.put("MSFT", 150.0);
        testMap.put("NFLX", 40.0);
        actualList.put("MSFT", 100.0);
        actualList.put("MSFT", 200.0);
        actualList.put("NFLX", 40.0);
        assertEquals(testMap, map.averageStockPrice(actualList));

        testMap.clear();
        actualList.clear();
        testMap.put("MSFT", 150.0);
        testMap.put("NFLX", 45.0);
        actualList.put("MSFT", 100.0);
        actualList.put("MSFT", 200.0);
        actualList.put("NFLX", 40.0);
        actualList.put("NFLX", 50.0);
        assertEquals(testMap, map.averageStockPrice(actualList));
    }


    @Test
    @Tag("Normal")
    void canBuildFrom() {
        assertFalse(map.canBuildFrom(new ArrayList<>(), "foo"));
        assertTrue(map.canBuildFrom(new ArrayList<>(Arrays.asList('a', 'b', 'o')), "baobab"));
        assertFalse(map.canBuildFrom(new ArrayList<>(Arrays.asList('a', 'm', 'r')), "Marat"));
    }


    @Test
    @Tag("Normal")
    void extractRepeats() {
        HashMap<String, Integer> testMap = new HashMap<>();
        assertEquals(testMap, map.extractRepeats(new ArrayList<>()));

        testMap.put("a", 2);
        assertEquals(testMap, map.extractRepeats(new ArrayList<>(Arrays.asList("a", "b", "a"))));

        testMap.put("d", 3);
        assertEquals(testMap, map.extractRepeats(new ArrayList<>(Arrays.asList("a", "b", "a", "d", "d", "d"))));

        testMap.clear();
        assertEquals(testMap, map.extractRepeats(new ArrayList<>(Arrays.asList("a", "b", "c"))));
    }


    @Test
    @Tag("Normal")
    void hasAnagrams() {
        assertFalse(map.hasAnagrams(new ArrayList<>()));
        assertTrue(map.hasAnagrams(new ArrayList<>(Arrays.asList("рот", "свет", "тор"))));
        assertFalse(map.hasAnagrams(new ArrayList<>(Arrays.asList("рот", "свет", "код", "дверь"))));
    }


    @Test
    @Tag("Hard")
    void propagateHandshakes() {
        HashMap<String, HashSet<String>> testMap = new HashMap<>();
        HashMap<String, HashSet<String>> actualMap = new HashMap<>();

        testMap.put("Marat", new HashSet<>(Arrays.asList("Mikhail", "Sveta")));
        testMap.put("Sveta", new HashSet<>(Collections.singletonList("Mikhail")));
        actualMap.put("Marat", new HashSet<>(Collections.singletonList("Sveta")));
        actualMap.put("Sveta", new HashSet<>(Collections.singletonList("Mikhail")));
        assertEquals(testMap, map.propagateHandshakes(actualMap));


        testMap.put("Sveta", new HashSet<>(Arrays.asList("Marat", "Mikhail")));
        testMap.put("Mikhail", new HashSet<>(Arrays.asList("Marat", "Sveta")));
        actualMap.put("Marat", new HashSet<>(Arrays.asList("Mikhail", "Sveta")));
        actualMap.put("Sveta", new HashSet<>(Collections.singletonList("Marat")));
        actualMap.put("Mikhail", new HashSet<>(Collections.singletonList("Sveta")));
        assertEquals(testMap, map.propagateHandshakes(actualMap));
    }

  /*  @Test
    @Tag("Impossible")
    void bagPacking() {
        HashMap<String, Pair<Integer, Integer>> actualMap = new HashMap<>();

        actualMap.put("Кубок",new Pair<Integer, Integer>(500,2000));
        actualMap.put("Слиток",new Pair<Integer, Integer>(1000,5000));
        assertEquals(new HashSet<>(Collections.singletonList("Кубок")),map.bagPacking(actualMap,850));

    }
  */
}