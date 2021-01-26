
package com.iptech;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;
	@Override
	public boolean add(T item) {
		return add(size, item);
	}

	private void increaseSizeOfBackingArray() {
		Object[] newArray = new Object[size*2];
		for(int i=0; i<size; i++) {
			newArray[i] = items[i];
		}
		items = newArray;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index)  throws IndexOutOfBoundsException {
		if(index >= size) throw new IndexOutOfBoundsException();
			return (T) items[index];
	}
	
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if(index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		
		if(size == items.length) {
			increaseSizeOfBackingArray();
		}
		for (int i = size-1; i >index; i--) {
			items[i+1] = items[i];
		}
		items[index] = item;
		size++;
		return true;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if(index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		T removedItem = (T) items[index];
		for (int i = index; i < size-1; i++) {
			items[i] = items[i+1];
		}
		size--;
		return removedItem;
	}
}
