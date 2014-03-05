package home;

import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<Object, Object> {

	/*
	 *  SerialVersionUID is a unique identifier for each class, JVM uses it to
	 * compare the versions of the class ensuring that the same class was used
	 * during Serialization and Deserialization
	 */
	private static final long serialVersionUID = 1L;

	private int cacheSize;

	public LRUCache(int capacity) {
		
		// LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
		// AccessOrder: 
		//		the ordering mode - true for access-order, 
		// 		false for insertion-order
		super(2 * capacity, 0.75f, true);

		this.cacheSize = capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
		// Returns true if this map should remove its eldes entry. 
		// Used by Put method
		return size() > cacheSize;
	}
}
