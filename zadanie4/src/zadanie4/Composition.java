/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie4;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Composition<T> implements Executeable<T>, Iterable<Executeable<T>> {

    private final List<Executeable<T>> list;

    public Composition(Executeable<T>... f) {
        list = new ArrayList();
        list.addAll(Arrays.asList(f));
    }

    public Composition(List<Executeable<T>> f) {
        list = f;
    }

    @Override
    public T execute(T t) {
        for (Executeable<T> f : list) {
            t = f.execute(t);
        }
        return t;
    }

    @Override
    public Iterator<Executeable<T>> iterator() {
        return list.listIterator();
    }

    public void add(Executeable<T> f) {
        list.add(f);
    }
}
