import java.util.Iterator;

/**
 * create new class myIterator that implements iterator interface
 * @param <E> is for Generics
 */
public class MyIterator<E> implements Iterator<E>{

    int index = 0;
    E[] iteratorArrayValue;

    /** create constructor
     * @param iteratorArrayValue
     */
    public MyIterator(E[] iteratorArrayValue) {
        this.iteratorArrayValue = iteratorArrayValue;
    }

    /**override iterator methods
     * @return comparison between length of array and index
     */
    @Override
    public boolean hasNext() {
        return iteratorArrayValue.length > index;
    }

    /**
     * @return next value of the array
     */
    @Override
    public E next() {
        return iteratorArrayValue[++index];
    }
}
