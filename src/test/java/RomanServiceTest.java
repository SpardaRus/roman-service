package test.java;

import ru.spardarus.roman.service.RomanService;

public class RomanServiceTest {
    private static int total = 0;
    private static int success = 0;
    private static int fail = 0;

    public static void baseTest() {
        test("I", 1);
        test("II", 2);
        test("III", 3);
        test("IV", 4);
        test("V", 5);
        test("VI", 6);
        test("VII", 7);
        test("VIII", 8);
        test("IX", 9);
        test("X", 10);
        test("XI", 11);
        test("XII", 12);
        test("XIII", 13);
        test("XIV", 14);
        test("XV", 15);
        test("XVI", 16);
        test("XVII", 17);
        test("XVIII", 18);
        test("XIX", 19);
        test("XX", 20);

        test("XL", 40);
        test("XLI", 41);
        test("LVIII", 58);
        test("LXVI", 66);
        test("XC", 90);
        test("XCIX", 99);
        test("CCC", 300);
        test("DC", 600);
        test("DCLXVI", 666);
        test("CMXCIV", 994);
        test("MCMXCIV", 1994);
        test("MM", 2000);
        test("MMCMXCIV", 2994);
        test("MMM", 3000);
        test("MMMCMXCIX", 3999);

        System.out.println("***");
        System.out.println("Total: " + total + ", Success: " + success + ", Fail: " + fail);
    }

    private static void test(String expected, int num) {
        total++;
        RomanService romanService = new RomanService();
        String actualSolution = romanService.intToRoman(num);

        assertEquals(expected, actualSolution, num);
    }

    private static void assertEquals(String expected, String actual, int num) {
        String logPrefix = "Test for: " + num + " is ";
        String log = "fail. ";
        String logPostfix = "expected: " + expected + ", actual: " + actual;
        if (actual.equals(expected)) {
            success++;
            log = "success. ";
            System.out.println(logPrefix + log + logPostfix);
        } else {
            fail++;
            System.out.println(logPrefix + log + logPostfix);
        }
    }
}
