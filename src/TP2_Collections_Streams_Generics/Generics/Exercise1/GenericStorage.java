package TP2_Collections_Streams_Generics.Generics.Exercise1;

import java.util.ArrayList;
import java.util.List;

public class GenericStorage<T> {
    private List<T> elements = new ArrayList<>();

    public void addElement(T o) {
        elements.add(o);
    }

    public void removeElement(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
        }
    }

    public T getElement(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }

    public int getSize() {
        return elements.size();
    }
}
