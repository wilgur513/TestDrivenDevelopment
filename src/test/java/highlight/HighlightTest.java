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

    @Test
    public void hasPrevCharacterNoteString() {
        assertThat(highlighter.highlight("anote note keynote")).isEqualTo("anote {note} keynote");
    }

    @Test
    public void hasPostCharacterNoteString() {
        assertThat(highlighter.highlight("notebook note note1 note2 note"))
                .isEqualTo("notebook {note} note1 note2 {note}");
    }

    @Test
    public void complicateString() {
        assertThat(highlighter.highlight("note note note1 keynote notebook note"))
            .isEqualTo("{note} {note} note1 keynote notebook {note}");
    }
}
