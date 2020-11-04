package Lesson4;

import java.util.*;

import Lesson1.Task1;

import static java.lang.StrictMath.sqrt;

public class TaskList {

    Task1 task1 = new Task1();

    /**
     * Пример
     * <p>
     * Найти все корни уравнения x^2 = y
     */
    LinkedList<Double> sqRoots(double y) {
        LinkedList<Double> result = new LinkedList<>();
        if (y < 0) return result;
        else if (y == 0.0) {
            result.add(0.0);
            return result;
        } else {
            double root = sqrt(y);
            result.add(-root);
            result.add(root);
            return result;
        }
    }


    /**
     * Пример
     * <p>
     * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
     * Вернуть список корней (пустой, если корней нет)
     */
    LinkedList<Double> biRoots(double a, double b, double c) {
        if (a == 0.0) {
            if (b == 0.0) return new LinkedList<>();
            else return sqRoots(-c / b);
        }
        double d = task1.discriminant(a, b, c);
        if (d < 0.0) return new LinkedList<>();
        if (d == 0.0) return sqRoots(-b / (2 * a));
        double y1 = (-b + sqrt(d)) / (2 * a);
        double y2 = (-b - sqrt(d)) / (2 * a);
        LinkedList<Double> result = new LinkedList<>();
        result.addAll(sqRoots(y1));
        result.addAll(sqRoots(y2));
        return result;
    }


