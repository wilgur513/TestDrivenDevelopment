package highlight;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HighlightSplitterTest {
    private static final String TARGET = "note";

    @Test
    public void splitHasOnlyOneNote() {
        HighlightSplitter splitter = HighlightSplitter.splitter("note", TARGET);

        assertThat(splitter.hasNext()).isTrue();
        assertThat(splitter.prevTargetString()).isEqualTo("");

        splitter.next();
        assertThat(splitter.hasNext()).isFalse();
        assertThat(splitter.postTargetString()).isEqualTo("");
    }

    @Test(expected = CurrentIsNotLastTargetException.class)
    public void throwCurrentIsNotLastTargetException() {
         HighlightSplitter splitter = HighlightSplitter.splitter("note note", TARGET);
         splitter.postTargetString();
    }
}
