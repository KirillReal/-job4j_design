package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.Employer;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import java.util.function.Predicate;

public class ReportXML implements Report {
    private Store store;

    public ReportXML (Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<Employees>");
        for (Employer employee : store.findBy(filter) ) {
            text
                    .append("<Employee>")
                    .append("<Name>")
                    .append(employee.getName())
                    .append("</Name>")
                    .append("<Salary>")
                    .append(employee.getSalary())
                    .append("</Salary>")
                    .append("</Employee>");
        }
        text.append("</Employees>");
        return text.toString();
    }
}
