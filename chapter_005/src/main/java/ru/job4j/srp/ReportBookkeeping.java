package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportBookkeeping implements Report{
    private final Store store;

    public ReportBookkeeping (Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employer employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append((employee.getSalary() * 1.13)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
    }
