package home;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class QueueMan {

	public class DecreasingComparator implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}	
	}
	
	@Test
	public void testPriorityQueue() {
		Queue<String> pQueue = new PriorityQueue<>(20, new DecreasingComparator());

		pQueue.offer("Rohit");
		pQueue.offer("Samarth");
		pQueue.offer("Sagar");
		pQueue.offer("Asit");
		pQueue.offer("Z");
		pQueue.offer("SagarJauhari");
		pQueue.offer("AsitKachap");
		
		while (pQueue.size() > 0) {
			System.out.println(pQueue.poll());
		}
	}
}
