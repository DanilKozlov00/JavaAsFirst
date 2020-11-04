package Lesson5;

import com.google.common.collect.Multimap;

import java.util.*;

public class TaskMap {

    /**
     * Пример
     * <p>
     * Для заданного списка покупок `shoppingList` посчитать его общую стоимость
     * на основе цен из `costs`. В случае неизвестной цены считать, что товар
     * игнорируется.
     */
    double shoppingListCost(ArrayList<String> shoppingList, HashMap<String, Double> costs) {
        double sum = 0.0;
        for (String item : shoppingList) {
            if (costs.get(item) != null) {
                sum += costs.get(item);
            }
        }
        return sum;
    }


    /**
     * Пример
     * <p>
     * Для набора "имя"-"номер телефона" `phoneBook` оставить только такие пары,
     * для которых телефон начинается с заданного кода страны `countryCode`
     */
    HashMap<String, String> filterByCountryCode(HashMap<String, String> phoneBook, String countryCode) {
        ArrayList<String> needRemove = new ArrayList<>();
        for (java.util.Map.Entry<String, String> pair : phoneBook.entrySet()) {
            if (!pair.getValue().startsWith(countryCode)) {
                needRemove.add(pair.getKey());
            }
        }
        for (String phone : needRemove) {
            phoneBook.remove(phone);
        }

        return phoneBook;
    }


    /**
     * Пример
     * <p>
     * Для заданного текста `text` убрать заданные слова-паразиты `fillerWords`
     * и вернуть отфильтрованный текст
     */
    ArrayList<String> removeFillerWords(ArrayList<String> text, String... fillerWords) {
        HashSet<String> setWords = new HashSet<>(Arrays.asList(fillerWords));
        text.removeIf(setWords::contains);
        return text;
    }


    /**
     * Пример
     * <p>
     * Для заданного текста `text` построить множество встречающихся в нем слов
     */
    HashSet<String> buildWordSet(ArrayList<String> text) {
        return new HashSet<>(text);
    }


    /**
     * Простая
     * <p>
     * По заданному ассоциативному массиву "студент"-"оценка за экзамен" построить
     * обратный массив "оценка за экзамен"-"список студентов с этой оценкой".
     * <p>
     * Например:
     * buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
     * -> mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат"))
     */
    HashMap<Integer, ArrayList<String>> buildGrades(HashMap<String, Integer> grades) {
        HashMap<Integer, ArrayList<String>> result = new HashMap<>();
        ArrayList<String> f = new ArrayList<>();
        ArrayList<String> d = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();

        for (java.util.Map.Entry<String, Integer> pair : grades.entrySet()) {
            if (pair.getValue() == 2) {
                f.add(pair.getKey());
            }
            if (pair.getValue() == 3) {
                d.add(pair.getKey());
            }
            if (pair.getValue() == 4) {
                b.add(pair.getKey());
            }
            if (pair.getValue() == 5) {
                a.add(pair.getKey());
            }
        }
        if (!f.isEmpty())
            result.put(2, f);
        if (!d.isEmpty())
            result.put(3, d);
        if (!b.isEmpty())
            result.put(4, b);
        if (!a.isEmpty())
            result.put(5, a);

        return result;

    }


