/**
 * Creation of MyArrayList class
 *
 * @param <E> generic elements
 */
public class MyArrayList<E> implements MyList<E> {

    private E[] array;
    private static final int DEFAULT_SIZE = 5;
    private int size = 0;
    private int index = 0;

    public MyArrayList() {
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private void ensureCapacity(int newCap) {
        if (size > newCap) return;
        E[] tmp = array;
        array = (E[]) new Object[newCap];
        for (int i = 0; i < size(); i++) {
            array[i] = tmp[i];
        }
    }

    private void trimToSizeArray() {
        ensureCapacity(size());
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(int index, E e) {
        if (array.length == size()) ensureCapacity(size() * 2 + 1);
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
    }


    @Override
    public void add(E e) {
        if (array.length == size()) ensureCapacity(size() + 1);
        add(size(), e);
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public void remove(int index) {
        Object[] tmp = array;
        array = (E[]) new Object[tmp.length - 1];
        System.arraycopy(tmp, index + 1, array,
                0, index);
        int supp = tmp.length - index - 1;
        System.arraycopy(tmp, index + 1,
                array, index, supp);
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        E tmp = array[index];
        array[index] = e;
        return tmp;
    }


    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public E next() {
        return array[index++];
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public <T extends Comparable> void sort(MyList<E> list) {

    }

}
