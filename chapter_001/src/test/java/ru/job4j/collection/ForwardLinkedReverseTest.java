package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ForwardLinkedReverseTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinkedReverse<Integer> linked = new ForwardLinkedReverse<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedReverse<Integer> linked = new ForwardLinkedReverse<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }
}