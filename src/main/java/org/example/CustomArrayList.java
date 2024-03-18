package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/*
A class for a custom implementation of a parameterized array list
 with some methods implementing the List interface
*/
public class CustomArrayList<T> implements List<T> {

    /*
    default capacity, when new CustomArrayList is created
    */
    private static final int DEFAULT_CAPACITY = 10;
    /*
    capacity, when CustomArrayList has more elements than default
    */
    private int capacity;
    /*
    numbers of elements in the CustomArrayList
    */
    private int size = 0;
    /*
    array of elements on which CustomArrayList is based
    */
    private Object[] elementData;
    /*
    class of sorting algorithm
    */
    private final QuickSort quickSort;

    /*
    default construct with data initialization
    */
    public CustomArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
        quickSort = new QuickSort();
    }

    /*
    getter for elements number in CustomArrayList
    */
    @Override
    public int size() {
        return size;
    }

    /*
    checking CustomArrayList empty or not
    */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    checking the existence of element in the List
    */
    @Override
    public boolean contains(Object o) {
        for (Object elementData : elementData) {
            if (o.equals(elementData)) {
                return true;
            }
        }
        return false;
    }

    /*
    iteration over CustomArrayList
    */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size && elementData[currentIndex] != null;
            }
            public T next() {
                return (T) elementData[currentIndex++];
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    /*
    not implemented
    */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /*
    not implemented
    */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /*
    adding element to CustomArrayList, if capacity is more than 10 elements, it expands by 6 elements
    */
    @Override
    public boolean add(T t) {
        if (elementData[elementData.length - 1] != null) {
            capacity = capacity + 6;
            elementData = Arrays.copyOf(elementData, capacity);
        }
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == null) {
                elementData[i] = t;
                size++;
                break;
            }
        }
        return true;
    }

    /*
    not implemented
    */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /*
    not implemented
    */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /*
    not implemented
    */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    /*
    not implemented
    */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    /*
    not implemented
    */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /*
    not implemented
    */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /*
    remove all elements from CustomArrayList;
    */
    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /*
    get existing element by index
    */
    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", for length: " + size);
        }
        return (T) elementData[index];
    }

    /*
    not implemented
    */
    @Override
    public T set(int index, T element) {
        return null;
    }

    /*
    adding element to CustomArrayList on existing position by index, if capacity is more than 10 elements,
    it expands by 6 elements
    */
    @Override
    public void add(int index, T element) {
        try {
            if (elementData[elementData.length - 1] != null) {
                capacity = capacity + 6;
                elementData = Arrays.copyOf(elementData, capacity);
            }
            if (elementData[index] != null) {
                for (int i = elementData.length - 1; i > index; i--) {
                    elementData[i] = elementData[i - 1];
                }
                elementData[index] = element;
                size++;
            } else {
                throw new IndexOutOfBoundsException("Index: " + index + ", for length: " + size);
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Index: " + index + ", for length: " + size);
        }
    }
    /*
    removing element from CustomArrayList on existing position by index
    */
    @Override
    public T remove(int index) {
        try {
            if (elementData[index] != null) {
                for (int i = index + 1; i < elementData.length; i++) {
                    elementData[i - 1] = elementData[i];
                }
                size--;
                return (T) elementData[index];
            } else {
                throw new IndexOutOfBoundsException("Index: " + index + ", for length: " + size);
            }
        } catch (Exception exception) {
            throw new IndexOutOfBoundsException("Index: " + index + ", for length: " + size);
        }
    }

    /*
    not implemented
    */
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /*
    not implemented
    */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /*
    not implemented
    */
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    /*
    not implemented
    */
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    /*
    not implemented
    */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    public List<T> sort(){
        return this.stream().sorted().collect(Collectors.toList());
    }

    public void quickSort(){
        quickSort.quickSort(elementData, 0, size - 1);
    }
}
