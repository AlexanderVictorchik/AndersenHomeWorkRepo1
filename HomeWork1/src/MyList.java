/**Create Interface MyList extended from MyIterator with some List methods
 * @param <E>
 */
public interface MyList<E> extends MyIterator<E> {

    int size();
    void add (int index, E e);
    boolean add(E e);
    E get(int index);
    void remove(int index);
    E set(int index, E e);
    <T extends Comparable<T>> void sort(T[] a);
}
