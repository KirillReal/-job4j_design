package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 0, 3);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.removeIf(input, integer -> integer % 2 == 0);
        assertThat(Collections.singletonList(1), Is.is(input));
    }

    @Test
    public void whenReplaseIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.replaceIf(input, integer -> integer == 2, 4);
        assertThat(Arrays.asList(1, 4), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> input1 = new ArrayList<>(Arrays.asList(2, 4, 6));
        ListUtils.removeAll(input, input1);
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }

}