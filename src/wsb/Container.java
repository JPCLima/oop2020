package wsb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Container<E> implements Collection<E> {

    public ArrayList<E> list;
    private int counter;

    public Container(){
        list = new ArrayList<>();
    }

    public int getCounter(){
        return counter;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return list.toArray(ts);
    }

    @Override
    public boolean add(E e) {
        boolean r =  list.add(e);
        if(r){
            counter++;
        }
        return r;
    }

    @Override
    public boolean remove(Object o) {
        boolean r = list.remove(o);
        if(r){
            counter++;
        }
        return r;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return list.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean r = list.addAll(collection);
        if(r){
            counter++;
        }
        return r;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean r = list.removeAll(collection);
        if(r){
            counter++;
        }
        return r;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean r = list.retainAll(collection);
        if(r){
            counter++;
        }
        return r;
    }

    @Override
    public void clear() {
        counter++;
        list.clear();
    }
}
