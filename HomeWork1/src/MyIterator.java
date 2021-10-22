/**
 * create interface myIterator with Iterator methods
 * @param <E> is for Generics
 */
public interface MyIterator<E> {

    boolean hasNext();

    E next();

    void reset();

}
