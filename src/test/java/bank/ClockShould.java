package bank;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClockShould {
    @Test
    public void return_todays_date_in_dd_MM_yyyy_format() {
        Clock clock = new Clock();
        String date = clock.todayAsString();
        assertThat(date, is("24/04/2015"));
    }
}