    /**
     * Простая
     * <p>
     * Определить, входит ли ассоциативный массив a в ассоциативный массив b;
     * это выполняется, если все ключи из a содержатся в b с такими же значениями.
     * <p>
     * Например:
     * containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")) -> true
     * containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")) -> false
     */
    boolean containsIn(HashMap<String, String> a, HashMap<String, String> b) {
        for (java.util.Map.Entry<String, String> pair : a.entrySet()) {
            if (b.containsKey(pair.getKey()) && b.get(pair.getKey()).equals(pair.getValue())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Простая
     * <p>
     * Удалить из изменяемого ассоциативного массива все записи,
     * которые встречаются в заданном ассоциативном массиве.
     * Записи считать одинаковыми, если и ключи, и значения совпадают.
     * <p>
     * ВАЖНО: необходимо изменить переданный в качестве аргумента
     * изменяемый ассоциативный массив
     * <p>
     * Например:
     * subtractOf(a = mutableMapOf("a" to "z"), mapOf("a" to "z"))
     * -> a changes to mutableMapOf() aka becomes empty
     */
    HashMap<String, String> subtractOf(HashMap<String, String> a, HashMap<String, String> b) {


        for (java.util.Map.Entry<String, String> pair : b.entrySet()) {
            if (a.containsKey(pair.getKey()) && a.get(pair.getKey()).equals(pair.getValue())) {
                a.remove(pair.getKey());
            }
        }

        return a;
    }


    /**
     * Простая
     * <p>
     * Для двух списков людей найти людей, встречающихся в обоих списках.
     * В выходном списке не должно быть повторяюихся элементов,
     * т. е. whoAreInBoth(listOf("Марат", "Семён, "Марат"), listOf("Марат", "Марат")) == listOf("Марат")
     */
    ArrayList<String> whoAreInBoth(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> first = new HashSet<>(a);
        HashSet<String> second = new HashSet<>(b);

        if (first.size() > second.size()) {
            for (String people : first) {
                if (b.contains(people)) {
                    result.add(people);
                }
            }
        } else {
            for (String people : second) {
                if (a.contains(people)) {
                    result.add(people);
                }
            }
        }

        return result;
    }


    /**
     * Средняя
     * <p>
     * Объединить два ассоциативных массива `mapA` и `mapB` с парами
     * "имя"-"номер телефона" в итоговый ассоциативный массив, склеивая
     * значения для повторяющихся ключей через запятую.
     * В случае повторяющихся *ключей* значение из mapA должно быть
     * перед значением из mapB.
     * <p>
     * Повторяющиеся *значения* следует добавлять только один раз.
     * <p>
     * Например:
     * mergePhoneBooks(
     * mapOf("Emergency" to "112", "Police" to "02"),
     * mapOf("Emergency" to "911", "Police" to "02")
     * ) -> mapOf("Emergency" to "112, 911", "Police" to "02")
     */
    HashMap<String, String> mergePhoneBooks(HashMap<String, String> mapA, HashMap<String, String> mapB) {
        HashMap<String, String> result = new HashMap<>();

        if (mapA.size() > mapB.size()) {
            for (java.util.Map.Entry<String, String> pair : mapA.entrySet()) {
                if (mapB.get(pair.getKey()) != null && !mapB.get(pair.getKey()).equals(pair.getValue())) {
                    result.put(pair.getKey(), pair.getValue() + ", " + mapB.get(pair.getKey()));
                } else {
                    result.put(pair.getKey(), pair.getValue());
                }

            }
            for (java.util.Map.Entry<String, String> pair : mapB.entrySet()) {
                if (mapA.get(pair.getKey()) == null) {
                    result.put(pair.getKey(), pair.getValue());
                }
            }
        } else {
            for (java.util.Map.Entry<String, String> pair : mapB.entrySet()) {
                if (mapA.get(pair.getKey()) != null && !mapA.get(pair.getKey()).equals(pair.getValue())) {
                    result.put(pair.getKey(), mapA.get(pair.getKey()) + ", " + pair.getValue());
                } else {
                    result.put(pair.getKey(), pair.getValue());
                }

            }
            for (java.util.Map.Entry<String, String> pair : mapA.entrySet()) {
                if (mapB.get(pair.getKey()) == null) {
                    result.put(pair.getKey(), pair.getValue());
                }
            }
        }
        return result;
    }


    /**
     * Средняя
     * <p>
     * Для заданного списка пар "акция"-"стоимость" вернуть ассоциативный массив,
     * содержащий для каждой акции ее усредненную стоимость.
     * <p>
     * Например:
     * averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
     * -> mapOf("MSFT" to 150.0, "NFLX" to 40.0)
     * P.S - для java возникли проблемы при импорте класса Pair. Замена на Google Multimap
     */
    HashMap<String, Double> averageStockPrice(Multimap<String, Double> stockPrices) {
        HashMap<String, Double> result = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (Map.Entry<String, Double> pair : stockPrices.entries()) {
            count.merge(pair.getKey(), 1, Integer::sum);
        }


        for (Map.Entry<String, Double> pair : stockPrices.entries()) {
            result.merge(pair.getKey(), pair.getValue(), Double::sum);
        }

        for (Map.Entry<String, Integer> pair : count.entrySet()) {
            result.put(pair.getKey(), result.get(pair.getKey()) / pair.getValue());
        }

        return result;
    }


    /**
     * Средняя
     * <p>
     * Для заданного набора символов определить, можно ли составить из него
     * указанное слово (количество символов игнорируется, регистр одинаковый).
     * <p>
     * Например:
     * canBuildFrom(listOf('a', 'b', 'o'), "baobab") -> true
     */
    boolean canBuildFrom(ArrayList<Character> chars, String word) {
        char[] str = word.toCharArray();
        for (char i : str) {
            if (!chars.contains(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Средняя
     * <p>
     * Найти в заданном списке повторяющиеся элементы и вернуть
     * ассоциативный массив с информацией о числе повторений
     * для каждого повторяющегося элемента.
     * Если элемент встречается только один раз, включать его в результат
     * не следует.
     * <p>
     * Например:
     * extractRepeats(listOf("a", "b", "a")) -> mapOf("a" to 2)
     */
    HashMap<String, Integer> extractRepeats(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String symbol : list) {
            result.merge(symbol, 1, Integer::sum);
        }

        ArrayList<String> remove = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : result.entrySet()) {
            if (pair.getValue() == 1) {
                remove.add(pair.getKey());
            }
        }

        for (String symbol : remove) {
            result.remove(symbol);
        }

        return result;
    }


    /**
     * Средняя
     * <p>
     * Для заданного списка слов определить, содержит ли он анаграммы
     * (два слова являются анаграммами, если одно можно составить из второго)
     * <p>
     * Например:
     * hasAnagrams(listOf("тор", "свет", "рот")) -> true
     */
    boolean hasAnagrams(ArrayList<String> words) {

        for (String i : words) {
            ArrayList<Character> firstWord = new ArrayList<>();
            for (char sym : i.toCharArray()) {
                firstWord.add(sym);
            }
            Collections.sort(firstWord);
            for (String j : words) {
                ArrayList<Character> secondWord = new ArrayList<>();
                for (char sym : j.toCharArray()) {
                    secondWord.add(sym);
                }
                Collections.sort(secondWord);
                if (!i.equals(j) && firstWord.equals(secondWord)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Сложная
     * <p>
     * Для заданного ассоциативного массива знакомых через одно рукопожатие `friends`
     * необходимо построить его максимальное расширение по рукопожатиям, то есть,
     * для каждого человека найти всех людей, с которыми он знаком через любое
     * количество рукопожатий.
     * Считать, что все имена людей являются уникальными, а также что рукопожатия
     * являются направленными, то есть, если Марат знает Свету, то это не означает,
     * что Света знает Марата.
     * <p>
     * Например:
     * propagateHandshakes(
     * mapOf(
     * "Marat" to setOf("Mikhail", "Sveta"),
     * "Sveta" to setOf("Marat"),
     * "Mikhail" to setOf("Sveta")
     * )
     * ) -> mapOf(
     * "Marat" to setOf("Mikhail", "Sveta"),
     * "Sveta" to setOf("Marat", "Mikhail"),
     * "Mikhail" to setOf("Sveta", "Marat")
     * )
     */
    HashMap<String, HashSet<String>> propagateHandshakes(Map<String, HashSet<String>> friends) {
        HashMap<String, HashSet<String>> result = new HashMap<>(friends);

        for (Map.Entry<String, HashSet<String>> pair : friends.entrySet()) {
            for (String friend : pair.getValue()) {
                if (friends.get(friend) != null) {
                    HashSet<String> temp = new HashSet<>(friends.get(friend));
                    temp.addAll(result.get(pair.getKey()));
                    temp.remove(pair.getKey());
                    result.put(pair.getKey(), temp);
                }
            }
        }

        return result;
    }


    /**
     * Очень сложная
     * <p>
     * Входными данными является ассоциативный массив
     * "название сокровища"-"пара (вес сокровища, цена сокровища)"
     * и вместимость вашего рюкзака.
     * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
     * которые вы можете унести в рюкзаке.
     * <p>
     * Перед решением этой задачи лучше прочитать статью Википедии "Динамическое программирование".
     * <p>
     * Например:
     * bagPacking(
     * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
     * 850
     * ) -> setOf("Кубок")
     * bagPacking(
     * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
     * 450
     * ) -> emptySet()
     */
   /* HashSet<String> bagPacking(HashMap<String, Pair<Integer, Integer>> treasures, Integer capacity) {
       //TODO
    }
    */
}


