package highlight;

import org.junit.Test;

import static highlight.HighlightSplitter.splitter;
import static org.assertj.core.api.Assertions.assertThat;

public class HighlightSplitterTest {
    private static final String TARGET = "note";

    @Test
    public void splitHasOnlyOneTarget() {

        assertThat(splitter.hasNext()).isTrue();
        assertThat(splitter.prevTargetString()).isEqualTo("");

        HighlightSplitter splitter = splitter("note", TARGET);
        splitter.next();
        assertThat(splitter.hasNext()).isFalse();
        assertThat(splitter.postTargetString()).isEqualTo("");
    }

    @Test(expected = CurrentIsNotLastTargetException.class)
    public void throwCurrentIsNotLastTargetException() {
         HighlightSplitter splitter = splitter("note note", TARGET);
         splitter.postTargetString();
    }

    @Test
    public void splitHasMoreTarget() {
        String[] expectedPrevTargetString = {"", " ", " key "};
        String expectedPostTargetString = " a b c";
        String str = "note note key note a b c";
        HighlightSplitter splitter = splitter("note note key note a b c", TARGET);


        for(int i = 0; i < 3; i++) {
            assertThat(splitter.hasNext()).isTrue();
            assertThat(splitter.prevTargetString()).isEqualTo(expectedPrevTargetString[i]);
            splitter.next();
        }

        HighlightSplitter splitter = splitter("anote notekey note", TARGET);
        assertThat(splitter.hasNext()).isFalse();
        assertThat(splitter.postTargetString()).isEqualTo(expectedPostTargetString);
    }
}
