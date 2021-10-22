/**Create Interface MyList extended from MyIterator
 * @param <E>
 */
public interface MyList<E> extends MyIterator<E> {

    int size();
    void add (int index, E e);
    void add(E e);
    E get(int index);
    void remove(int index);
    E set(int index, E e);
    <T extends Comparable> void sort(MyList<E> list);
}
