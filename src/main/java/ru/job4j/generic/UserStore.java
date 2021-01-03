package ru.job4j.generic;

public class UserStore implements Store<User> {

    private final Store<User> userMemStore = new MemStore<>();

    @Override
    public void add(User model) {
        this.userMemStore.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return this.userMemStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.userMemStore.delete(id);
    }

    @Override
    public User findById(String id) {
        return this.userMemStore.findById(id);
    }
}
