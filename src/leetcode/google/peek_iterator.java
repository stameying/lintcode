package leetcode.google;

import java.util.Iterator;

/**
 * Created by stameying on 1/13/16.
 */
public class peek_iterator<T> implements Iterator<T> {
    T cache;
    Iterator<T> it;
    public peek_iterator(Iterator<T> iterator){
        this.cache = it.next();
        this.it = iterator;
    }

    public T peek(){
        return cache;
    }

    public T next(){
        T res = cache;
        cache = it.hasNext()?it.next():null;
        return res;
    }

    public boolean hasNext(){
        return it.hasNext() || cache != null;
    }
}
