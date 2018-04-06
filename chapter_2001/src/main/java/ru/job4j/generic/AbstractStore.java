package ru.job4j.generic;

public abstract class AbstractStore<T>  implements Store {

    public SimpleArray<T>  list = new SimpleArray(10);

    @Override
    public void add(Base model) {
        list.add((T) model);
    }

    @Override
    public void add(Object model) {
        list.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean replaceDone = false;
        while (list.hasNext()) {
            Base element = (Base) list.next();
            if (element.getId().equals(id)) {
                list.set(list.index - 1, (T) model);
                replaceDone = true;
                break;
            }
        }
        return replaceDone;
    }

    @Override
    public boolean delete(String id) {
        boolean deleteDone = false;
        while (list.hasNext()) {
            Base element = (Base) list.next();
            if (element.getId().equals(id)) {
                list.delete(list.index - 1);
                deleteDone = true;
                break;
            }
        }
        return deleteDone;
    }

    @Override
    public Base findById(String id) {
       Base element = null;
        while (list.hasNext()) {
            Base tekElement = (Base) list.next();
            if (tekElement.getId().equals(id)) {
                element = tekElement;
                break;
            }
        }
        return element;
    }
}
