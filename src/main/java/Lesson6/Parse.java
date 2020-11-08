package Lesson6;

import Lesson2.Logical;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Parse {

    Logical logical = new Logical();

    /**
     * Пример
     * <p>
     * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
     * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
     */
    int timeStrToSeconds(String str) {

        String[] parts = str.split(":");
        int result = 0;
        for (String part : parts) {
            int number = Integer.parseInt(part);
            result = result * 60 + number;
        }
        return result;
    }


    /**
     * Пример
     * <p>
     * Дано число n от 0 до 99.
     * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
     */
    String twoDigitStr(int n) {
        if (n < 10) {
            return ("0" + n);
        } else return String.valueOf(n);
    }


    /**
     * Пример
     * <p>
     * Дано seconds -- время в секундах, прошедшее с начала дня.
     * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
     */
    String timeSecondsToStr(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds % 3600) / 60;
        int second = seconds % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }


    /**
     * Средняя
     * <p>
     * Дата представлена строкой вида "15 июля 2016".
     * Перевести её в цифровой формат "15.07.2016".
     * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
     * При неверном формате входной строки вернуть пустую строку.
     * <p>
     * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
     * входными данными.
     */
    String dateStrToDigit(String str) {
        String[] parts = str.split(" ");
        int day;
        String mouth;
        int year;
        if (parts.length != 3) {
            return "";
        }
        day = Integer.parseInt(parts[0]);
        mouth = parts[1];
        year = Integer.parseInt(parts[2]);
        HashMap<String, Integer> mouthToNumber = new HashMap<>();
        mouthToNumber.put("января", 1);
        mouthToNumber.put("февраля", 2);
        mouthToNumber.put("марта", 3);
        mouthToNumber.put("апреля", 4);
        mouthToNumber.put("мая", 5);
        mouthToNumber.put("июня", 6);
        mouthToNumber.put("июля", 7);
        mouthToNumber.put("августа", 8);
        mouthToNumber.put("сентября", 9);
        mouthToNumber.put("октября", 10);
        mouthToNumber.put("ноября", 11);
        mouthToNumber.put("декабря", 12);
        if (mouthToNumber.get(parts[1].toLowerCase()) == null) {
            return "";
        }
        if (year <= 0) {
            return "";
        }
        if (day > 0 && day < logical.daysInMonth(mouthToNumber.get(mouth), year)) {
            String result;
            if (day < 10) {
                result = "0" + day + ".";
            } else result = day + ".";
            if (mouthToNumber.get(mouth) < 10) {
                result += "0" + mouthToNumber.get(mouth) + ".";
            } else result += mouthToNumber.get(mouth) + ".";
            return result + year;
        } else return "";
    }


    /**
     * Средняя
     * <p>
     * Дата представлена строкой вида "15.07.2016".
     * Перевести её в строковый формат вида "15 июля 2016".
     * При неверном формате входной строки вернуть пустую строку
     * <p>
     * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
     * входными данными.
     */
    String dateDigitToStr(String digital) {
        String[] parts = digital.split("\\.");
        int day;
        int mouth;
        int year;
        if (parts.length != 3) {
            return "";
        }
        try {
            day = Integer.parseInt(parts[0]);
            mouth = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return "";
        }
        HashMap<Integer, String> mouthToNumber = new HashMap<>();
        mouthToNumber.put(1, "января");
        mouthToNumber.put(2, "февраля");
        mouthToNumber.put(3, "марта");
        mouthToNumber.put(4, "апреля");
        mouthToNumber.put(5, "мая");
        mouthToNumber.put(6, "июня");
        mouthToNumber.put(7, "июля");
        mouthToNumber.put(8, "августа");
        mouthToNumber.put(9, "сентября");
        mouthToNumber.put(10, "октября");
        mouthToNumber.put(11, "ноября");
        mouthToNumber.put(12, "декабря");
        if (mouthToNumber.get(mouth) == null) {
            return "";
        }
        if (year <= 0) {
            return "";
        }
        if (day > 0 && day < logical.daysInMonth(mouth, year)) {
            return day + " " + mouthToNumber.get(mouth) + " " + year;
        } else return "";
    }


    /**
     * Средняя
     * <p>
     * Номер телефона задан строкой вида "+7 (921) 123-45-67".
     * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
     * Может присутствовать неограниченное количество пробелов и чёрточек,
     * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
     * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
     * "+79211234567" или "123456789" для приведённых примеров.
     * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
     * При неверном формате вернуть пустую строку.
     * <p>
     * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
     */
    String flattenPhoneNumber(String phone) {
        boolean plus = phone.charAt(0) == '+';
        phone = phone.replaceAll(" ", "");
        phone = phone.replaceAll("-", "");
        phone = phone.replaceAll("\\(", "");
        phone = phone.replaceAll("\\)", "");
        phone = phone.replaceAll("\\+", "");

        if (phone.matches("\\d+")) {
            if (plus) {
                return "+" + phone;
            } else return phone;
        } else return "";
    }


    /**
     * Средняя
     * <p>
     * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
     * "706 - % 717 % 703".
     * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
     * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
     * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
     * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
     */
    int bestLongJump(String jumps) {
        jumps = jumps.replaceAll("-", ".");
        jumps = jumps.replaceAll("%", ".");
        jumps = jumps.replaceAll("\\. ", "");
        jumps = jumps.replaceAll("\\.", "");
        if (jumps.replaceAll(" ", "").matches("\\d+")) {
            ArrayList<String> numbers = new ArrayList<>(Arrays.asList(jumps.split(" ")));
            return Integer.parseInt(Collections.max(numbers));
        } else return -1;
    }


    /**
     * Сложная
     * <p>
     * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
     * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
     * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
     * Высота и соответствующие ей попытки разделяются пробелом.
     * Прочитать строку и вернуть максимальную взятую высоту (234 в примере).
     * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
     * вернуть -1.
     */
    int bestHighJump(String jumps) {
        jumps = jumps.replaceAll("-", ".");
        jumps = jumps.replaceAll("%", ".");
        jumps = jumps.replaceAll("\\. ", "");
        jumps = jumps.replaceAll("\\.", "");
        if (!jumps.equals(jumps.replaceAll("\\+", ""))) {
            jumps = jumps.replaceAll("\\+", "");
            if (jumps.replaceAll(" ", "").matches("\\d+")) {
                ArrayList<String> numbers = new ArrayList<>(Arrays.asList(jumps.split(" ")));
                return Integer.parseInt(Collections.max(numbers));
            } else return -1;
        } else return -1;
    }


    /**
     * Сложная
     * <p>
     * В строке представлено выражение вида "2 + 31 - 40 + 13",
     * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
     * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
     * Вернуть значение выражения (6 для примера).
     * Про нарушении формата входной строки бросить исключение IllegalArgumentException
     */
    int plusMinus(String expression) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(expression.split(" ")));

        try {
            for (int i = 0; i < numbers.size(); i = i + 2) {
                if (!numbers.get(i).matches("\\d+")) {
                    throw new IllegalArgumentException();
                }
            }
            for (int i = 1; i < numbers.size(); i = i + 2) {
                if (!numbers.get(i).matches("\\+")) {
                    if (!numbers.get(i).matches("-")) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }

        int result = Integer.parseInt(numbers.get(0));
        for (int i = 1; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals("-")) {
                result -= Integer.parseInt(numbers.get(i + 1));
            }
            if (numbers.get(i).equals("+")) {
                result += Integer.parseInt(numbers.get(i + 1));
            }
        }
        return result;
    }


    /**
     * Сложная
     * <p>
     * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
     * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
     * Слова, отличающиеся только регистром, считать совпадающими.
     * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
     * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
     */
    int firstDuplicateIndex(String str) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(str.toLowerCase().split(" ")));
        for (int i = 0; i < words.size() - 1; i++) {
            if (words.get(i).equals(words.get(i + 1))) {
                return str.toLowerCase().indexOf(words.get(i) + " " + words.get(i));
            }
        }
        return -1;
    }

    /**
     * Сложная
     * <p>
     * Строка содержит названия товаров и цены на них в формате вида
     * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
     * То есть, название товара отделено от цены пробелом,
     * а цена отделена от названия следующего товара точкой с запятой и пробелом.
     * Вернуть название самого дорогого товара в списке (в примере это Курица),
     * или пустую строку при нарушении формата строки.
     * Все цены должны быть больше либо равны нуля.
     */
    String mostExpensive(String description) {

        ArrayList<String> products = new ArrayList<>(Arrays.asList(description.split("; ")));
        Multimap<Double, String> map = ArrayListMultimap.create();
        if (products.size() > 2) {
            for (String s : products) {
                String[] product = s.split(" ");
                map.put(Double.parseDouble(product[1].replace(";", "")), product[0]);
            }
            return map.get(Collections.max(map.keySet())).toString().replace("[", "").replace("]", "");
        }
        return description.replaceAll(" \\d+.\\d", "");
    }

    /**
     * Сложная
     *
     * Перевести число roman, заданное в римской системе счисления,
     * в десятичную систему и вернуть как результат.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: XXIII = 23, XLIV = 44, C = 100
     *
     * Вернуть -1, если roman не является корректным римским числом
     */
    //int fromRoman(String roman) = TODO


    /**
     * Очень сложная
     *
     * Имеется специальное устройство, представляющее собой
     * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
     * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
     * Каждая команда кодируется одним специальным символом:
     *	> - сдвиг датчика вправо на 1 ячейку;
     *  < - сдвиг датчика влево на 1 ячейку;
     *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
     *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
     *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
     *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
     *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
     *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
     *      (комбинация [] имитирует цикл)
     *  пробел - пустая команда
     *
     * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
     *
     * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
     * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
     * значении под датчиком равном 0) и пробелы.
     *
     * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
     * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
     *
     * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
     * То же исключение формируется, если у символов [ ] не оказывается пары.
     * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
     * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
     * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
     * IllegalArgumentException.
     * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
     *
     */
    //ArrayList<Integer> computeDeviceCells(int cells,String commands,int limit) = TODO

}
