/**
 * Creation of MyArrayList class
 *
 * @param <E> generic elements
 */
public class MyArrayList<E> implements MyList<E> {

    public static void main(String[] args) {
    }

    private E[] array;
    private static final int DEFAULT_SIZE = 5;
    private int size;
    private int index;

    /**
     * Standart constructor
     */
    public MyArrayList() {
        size = 0;
        ensureCapacity(DEFAULT_SIZE);

    }

    /**
     * Constructor with
     *
     * @param capacity
     */
    public MyArrayList(int capacity) {
        size = capacity;
    }

    /**
     * This method check is there enough space in our array
     *
     * @param newCap
     */
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

    /**
     * this method returns size of our array
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method uses two parameters to add new element with selected index
     *
     * @param index
     * @param e
     */
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
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    /**
     * Method takes element with selected index
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    /**
     * Method removes selected index
     *
     * @param index
     */
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

    /**
     * Method set element on selected index
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        E tmp = array[index];
        array[index] = e;
        return tmp;
    }

    /**
     * Add sort method with quicksort
     *
     * @param data
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] data) {
        quicksort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quicksort(T[] data, int low, int high) {
        if (low >= high) return;
        int pivot = partition(data, low, high);
        quicksort(data, low, pivot - 1);
        quicksort(data, pivot + 1, high);
    }

    private static <T extends Comparable<T>> int partition(T[] data, int low, int high) {
        int i = low + 1;
        int j = high;

        while (i <= j) {
            if (data[i].compareTo(data[low]) <= 0) {
                i++;
            } else if (data[j].compareTo(data[low]) > 0) {
                j--;
            } else if (j <= i) {
                break;
            } else
                swap(data, i, j);
        }
        swap(data, low, j);
        return j;
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    /**
     * Method from Iterator interface check is there next element
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    /**
     * Method returns next index element
     *
     * @return
     */
    @Override
    public E next() {
        return array[index++];
    }

    /**
     * Method turns index to 0
     */
    @Override
    public void reset() {
        index = 0;
    }
}
