package test.java;

import ru.spardarus.roman.service.RepeatingCharactersService;

public class RepeatingCharactersServiceTest {

    public void test() {
        test(3, "dvdf");
        test(7, "dvabcdfe");
        test(0, "");
        test(2, "aab");
        test(3, "abcabcbb");
        test(3, "abcabcbb");
        test(1, "bbbbb");
        test(3, "pwwkew");
    }

    private void test(int expected, String string) {
        RepeatingCharactersService service = new RepeatingCharactersService();
        System.out.print(string + " - ");
        assertEquals(expected, service.lengthOfLongestSubstring(string));
    }

    public void assertEquals(int expected, int actual) {
        String test_is_ = "is ";
        String result = "fail";
        if (expected == actual) {
            result = "success";
        }
        System.out.println(test_is_ + result + ". expected: " + expected + ", actual: " + actual);
    }
}
