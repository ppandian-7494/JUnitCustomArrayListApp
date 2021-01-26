package com.iptech;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {
	private CustomArrayList<Integer> sut;
	@BeforeEach
	void init() {
		sut = new CustomArrayList();
		for (int i=0; i<20; i++) {
			sut.add(i+1);
		}
	}
	
	@Test
	public void testAddToMiddleOfSmallArrayList() {
		sut.add(9,100);

		Integer actual = sut.get(9);
		Integer expected = 100;
		assertEquals(expected, actual);
	}

	@Test
	public void testAddToMiddleOfLargeArrayList() {
		for (int i=0; i<100000; i++) {
			sut.add(i);
		}

		sut.add(90000,-5);

		assertEquals(-5, sut.get(90000));
		assertEquals(100021, sut.getSize());
	}
	
	@Test
	public void testAddToBeginningOfSmallArrayList() {
		sut.add(0,-5);

		assertEquals(-5, sut.get(0));
		assertEquals(21, sut.getSize());
	}
	
	@Test
	public void testAddToEndOfSmallArrayList() {
		sut.add(20,-5);

		assertEquals(-5, sut.get(20));
		assertEquals(21, sut.getSize());
	}
	
	@Test
	public void testRemoveFromBeginningOfSmallArrayList() {
		Integer itemRemoved = sut.remove(0);

		assertEquals(1, itemRemoved);
		assertEquals(19, sut.getSize());
		assertEquals(2, sut.get(0));
		assertEquals(20, sut.get(sut.getSize()-1));
	}
	
	@Test
	public void testRemoveFromMiddleOfSmallArrayList() {
		Integer itemRemoved = sut.remove(10);

		assertEquals(11, itemRemoved);
		assertEquals(19, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(20, sut.get(sut.getSize()-1));
	}
	
	@Test
	public void testRemoveFromEndOfSmallArrayList() {
		Integer itemRemoved = sut.remove(19);

		assertEquals(20, itemRemoved);
		assertEquals(19, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(19, sut.get(sut.getSize()-1));
	}
	
	@Test
	public void testRemoveFromMiddleOfLargeArrayList() {
		for (int i=0; i<100000; i++) {
			sut.add(i);
		}

		Integer itemRemoved = sut.remove(60000);

		assertEquals(59980, itemRemoved);
		assertEquals(100019, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(99999, sut.get(sut.getSize()-1));
	}
	
	@Test
	public void testRemoveFromEndOfLargeArrayList() {
		for (int i=0; i<100000; i++) {
			sut.add(i);
		}
		Integer itemRemoved = sut.remove(100019);
		assertEquals(99999, itemRemoved);
		assertEquals(100019, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(99998, sut.get(sut.getSize()-1));
	}
	
	@Test
	public void testIndexOutOfBoundryExceptionOnGet() {
		try {
			sut.get(20);
			fail("Failed to get an IndexOutOfBoundryException");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Failed to get an IndexOutOfBoundryException");
	}
	
	@Test
	public void testIndexOutOfBoundryExceptionOnRemove() {
		try {
			sut.remove(20);
			fail("Failed to get an IndexOutOfBoundryException");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Failed to get an IndexOutOfBoundryException");
	}
	
	@Test
	public void testIndexOutOfBoundryExceptionOnAdd() {
		try {
			sut.add(21, -5);
			fail("Failed to get an IndexOutOfBoundryException");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Failed to get an IndexOutOfBoundryException");
	}
}
