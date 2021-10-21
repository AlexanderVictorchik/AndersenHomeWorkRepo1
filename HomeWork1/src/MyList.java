//создаем интерфейс лист и добавляем методы.

/**Create Interface MyList extended from Iterable
 * @param <E>
 */
public interface MyList<E> extends Iterable<E> {

    boolean add(E e);
    E get(int index);
    int size();
    void remove(int index);
    void renew(int index, E e);

}
