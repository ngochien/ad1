/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * @author Le
 */
public interface List<E> {

	int size();

	boolean isEmpty();

	void insert(int index, E element);

	void delete(int index);

	int find(E element);

	E retrieve(int index);

	List<E> concat(List<E> otherList);
}
