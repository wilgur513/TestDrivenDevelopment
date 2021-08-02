package highlight;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HighlightTest {
    @Test
    public void notHasNoteString() {
        Highlighter highlighter = new Highlighter();
        assertThat(highlighter.highlight("abc")).isEqualTo("abc");
        assertThat(highlighter.highlight("asdf")).isEqualTo("asdf");
    }
}
