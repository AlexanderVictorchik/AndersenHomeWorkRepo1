/**
 * create new class myIterator that implements iterator interface
 * @param <E> is for Generics
 */
public interface MyIterator<E> {

    boolean hasNext();

    E next();

    void reset();

}
