package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportHR implements Report{
    private final Store store;

    public ReportHR (Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        store.findBy(filter).sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employer employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
