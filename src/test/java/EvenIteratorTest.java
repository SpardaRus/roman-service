package test.java;

import ru.spardarus.roman.service.EvenIterator;

import java.util.List;
import java.util.NoSuchElementException;

public class EvenIteratorTest {

    public void test() {
        List<Integer> collection = List.of(2, 5, 6, 3, 3, 3);
        EvenIterator evenIterator = new EvenIterator(collection);

        assertEquals(2, evenIterator.next());
        assertEquals(6, evenIterator.next());
        try {
            evenIterator.next();
            System.out.println("fail");
        } catch (NoSuchElementException e) {
            System.out.println("success");
        }

    }

    public void assertEquals(int expected, int actual) {
        if (expected == actual) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
