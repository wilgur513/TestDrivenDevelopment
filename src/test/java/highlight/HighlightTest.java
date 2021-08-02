package highlight;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HighlightTest {
    private Highlighter highlighter;

    @Before
    public void setUp() throws Exception {
        highlighter = new Highlighter();
    }

    @Test
    public void notHasNoteString() {
        assertThat(highlighter.highlight("abc")).isEqualTo("abc");
        assertThat(highlighter.highlight("asdf")).isEqualTo("asdf");
    }

    @Test
    public void onlyNoteString() {
        assertThat(highlighter.highlight("note")).isEqualTo("{note}");
    }

    @Test
    public void hasOneNoteString() {
         assertThat(highlighter.highlight("a note")).isEqualTo("a {note}");
    }
}
