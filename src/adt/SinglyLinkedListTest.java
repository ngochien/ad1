/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Le
 */
public class SinglyLinkedListTest {

	List<Integer> list;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new SinglyLinkedList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#insert(int, java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		for (int i = 0; i < 100; i++) {
			list.insert(i, i);
		}
		assertEquals(100, list.size());
		for (int i = 0; i < 100; i++) {
			assertEquals(i, list.find(i));
		}
		list.insert(0, 1000);
		assertEquals(101, list.size());
		assertEquals(0, list.find(1000));
		assertEquals(1, list.find(0));
		assertEquals(100, list.find(99));

		list.insert(list.size(), 2000);
		assertEquals(list.size(), list.find(2000));
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#delete(int)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#find(java.lang.Object)}.
	 */
	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#retrieve(int)}.
	 */
	@Test
	public void testRetrieve() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#concat(adt.List)}.
	 */
	@Test
	public void testConcat() {
		fail("Not yet implemented");
	}

}
