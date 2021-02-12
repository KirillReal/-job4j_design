package ru.job4j.generic;

public class RoleStore<Role extends Base> implements Store<Role> {
    private final Store<Role> roleMemStore = new MemStore<>();

    @Override
    public void add(Role model) {
        this.roleMemStore.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return this.roleMemStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.roleMemStore.delete(id);
    }

    @Override
    public Role findById(String id) {
        return this.roleMemStore.findById(id);
    }
}
