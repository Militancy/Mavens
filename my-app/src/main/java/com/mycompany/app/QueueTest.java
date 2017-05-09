package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	@Test(expected = IllegalArgumentException.class)
	public void construct() {
		Queue queue = new Queue(0);
	}

	@Test
	public void construct2() {
		Queue queue = new Queue(3);
	}

	@Test(expected = IllegalStateException.class)
	public void emptyDequeue() {
		Queue queue = new Queue(3);
		queue.dequeue();
	}

	@Test
	public void insertQueue() {
		Queue queue = new Queue(3);
		queue.enqueue(2);
		assertEquals("Queue[0] = 2", 2, queue.queue[0]);
	}

	@Test
	public void insertQueueFull() {
		Queue queue = new Queue(3);
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(7);
		assertEquals("Queue[2] = 7", 7, queue.queue[2]);
	}

	@Test
	public void delete() {
		Queue queue = new Queue(3);
		queue.enqueue(2);
		queue.enqueue(4);
		assertEquals("Return Value is 2", 2, queue.dequeue());
	}

	@Test
	public void deleteRing() {
		Queue queue = new Queue(3);
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.enqueue(4);
		assertEquals("Queue[0] = 4", 4, queue.queue[0]);
	}
}