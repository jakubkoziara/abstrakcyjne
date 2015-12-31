/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Kuba
 */
import java.util.Iterator;

public class TripleList<T> implements Iterable<TripleList<T>> {

    private T value;
    private TripleList<T> prev;
    private TripleList<T> next;
    private TripleList<T> middle;
    private TripleList<T> triplelist;

    public TripleList() {

        this.prev = null;
        this.next = null;
        this.middle = null;
        this.value = null;

    }

    public TripleList(T value) {
        this();
        this.value = value;

    }

    public T getValue() {
        return value;
    }

    public TripleList<T> getNext() {
        return next;
    }

    public TripleList<T> getPrev() {
        return prev;
    }

    public TripleList<T> getMiddle() {
        return middle;
    }

    public void add(T value) {
        triplelist = new TripleList<>(value);

        if (this.value == null) {
            this.value = value;
        } else if (this.middle == null) {
            triplelist.middle = this;
            this.middle = triplelist;
        } else {

            TripleList<T> temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            if (temp.middle == null) {
                triplelist.middle = temp;
                temp.middle = triplelist;
            } else {
                triplelist.prev = temp;
                temp.next = triplelist;
            }

        }
    }

    boolean isNull(TripleList<T> list) {
        return list == null;
    }

    public int Counting() {

        int count = 0;

        TripleList<T> list = this;

        while (!isNull(list)) {

            if (list.value != null) {
                count++;
            }
            if (list.middle != null) {
                count++;
            }

            list = list.next;
        }

        return count;
    }

    @Override
    public Iterator<TripleList<T>> iterator() {
        return new TripleListIterator(this);
    }

    class TripleListIterator implements Iterator {

        private TripleList<T> elem;
        private boolean middle;

        public TripleListIterator(TripleList<T> pointer) {
            this.elem = pointer;
            this.middle = false;
        }

        @Override
        public TripleList<T> next() {

            if (this.middle) {

                TripleList<T> temp = this.elem.middle;
                this.elem = this.elem.next;

                this.middle = false;

                return temp;

            } else {
                this.middle = true;
                return this.elem;
            }
        }

        @Override
        public boolean hasNext() {

            return (this.middle == false && this.elem.value != null)
                    || (this.middle && this.elem.middle != null && this.elem.middle.value != null);

        }

    }

}
