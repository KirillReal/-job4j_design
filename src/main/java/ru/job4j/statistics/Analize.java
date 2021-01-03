package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, String> allUsers = new HashMap<>();

        for (User index: current) {
            allUsers.put(index.getId(), index.getName());
        }
        for (User index: previous) {
            if (!allUsers.containsKey(index.getId())) {
                result.setDeleted(result.getDeleted() + 1);
            } else if (!allUsers.get(index.getId()).equals(index.getName())) {
                result.setChanged((result.getChanged() + 1));
            }
            allUsers.put(index.getId(), index.getName());
        }
        int added = current.size() + result.getDeleted() - previous.size();
        result.setAdded(result.getAdded() + added);
        return result;
    }

    public static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class Info {
       private int added = 0;
       private int changed = 0;
       private int deleted = 0;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public void setAdded(int added) {
            this.added = added;
        }
    }
}
