package ru.spardarus.roman.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RomanService {

    private static final Map<Integer, String> ROMAN_MAP = Map.of(
            1, "I",
            5, "V",
            10, "X",
            50, "L",
            100, "C",
            500, "D",
            1000, "M"
    );

    public String intToRoman(int num) {
        List<Integer> numbers = getNumbers(num);
        return numbers.stream()
                .map(this::convert)
                .reduce("", (subtotal, element) -> subtotal + element);
    }

    private String convert(int num) {
        List<Integer> keys = ROMAN_MAP.keySet().stream().sorted().toList();
        StringBuilder result = new StringBuilder();

        /*
                Для чисел больше 1000
         */
        while (num > keys.get(6)) {
            result.append(ROMAN_MAP.get(keys.get(6)));
            num = num - keys.get(6);
        }

        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            if (key == num) {
                result.append(ROMAN_MAP.get(key));
                break;
            } else if (key > num) {
                int multiplier = getMultiplier(num);
                if (key - num == multiplier) {
                    result.append(ROMAN_MAP.get(key - num))
                            .append(convert(key));
                } else {
                    int keyPred = i > 0 ? keys.get(i - 1) : key;
                    result.append(ROMAN_MAP.get(keyPred))
                            .append(convert(num - keyPred));
                }
                break;
            }
        }

        return result.toString();
    }

    private static List<Integer> getNumbers(int num) {
        int n = num;
        int m = 1;
        List<Integer> numbers = new ArrayList<>();
        while (n > 0) {
            numbers.add(n % 10 * m);
            n = n / 10;
            m = m * 10;
        }
        return numbers.stream()
                .filter(i -> i != 0)
                .sorted((f1, f2) -> Integer.compare(f2, f1))
                .toList();
    }

    private static int getMultiplier(int num) {
        int multiplier = 1;
        while (num > 0) {
            num = num / 10;
            multiplier = multiplier * 10;
        }
        return multiplier / 10;
    }

    //    private void solution1(int num, List<String> result, List<Integer> keys) {
//        for (int i = 0; i < keys.size(); i++) {
//            int key = keys.get(i);
//            Integer firstKey = keys.get(0);
//            String I = ROMAN_MAP.get(firstKey);
//
//            if (key == num + 1) {
//                result.add(I + ROMAN_MAP.get(key));
//                break;
//            } else if (key == num) {
//                result.add(ROMAN_MAP.get(key));
//                break;
//            } else if (key > num) {
//                Integer keyPred = keys.get(i - 1);
//                int count = num;
//                if (keyPred > num) {
//                    while (count != 0) {
//                        result.add(ROMAN_MAP.get(keyPred));
//                        count--;
//                    }
//                } else {
//                    count = num - keyPred;
//                    result.add(ROMAN_MAP.get(keyPred));
//                    if (count <= 3) {
//                        while (count != 0) {
//                            result.add(I);
//                            count--;
//                        }
//                    } else {
//                        solution1(count, result, keys);
//                    }
//
//                }
//                break;
//            }
//        }
//    }
}
