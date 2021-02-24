package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report{

    private Store store;

    public ReportProgrammer (Store store){
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><body>").append("<p>Name; Hired; Fired; Salary;</p>");
        for (Employer employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>");
        }
        text.append("</body></html>");
        return text.toString();
    }
}
