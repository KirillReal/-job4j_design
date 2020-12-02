package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public class MemStore <T extends Base> implements Store<T> {
    private final List<T> list = new ArrayList<>();

    private int indexOf(String id){
        int indexOfList = - 1;
        for(int i = 0; i < list.size();i++){
            if(this.list.get(i).equals(indexOfList)){
                indexOfList = i;
                break;
            }
        }
        return indexOfList;
    }
    @Override
    public void add(T model) {
        this.list.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = this.indexOf(id);
        if(index != -1){
            this.list.set(index,model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = this.indexOf(id);
        if(index != -1){
            this.list.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T findId = null;
        int index = this.indexOf(id);
        if(index != -1){
            findId = this.list.get(index);
        }
        return findId;
    }
}
