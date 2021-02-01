package com.codigo.smartstore.sdk.core;

import java.util.Random;

class TestMe {

	public static void main(final String[] args) {

		final var drop = new Drop();

		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();

		// final String str1 = new String("s1");// false
		// final String str2 = new String("s1");// true
		final String str1 = "s1";// true
		final String str2 = "s1";// true
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
	}
}

class Drop {

	// Message sent from producer
	// to consumer.
	private String message;
	// True if consumer should wait
	// for producer to send message,
	// false if producer should wait for
	// consumer to retrieve message.
	private boolean empty = true;

	public synchronized String take() {

		// Wait until message is
		// available.
		while (this.empty)
			try {

				this.wait();
			} catch (final InterruptedException e) {

			}
		// Toggle status.
		this.empty = true;
		// Notify producer that
		// status has changed.
		this.notifyAll();
		return this.message;
	}

	public synchronized void put(final String message) {

		// Wait until message has
		// been retrieved.
		while (!this.empty)
			try {

				this.wait();
			} catch (final InterruptedException e) {

			}
		// Toggle status.
		this.empty = false;
		// Store message.
		this.message = message;
		// Notify consumer that status
		// has changed.
		this.notifyAll();
	}
}

class Producer
	implements Runnable {

	private final Drop drop;

	public Producer(final Drop drop) {

		this.drop = drop;
	}

	@Override
	public void run() {

		final String importantInfo[] = {
			"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too", "232323", "13123",
			"123123" };
		final Random random = new Random();

		for (final String element : importantInfo) {

			this.drop.put(element);

			try {

				Thread.sleep(random.nextInt(5000));
			} catch (final InterruptedException e) {

			}
		}
		this.drop.put("DONE");
	}
}

class Consumer
	implements Runnable {

	private final Drop drop;

	public Consumer(final Drop drop) {

		this.drop = drop;
	}

	@Override
	public void run() {

		final Random random = new Random();

		for (String message = this.drop.take(); !message.equals("DONE"); message = this.drop.take()) {

			System.out.format("MESSAGE RECEIVED: %s%n", message);

			try {

				Thread.sleep(random.nextInt(5000));
			} catch (final InterruptedException e) {

			}
		}
	}
}