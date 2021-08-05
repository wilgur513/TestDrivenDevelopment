package highlight;

import org.junit.Test;

import static highlight.HighlightSplitter.splitter;
import static org.assertj.core.api.Assertions.assertThat;

public class HighlightSplitterTest {
    private static final String TARGET = "note";

    @Test
    public void splitHasOnlyOneTarget() {
        HighlightSplitter splitter = splitter("note", TARGET);
        splitter.next();

        assertThat(splitter.hasNext()).isFalse();
        assertThat(splitter.prevTargetString()).isEqualTo("");
        assertThat(splitter.postTargetString()).isEqualTo("");
    }

    @Test(expected = NotCallNextException.class)
    public void callPrevTargetStringAfterNext() {
        HighlightSplitter splitter = splitter("note note", TARGET);
        splitter.prevTargetString();
    }

    @Test(expected = NotCallNextException.class)
    public void callIsOnlyTargetWordAfterNext() {
        HighlightSplitter splitter = splitter("note note", TARGET);
        splitter.isOnlyTargetWord();
    }

    @Test(expected = CurrentIsNotLastTargetException.class)
    public void throwCurrentIsNotLastTargetException() {
         HighlightSplitter splitter = splitter("note note", TARGET);
         splitter.postTargetString();
    }

    @Test(expected = CurrentIsLastTargetException.class)
    public void throwCurrentIsLastTargetException() {
        HighlightSplitter splitter = splitter("note", TARGET);
        splitter.next();
        splitter.next();
    }

    @Test
    public void splitHasMoreTarget() {
        HighlightSplitter splitter = splitter("note note key note a b c", TARGET);

        splitter.next();
        assertThat(splitter.hasNext()).isTrue();
        assertThat(splitter.prevTargetString()).isEqualTo("");

        splitter.next();
        assertThat(splitter.hasNext()).isTrue();
        assertThat(splitter.prevTargetString()).isEqualTo(" ");

        splitter.next();
        assertThat(splitter.hasNext()).isFalse();
        assertThat(splitter.prevTargetString()).isEqualTo(" key ");
        assertThat(splitter.postTargetString()).isEqualTo(" a b c");
    }

    @Test
    public void splitHasTargetWithPrevCharacter() {
        HighlightSplitter splitter = splitter("note anote keynote", TARGET);

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo("");
        assertThat(splitter.isOnlyTargetWord()).isTrue();
        assertThat(splitter.hasNext()).isTrue();

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo(" a");
        assertThat(splitter.isOnlyTargetWord()).isFalse();
        assertThat(splitter.hasNext()).isTrue();

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo(" key");
        assertThat(splitter.isOnlyTargetWord()).isFalse();
        assertThat(splitter.hasNext()).isFalse();
    }

    @Test
    public void splitHasTargetWithPrevOrPostCharacter() {
        HighlightSplitter splitter = splitter("anote notekey note", TARGET);

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo("a");
        assertThat(splitter.isOnlyTargetWord()).isFalse();
        assertThat(splitter.hasNext()).isTrue();

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo(" ");
        assertThat(splitter.isOnlyTargetWord()).isFalse();
        assertThat(splitter.hasNext()).isTrue();

        splitter.next();
        assertThat(splitter.prevTargetString()).isEqualTo("key ");
        assertThat(splitter.isOnlyTargetWord()).isTrue();
        assertThat(splitter.postTargetString()).isEqualTo("");
        assertThat(splitter.hasNext()).isFalse();
    }
}
