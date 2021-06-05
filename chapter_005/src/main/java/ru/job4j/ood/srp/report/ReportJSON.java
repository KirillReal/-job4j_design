package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.Employer;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.Store;

import java.util.function.Predicate;

public class ReportJSON implements Report {

    private final Store store;

   public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        final Gson gson = new GsonBuilder().create();
        for (Employer employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(gson.toJson(employee));
        }
        return text.toString();
    }
}
