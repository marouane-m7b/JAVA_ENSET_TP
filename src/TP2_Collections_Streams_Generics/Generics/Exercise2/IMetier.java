package TP2_Collections_Streams_Generics.Generics.Exercise2;

import java.util.List;

public interface IMetier<T> {
    void add(T o);
    List<T> getAll();
    T findById(long id);
    void delete(long id);
}
