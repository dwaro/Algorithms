// Goal: simple, remove the spaces from the string, then return the resultant string.

class Replacer {
    static String noSpace(final String x) {
        String[] split = x.split(" ");
        String n = "";
        for (String subs: split) {
            n+=subs;
        }
        return n;
    }
}

/* Tests

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test public void testSomething() {
        assertEquals("8j8mBliB8gimjB8B8jlB", Replacer.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", Replacer.noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr", Replacer.noSpace("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8", Replacer.noSpace("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam", Replacer.noSpace("8j aam"));
    }
}

*/
