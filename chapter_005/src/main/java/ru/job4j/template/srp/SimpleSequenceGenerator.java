package ru.job4j.template.srp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

public class SimpleSequenceGenerator implements SequenceGenerator<Integer> {

    private final NumberGenerator<Integer> numberGenerator;

    public SimpleSequenceGenerator(NumberGenerator<Integer> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public List<Integer> generate(int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .map(i -> random.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}
