package ru.job4j.io.statistics;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;
import ru.job4j.statistics.Analize.User;
import ru.job4j.statistics.Analize.Info;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void diff() {
        User userPrev1 = new User(1, "One");
        User userPrev2 = new User(2, "Two");
        User userPrev3 = new User(3, "Tree");

        List<User> previous =
                Arrays.asList(userPrev1, userPrev2, userPrev3);

        User userCurr2 = new User(2, "Two");
        User userCurr3 = new User(3, "Fix");
        User userCurr4 = new User(4, "Changed");

        List<User> current =
                Arrays.asList(userCurr2, userCurr3, userCurr4);

        ru.job4j.statistics.Analize analize = new ru.job4j.statistics.Analize();
        Info result = analize.diff(previous, current);
        assertThat(result.getDeleted(), is(1));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getAdded(), is(1));
    }
}