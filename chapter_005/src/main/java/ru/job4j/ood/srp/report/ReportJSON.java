package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.Employer;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

   public ReportJSON (Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{");
        for (int i = 0; i < store.findBy(filter).size(); i++) {
            text.append("\"").append(i).append("\": ")
                    .append("{").append("\"Name\": \"")
                    .append(store.findBy(filter).get(i).getName()).append("\",")
                    .append("\"Salary\": ").append(store.findBy(filter).get(i).getSalary());
            if (i + 1 == store.findBy(filter).size()) {
                text.append("}");
            } else {
                text.append("},");
            }
        }
        text.append("}");
        return text.toString();
    }
}
