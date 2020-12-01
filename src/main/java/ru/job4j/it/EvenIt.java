package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer>{
    private int pos;

    private final int[] numbers;

    public EvenIt (int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while(numbers[pos] % 2 != 0 && pos < numbers.length - 1){
            pos++;
        }
        return numbers[pos] % 2 == 0;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше чётных элементов нет");
        }
        return numbers[pos++];
    }
}