    /**
     * Пример
     * <p>
     * Выделить в список отрицательные элементы из заданного списка
     */
    LinkedList<Integer> negativeList(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int element : list) {
            if (element < 0) {
                result.add(element);
            }
        }
        return result;
    }


    /**
     * Пример
     * <p>
     * Изменить знак для всех положительных элементов списка
     */
    LinkedList<Integer> invertPositives(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                list.set(i, list.get(i) * -1);
            }
        }
        return list;
    }


    /**
     * Пример
     * <p>
     * Из имеющегося списка целых чисел, сформировать список их квадратов
     */
    LinkedList<Integer> squares(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * list.get(i));
        }
        return list;
    }


    /**
     * Пример
     * <p>
     * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
     */
    ArrayList<Integer> squares(int... array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i * i);
        }
        return arrayList;
    }


    /**
     * Пример
     * <p>
     * По заданной строке str определить, является ли она палиндромом.
     * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
     * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
     * Пробелы не следует принимать во внимание при сравнении символов, например, строка
     * "А роза упала на лапу Азора" является палиндромом.
     */
    boolean isPalindrome(String str) {
        String lowerCase = str.toLowerCase().replaceAll(" ", "");
        for (int i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) != lowerCase.charAt(lowerCase.length() - i - 1)) return false;
        }
        return true;
    }


    /**
     * Пример
     * <p>
     * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
     * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
     */
    String buildSumExample(LinkedList<Integer> list) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i : list) {
            result.append(i).append(" + ");
            sum += i;
        }
        result.replace(result.length() - 2, result.length() - 1, "= " + sum);
        return result.toString();
    }


    /**
     * Простая
     * <p>
     * Найти модуль заданного вектора, представленного в виде списка v,
     * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
     * Модуль пустого вектора считать равным 0.0.
     */
    double abs(Vector<Double> vector) {
        int sum = 0;
        if (!vector.isEmpty()) {
            for (double element : vector) {
                sum += task1.sqrDouble(element);
            }
        }
        return sqrt(sum);
    }


    /**
     * Простая
     * <p>
     * Рассчитать среднее арифметическое элементов списка TaskList. Вернуть 0.0, если список пуст
     */
    double mean(LinkedList<Double> list) {
        double sum = 0.0;
        if (!list.isEmpty()) {
            for (double element : list) {
                sum += element;
            }
            return sum / list.size();
        } else {
            return 0.0;
        }
    }


    /**
     * Средняя
     * <p>
     * Центрировать заданный список TaskList, уменьшив каждый элемент на среднее арифметическое всех элементов.
     * Если список пуст, не делать ничего. Вернуть изменённый список.
     * <p>
     * Обратите внимание, что данная функция должна изменять содержание списка TaskList, а не его копии.
     */
    LinkedList<Double> center(LinkedList<Double> list) {
        double sum = 0.0;
        if (!list.isEmpty()) {
            for (double element : list) {
                sum += element;
            }
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - sum / list.size());
            }
        }
        return list;
    }


    //ArrrayList


    /**
     * Средняя
     * <p>
     * Найти скалярное произведение двух векторов равной размерности,
     * представленные в виде списков a и b. Скалярное произведение считать по формуле:
     * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
     */
    int times(ArrayList<Integer> a, ArrayList<Integer> b) {
        int c = 0;
        if (a.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < a.size(); i++) {
                c += a.get(i) * b.get(i);
            }
            return c;
        }
    }


    /**
     * Средняя
     * <p>
     * Рассчитать значение многочлена при заданном x:
     * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
     * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
     * Значение пустого многочлена равно 0 при любом x.
     */
    int polynom(ArrayList<Integer> p, int x) {
        int poly = 0;
        if (p.isEmpty()) {
            return 0;
        } else if (p.size() == 1) {
            return p.get(0);
        } else {
            for (int i = 0; i < p.size(); i++) {
                poly += p.get(i) * Math.pow(x, i);
            }
            return poly;
        }
    }


    /**
     * Средняя
     * <p>
     * В заданном списке TaskList каждый элемент, кроме первого, заменить
     * суммой данного элемента и всех предыдущих.
     * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
     * Пустой список не следует изменять. Вернуть изменённый список.
     * <p>
     * Обратите внимание, что данная функция должна изменять содержание списка TaskList, а не его копии.
     */
    ArrayList<Integer> accumulate(ArrayList<Integer> list) {
        int sum;
        if (!list.isEmpty()) {
            sum = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                sum += list.get(i);
                list.set(i, sum);
            }
        }
        return list;
    }


    /**
     * Средняя
     * <p>
     * Разложить заданное натуральное число n > 1 на простые множители.
     * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
     * Множители в списке должны располагаться по возрастанию.
     */
    ArrayList<Integer> factorize(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int del = 2;
        int temp = n;
        for (int i = del; i <= n; i++) {
            if (temp % del == 0) {
                result.add(del);
                temp /= del;
                del = 2;
            }
            del++;
        }
        return result;
    }


    /**
     * Сложная
     * <p>
     * Разложить заданное натуральное число n > 1 на простые множители.
     * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
     * Множители в результирующей строке должны располагаться по возрастанию.
     */
    String factorizeToString(int n) {
        ArrayList<Integer> result = factorize(n);
        StringBuilder str = new StringBuilder();
        for (int integer : result) {
            str.append(integer).append("*");
        }
        str.replace(str.length() - 1, str.length(), "");
        return str.toString();
    }


    /**
     * Средняя
     * <p>
     * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
     * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
     * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
     */
    ArrayList<Integer> convert(int n, int base) {
        ArrayList<Integer> result = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            result.add(temp % base);
            temp /= base;
        }
        Collections.reverse(result);
        return result;
    }


    /**
     * Сложная
     * <p>
     * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
     * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
     * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
     * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
     * <p>
     * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
     * (например, n.toString(base) и подобные), запрещается.
     */
    String convertToString(int n, int base) {
        StringBuilder str = new StringBuilder();
        ArrayList<Integer> result = convert(n, base);
        StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        for (int integer : result) {
            if (integer >= 10) {
                str.append(alphabet.charAt(integer - 10));
            } else {
                str.append(integer);
            }
        }
        return str.toString();
    }


    /**
     * Средняя
     * <p>
     * Перевести число, представленное списком цифр digits от старшей к младшей,
     * из системы счисления с основанием base в десятичную.
     * Например: digits = (1, 3, 12), base = 14 -> 250
     */
    int decimal(ArrayList<Integer> digits, int base) {
        int digit = 0;
        for (int i = 0; i < digits.size(); i++) {
            digit += digits.get(i) * Math.pow(base, (digits.size() - 1 - i));
        }
        return digit;
    }


    /**
     * Сложная
     * <p>
     * Перевести число, представленное цифровой строкой str,
     * из системы счисления с основанием base в десятичную.
     * Цифры более 9 представляются латинскими строчными буквами:
     * 10 -> a, 11 -> b, 12 -> c и так далее.
     * Например: str = "13c", base = 14 -> 250
     * <p>
     * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
     * (например, str.toInt(base)), запрещается.
     */
    int decimalFromString(String str, int base) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                result.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            } else {
                for (int j = 0; j < alphabet.length(); j++) {
                    if (str.charAt(i) == alphabet.charAt(j)) {
                        result.add(j + 10);
                    }
                }
            }
        }
        return decimal(result, base);
    }


    /**
     * Сложная
     * <p>
     * Перевести натуральное число n > 0 в римскую систему.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: 23 = XXIII, 44 = XLIV, 100 = C
     */
    String roman(int n) {
        ArrayList<Integer> romanDigitList = new ArrayList<>(Arrays.asList(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000));
        ArrayList<String> romanAlpList = new ArrayList<>(Arrays.asList("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"));
        StringBuilder str = new StringBuilder();
        int temp = n;
        while (temp != 0) {
            if (temp >= 1000) {
                str.append(romanAlpList.get(romanAlpList.size() - 1));
                temp -= romanDigitList.get(romanDigitList.size() - 1);
            } else {
                for (int j = 0; j < romanDigitList.size(); j++) {
                    if (temp <= romanDigitList.get(j)) {
                        if (temp == romanDigitList.get(j)) {
                            str.append(romanAlpList.get(j));
                            temp -= romanDigitList.get(j);
                        } else {
                            str.append(romanAlpList.get(j - 1));
                            temp -= romanDigitList.get(j - 1);
                        }
                        break;
                    }
                }
            }
        }
        return str.toString();
    }


    /**
     * Очень сложная
     * <p>
     * Записать заданное натуральное число 1..999999 прописью по-русски.
     * Например, 375 = "триста семьдесят пять",
     * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
     */
    String russian(int n) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
        map.put(13, "тринадцать");
        map.put(14, "четырнадцать");
        map.put(15, "пятнадцать");
        map.put(16, "шестнадцать");
        map.put(17, "семнадцать");
        map.put(18, "восемнадцать");
        map.put(19, "девятнадцать");
        map.put(20, "двадцать");
        map.put(30, "тридцать");
        map.put(40, "сорок");
        map.put(50, "пятьдесят");
        map.put(60, "шестьдесят");
        map.put(70, "семьдесят");
        map.put(80, "восемьдесят");
        map.put(90, "девяносто");
        map.put(100, "сто");
        map.put(200, "двести");
        map.put(300, "триста");
        map.put(400, "четыреста");
        map.put(500, "пятьсот");
        map.put(600, "шестьсот");
        map.put(700, "семьсот");
        map.put(800, "восемьсот");
        map.put(900, "девятьсот");

        ArrayList<String> resultPart2 = new ArrayList<>();
        ArrayList<String> resultPart1 = new ArrayList<>();
        int nPart1 = n / 1000;
        int nPart2 = n % 1000;
        int i = 10;
        while (nPart2 > 0) {
            if (nPart2 % i == 0) {
                i *= 10;
                continue;
            }
            if ((i == 10) && (nPart2 % 100 >= 11 && nPart2 % 100 <= 19)) i = 100;
            resultPart2.add(0, map.get(nPart2 % i));
            nPart2 -= nPart2 % i;
        }
        if (nPart1 > 0) {
            i = 10;
            while (nPart1 > 0) {
                if (nPart1 % i == 0) {
                    i *= 10;
                    continue;
                }
                if ((i == 10) && (nPart1 % 100 >= 11 && nPart1 % 100 <= 19)) i = 100;
                resultPart1.add(0, map.get(nPart1 % i));
                nPart1 -= nPart1 % i;
            }
            nPart1 = n / 1000;

            if ((nPart1 % 10 == 1) && (nPart1 % 100 != 11)) {
                resultPart1.remove(resultPart1.size() - 1);
                resultPart1.add("одна тысяча");
            } else if ((nPart1 % 10 == 2) && (nPart1 % 100 != 12)) {
                resultPart1.remove(resultPart1.size() - 1);
                resultPart1.add("две тысячи");
            } else if ((nPart1 % 10 == 3) && (nPart1 % 100 != 13)) {
                resultPart1.remove(resultPart1.size() - 1);
                resultPart1.add("три тысячи");
            } else if ((nPart1 % 10 == 4) && (nPart1 % 100 != 14)) {
                resultPart1.remove(resultPart1.size() - 1);
                resultPart1.add("четыре тысячи");
            } else {
                resultPart1.add("тысяч");
            }
        }
        resultPart1.addAll(resultPart2);
        return String.join(" ", resultPart1);
    }
}