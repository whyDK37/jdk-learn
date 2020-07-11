package guava;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

class RangeTest {
    @Test
    void range() {
        final Range<Integer> closed = Range.closed(0, 12);
        System.out.println("closed 1-12");
        sout(closed);

        final Range<Integer> open = Range.open(0, 12);
        System.out.println("open 1-12");
        sout(open);

    }

    private void sout(Range<Integer> closed) {
        System.out.println(closed.contains(-1));
        System.out.println(closed.contains(0));
        System.out.println(closed.contains(1));
        System.out.println(closed.contains(11));
        System.out.println(closed.contains(12));
        System.out.println(closed.contains(13));
    }
}
