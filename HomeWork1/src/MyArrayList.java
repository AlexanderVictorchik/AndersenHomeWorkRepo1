import java.util.Iterator;

/** Creation of MyArrayList class
 * @param <E> generic elements
 */
public class MyArrayList<E> implements MyList<E> {
    private E[] myArrayListValues;
    private static final int DEF_CAP = 10;

    public MyArrayList() {
        myArrayListValues = (E[]) new Object[DEF_CAP];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] tmp = myArrayListValues;
            myArrayListValues = (E[]) new Object[tmp.length + 1];
            System.arraycopy(tmp, 0, myArrayListValues, 0, tmp.length);
            myArrayListValues[myArrayListValues.length - 1] = e;
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return myArrayListValues[index];
    }

    @Override
    public int size() {
        return myArrayListValues.length;
    }

    @Override
    public void remove(int index) {
        try {
            E[] tmp = myArrayListValues;
            myArrayListValues = (E[]) new Object[tmp.length - 1];
            System.arraycopy(tmp, index + 1, myArrayListValues,
                    0, index);
            int supp = tmp.length - index - 1;
            System.arraycopy(tmp, index + 1,
                    myArrayListValues, index, supp);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void renew(int index, E e) {
        myArrayListValues[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(myArrayListValues);
    }

}
